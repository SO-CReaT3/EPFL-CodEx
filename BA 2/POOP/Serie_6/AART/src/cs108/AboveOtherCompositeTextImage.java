package cs108;

import java.util.StringJoiner;

public final class AboveOtherCompositeTextImage implements TextImage {
    private final TextImage initialImage;

    private String imageString;
    private int width;
    private int height;

    public AboveOtherCompositeTextImage(TextImage image) {
        this.initialImage = image;
        this.width = image.width();
        this.height = image.height();
    }

    public AboveOtherCompositeTextImage above(TextImage that) {
        StringBuilder composite = new StringBuilder();

        for (int h = 0; h < this.height(); h++) {
            for (int w = 0; w < Math.max(this.width(), that.width()); w++) {
                if (w > this.width() - 1) composite.append(" ");
                else composite.append(initialImage.charAt(w, h));
            }
        }

        for (int h = 0; h < that.height(); h++) {
            for (int w = 0; w < Math.max(this.width(), that.width()); w++) {
                if (w > that.width() - 1) composite.append(" ");
                else composite.append(that.charAt(w, h));
            }
        }

        width = Math.max(this.width(), that.width());
        height = this.height + that.height();

        System.out.println("Width: " + width + " Height: " + height);

        imageString = composite.toString();

        return this;
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
        return imageString.charAt(y * width + x);
    }
}
