import java.util.Random;

import org.junit.Test;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;


public class AnswerTest {


    protected String leftWindow = "X=5 Y=9 W=10 H=40";
    protected String middleWindow = "X=16 Y=9 W=10 H=40";
    protected String getLeftWindow = "X=6 Y=1 W=1 H=1";


    @Test
    public void should_return_identical_dimensions_for_single_window() {
        Window enclosingWindow = Answer.getEnclosing(new String[]{leftWindow});
        assertThat(enclosingWindow, WindowMatcher.isWindow(enclosingWindow));

    }
    @Test
    public void should_return_enclosing_coordinates() {
        Window enclosing = Answer.getEnclosing(new String[]{leftWindow, middleWindow});
        Window expected = Window.fromStringDimensions("X=5 Y=9 W=21 H=40");
        assertThat(enclosing, WindowMatcher.isWindow(expected));
    }

    @Test
    public void should_return_closing_over_three_windows() {
        Window enclosing = Answer.getEnclosing(new String[]{"X=0 Y=1 W=1 H=1", "X=3 Y=2 W=1 H=2", "X=6 Y=1 W=1 H=1"});
        Window expected = new Window.Builder().withXPosition(0)
                                              .withYPosition(1)
                                              .withWidth(7)
                                              .withHeight(3).build();
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