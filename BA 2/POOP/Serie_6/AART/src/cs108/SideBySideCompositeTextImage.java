package cs108;

import java.util.StringJoiner;

public final class SideBySideCompositeTextImage implements TextImage {
    TextImage image;
    int width;
    int height;

    public SideBySideCompositeTextImage(TextImage image) {
        this.image = image;
        this.width = image.width();
        this.height = image.height();
    }

    public SideBySideCompositeTextImage leftOf(TextImage that) {
        StringJoiner composite = new StringJoiner("\n");

        for (int h = 0; h < Math.max(this.height(), that.height()); h++) {
            StringBuilder line = new StringBuilder();

            for (int w = 0; w < this.width(); w++) {
                if (h > this.height() - 1) line.append(" ");
                else line.append(this.charAt(w, h));
            }

            for (int w = 0; w < that.width(); w++) {
                if (h > that.height() - 1) line.append(" ");
                 else line.append(that.charAt(w, h));
            }

            composite.add(line.toString());
        }

        width = this.width() + that.width();
        height = Math.max(this.height(), that.height());

        return new SideBySideCompositeTextImage(new OneLineTextImage(composite.toString()));
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
        return image.charAt(x, y);
    }
}
