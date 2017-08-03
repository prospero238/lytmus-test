public class Window {
    int xPosition;
    int yPosition;
    int height;
    int width;

    public Window(int xPosition, int yPosition, int height, int width) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.height = height;
        this.width = width;
    }

    public static Window fromStringDimensions(String windowDescriptor) {
        String[] windowDescription = windowDescriptor.split(" ");
        int xPos = 0;
        int yPos = 0;
        int width = 0;
        int height = 0;
        for (int i = 0; i < windowDescription.length; i++) {
            String windowDescriptorPart = windowDescription[i];
            if (windowDescriptorPart.startsWith("X")) {
                int geometryValue = extractValue(windowDescriptorPart);
                xPos = geometryValue;
            } else if (windowDescriptorPart.startsWith("Y")) {
                yPos = extractValue(windowDescriptorPart);
            } else if (windowDescriptorPart.startsWith("W")) {
                width = extractValue(windowDescriptorPart);
            } else if (windowDescriptorPart.startsWith("H")) {
                height = extractValue(windowDescriptorPart);
            }

        }
        return new Builder().withHeight(height)
                                   .withWidth(width)
                                   .withXPosition(xPos)
                                   .withYPosition(yPos)
                                   .build();
    }

    private static int extractValue(String geometryIdentifier) {
        String value = geometryIdentifier.substring(geometryIdentifier.indexOf("=") + 1);
        return Integer.parseInt(value);
    }


    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "X=" + xPosition +
                " Y=" + yPosition +
                " W=" + width +
                " H=" + height;

    }

    public static class Builder {
        private int xPosition;
        private int yPosition;
        private int height;
        private int width;

        protected Builder() {
        }

        public static Builder window() {
            return new Builder();
        }

        public Builder withXPosition(int xPosition) {
            this.xPosition = xPosition;
            return this;
        }

        public Builder withYPosition(int yPosition) {
            this.yPosition = yPosition;
            return this;
        }

        public Builder withHeight(int height) {
            this.height = height;
            return this;
        }

        public Builder withWidth(int width) {
            this.width = width;
            return this;
        }

        public Window build() {
            return new Window(this.xPosition, this.yPosition, this.height, this.width);
        }

    }
}
