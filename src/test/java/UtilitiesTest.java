import org.junit.Test;
import org.junit.experimental.categories.Category;

import testclassifications.FastTest;
import testclassifications.SlowTest;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UtilitiesTest {

    @Category(FastTest.class)
    @Test
    public void getAnswer() {
        assertThat(Utilities.getAnswer(), is(42));
    }

    @Category(SlowTest.class)
    @Test
    public void thinkBeforeAnswering() {
        assertThat(Utilities.thinkBeforeAnswering(), is(42));
    }
}