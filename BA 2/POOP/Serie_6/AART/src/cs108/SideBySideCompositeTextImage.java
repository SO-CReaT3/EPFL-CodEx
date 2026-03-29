package cs108;

import java.util.StringJoiner;

public final class SideBySideCompositeTextImage implements TextImage {
    private TextImage image;

    private String imageString;
    private int width;
    private int height;

    public SideBySideCompositeTextImage(TextImage image) {
        this.image = image;
        this.width = image.width();
        this.height = image.height();
    }

    public SideBySideCompositeTextImage leftOf(TextImage that) {
        StringBuilder composite = new StringBuilder();

        for (int h = 0; h < Math.max(this.height(), that.height()); h++) {
            for (int w = 0; w < this.width(); w++) {
                if (h > this.height() - 1) composite.append(" ");
                else composite.append(image.charAt(w, h));
            }

            for (int w = 0; w < that.width(); w++) {
                if (h > that.height() - 1) composite.append(" ");
                else composite.append(that.charAt(w, h));
            }
        }

        width = this.width() + that.width();
        height = Math.max(this.height(), that.height());

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
        return imageString.charAt(y * width + x);
    }
}
