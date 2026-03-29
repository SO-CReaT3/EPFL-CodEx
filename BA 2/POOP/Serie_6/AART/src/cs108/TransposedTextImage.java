package cs108;

public final class TransposedTextImage implements TextImage {
    private final TextImage image;

    public TransposedTextImage(TextImage image) {
        StringBuilder imageStringBuilder = new StringBuilder();
        for (int column = 0; column < image.width(); column++) {
            for (int line = 0; line < image.height(); line++) {
                imageStringBuilder.append(image.charAt(column, line));
            }
        }

        this.image = TextImage.fromString(imageStringBuilder.toString());
    }

    @Override
    public int width() {
        return image.height();
    }

    @Override
    public int height() {
        return image.width();
    }

    @Override
    public char charAt(int x, int y) {
        return image.charAt(y, x);
    }
}
