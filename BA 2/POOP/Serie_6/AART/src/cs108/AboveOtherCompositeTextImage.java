package cs108;

import java.util.StringJoiner;

public final class AboveOtherCompositeTextImage implements TextImage {
    private TextImage image;

    private String imageString;
    private int width;
    private int height;

    public AboveOtherCompositeTextImage(TextImage image) {
        this.image = image;
        this.width = image.width();
        this.height = image.height();
    }

    public AboveOtherCompositeTextImage above(TextImage that) {
        StringBuilder composite = new StringBuilder();

        for (int h = 0; h < this.height(); h++) {
            for (int w = 0; w < Math.max(this.width(), that.width()); w++) {
                if (w > this.width() - 1) composite.append(" ");
                else composite.append(image.charAt(w, h));
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

        imageString = composite.toString();
        image = this;

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
        return (imageString == null) ? image.charAt(x, y) : imageString.charAt(y * width + x);
    }
}
