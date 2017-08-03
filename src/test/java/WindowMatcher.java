import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class WindowMatcher extends TypeSafeMatcher<Window> {
    Window expected;

    public WindowMatcher(Window expected) {
        this.expected = expected;
    }

    public static WindowMatcher isWindow(Window window) {
        return new WindowMatcher(window);
    }

    protected boolean matchesSafely(Window window) {
        return expected.getYPosition() == window.getYPosition() &&
                expected.getXPosition() == window.getXPosition() &&
                expected.getWidth() == window.getWidth() &&
                expected.getHeight() == window.getHeight();

    }

    public void describeTo(Description description) {
        description.appendText("is ").appendValue(expected);

    }
}
