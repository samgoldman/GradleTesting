import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.api.FxAssert.verifyThat;

import static org.testfx.util.DebugUtils.captureScreenshot;

import org.loadui.testfx.GuiTest;

import static org.hamcrest.Matchers.*;

import static org.junit.Assert.*;
import static org.testfx.util.DebugUtils.informedErrorMessage;

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

    @Test
    public void testEnglishInput () {
        Label label = (Label) GuiTest.find("#label");

        clickOn("#inputField");
        write("This is a test!");
        clickOn("#applyButton");
        verifyThat(label.getText(), is("This is a test!"), informedErrorMessage(this));
    }

    @Test
    public void testNumericalInput () {
        Label label = (Label) GuiTest.find("#label");

        clickOn("#inputField");
        write("123456789");
        clickOn("#applyButton");
        verifyThat(label.getText(), is("123456789"), informedErrorMessage(this));
    }

}