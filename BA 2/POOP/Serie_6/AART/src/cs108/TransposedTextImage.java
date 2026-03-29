package cs108;

public final class TransposedTextImage implements TextImage {
    private final String imageString;
    private final int width;
    private final int height;

    public TransposedTextImage(TextImage image) {
        this.width = image.height();
        this.height = image.width();

        StringBuilder imageStringBuilder = new StringBuilder();

        for (int column = 0; column < image.width(); column++) {
            for (int line = 0; line < image.height(); line++) {
                imageStringBuilder.append(image.charAt(column, line));
            }
        }

        this.imageString = imageStringBuilder.toString();
    }

    @Override
    public int width() {
        return width;
    }

    @Override
    public int height() {
        return height;
    }

    @Override
    public char charAt(int x, int y) {
        return imageString.charAt(x * width + y);
    }
}
