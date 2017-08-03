import java.util.ArrayList;
import java.util.List;

public class Answer {

    public static void main(String[] args) {


    }

    public String getEnclosingRectangle(String windowDims[]) {
        Window enclosingWindow = getEnclosing(windowDims);
        if (enclosingWindow != null) {
            return enclosingWindow.toString();
        } else {
            return "";
        }
    }

    public Window getEnclosing(String[] windowDims) {
        List<Window> windows = new ArrayList<Window>();
        for (int i = 0; i < windowDims.length; i++) {
            String windowDim = windowDims[i];
            Window window = Window.fromStringDimensions(windowDim);
            windows.add(window);
        }
        return getEnclosingRectangle(windows);
    }

    public Window getEnclosingRectangle(List<Window> windows) {
        Integer leastX = null;
        Integer leastY = null;
        Integer mostX = null;
        Integer mostY = null;
        for (int i = 0; i < windows.size(); i++) {
            Window window = windows.get(i);
            if (leastX == null || window.getXPosition() < leastX) {
                leastX = window.getXPosition();
            }
            int rightX = window.getXPosition() + window.getWidth();
            if (mostX == null || rightX > mostX) {
                mostX = rightX;
            }

            if (leastY == null || window.getYPosition() < leastY) {
                leastY = window.getYPosition();

            }
            int upperY = window.getYPosition() + window.getHeight();
            if (mostY == null || upperY > mostY) {
                mostY = upperY;
            }
        }


        int enclosingWidth = mostX - leastX;
        int enclosingHeight = mostY - leastY;

        return new Window.Builder().withXPosition(leastX)
                                   .withWidth(enclosingWidth)
                                   .withYPosition(leastY)
                                   .withHeight(enclosingHeight).build();
    }

}
