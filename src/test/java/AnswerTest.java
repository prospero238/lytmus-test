import java.util.Random;

import org.junit.Test;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;


public class AnswerTest {


    protected String rightWindow = "X=5 Y=9 W=10 H=40";
    protected String leftWindow = "X=16 Y=9 W=10 H=40";

    @Test
    public void should_return_identical_dimensions_for_single_window() {
        Window enclosingWindow = Answer.getEnclosing(new String[]{rightWindow});
        assertThat(enclosingWindow, WindowMatcher.isWindow(enclosingWindow));

    }
    @Test
    public void should_return_enclosing_coordinates() {
        Window enclosing = Answer.getEnclosing(new String[]{rightWindow, leftWindow});
        Window expected = Window.fromStringDimensions("X=5 Y=9 W=21 H=40");
        assertThat(enclosing, WindowMatcher.isWindow(expected));
    }

    @Test
    public void should_implement_expected_toString() {
        Random random = new Random(2);
        Window window = new Window(random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt());
        String readableValue = window.toString();
        assertThat(readableValue, containsString("W=" + window.getWidth()));
        assertThat(readableValue, containsString("H=" + window.getHeight()));
        assertThat(readableValue, containsString("X=" + window.getXPosition()));
        assertThat(readableValue, containsString("Y=" + window.getYPosition()));

    }

}