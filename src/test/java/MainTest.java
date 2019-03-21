import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import org.loadui.testfx.GuiTest;

import testclassifications.UiTest;
import testclassifications.FastTest;
import testclassifications.SlowTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.testfx.api.FxAssert.verifyThat;
import static org.hamcrest.Matchers.is;
import static org.testfx.util.DebugUtils.informedErrorMessage;

@Category(UiTest.class)
public class MainTest extends ApplicationTest {

    @Override
    public void start (Stage stage) throws Exception {
        Parent mainNode = FXMLLoader.load(Main.class.getResource("sample.fxml"));
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }

    @Before
    public void setUp () throws Exception {
    }

    @After
    public void tearDown () throws Exception {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    @Category(FastTest.class)
    @Test
    public void testNumericalInput () {
        Label label = (Label) GuiTest.find("#label");

        clickOn("#inputField");
        write("123456789");
        clickOn("#applyButton");
        verifyThat(label.getText(), is("123456789"), informedErrorMessage(this));
    }

    @Category(SlowTest.class)
    @Test
    public void testEnglishInput () {
        Label label = (Label) GuiTest.find("#label");

        clickOn("#inputField");
        write("This is a test!");

        long start = System.nanoTime();
        while (System.nanoTime() - start < 30_000_000_000L) {
            // Wait 30 seconds
        }

        clickOn("#applyButton");
        verifyThat(label.getText(), is("This is a test!"), informedErrorMessage(this));
    }

//    @Category(SlowTest.class)
//    @Test
//    public void randomTest () {
//        List<Window> windows = this.listWindows();
//
//        verifyThat(windows.size(), is(1), informedErrorMessage(this));
//
//        Window window = windows.get(0);
//
//        verifyThat(window.widthProperty().doubleValue(), is(600.0), informedErrorMessage(this));
//        verifyThat(window.heightProperty().doubleValue(), is(400.0), informedErrorMessage(this));
//
//        double x = window.getX();
//        double y = window.getY();
//
//        Random random = new Random();
//
//        long start = System.nanoTime();
//        while (System.nanoTime() - start < 5_000_000_000L) {
//            Point2D point = new Point2D((float) random.nextInt(600) + x, (float) random.nextInt(400) + y);
//            this.clickOn(point);
//        }
//    }
}