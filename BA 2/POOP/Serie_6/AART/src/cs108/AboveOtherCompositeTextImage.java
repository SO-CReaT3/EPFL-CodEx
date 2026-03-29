package cs108;

import java.util.StringJoiner;

public final class AboveOtherCompositeTextImage implements TextImage {
    TextImage image;
    int width;
    int height;

    public AboveOtherCompositeTextImage(TextImage image) {
        this.image = image;
        this.width = image.width();
        this.height = image.height();
    }

    public AboveOtherCompositeTextImage above(TextImage that) {
        StringJoiner composite = new StringJoiner("\n");

        for (int h = 0; h < this.height(); h++) {
            StringBuilder line = new StringBuilder();

            for (int w = 0; w < Math.max(this.width(), that.width()); w++) {
                if (w > this.width() - 1) line.append(" ");
                else line.append(this.charAt(w, h));
            }

            composite.add(line.toString());
        }

        for (int h = 0; h < that.height(); h++) {
            StringBuilder line = new StringBuilder();

            for (int w = 0; w < Math.max(this.width(), that.width()); w++) {
                if (w > that.width() - 1) line.append(" ");
                else line.append(that.charAt(w, h));
            }

            composite.add(line.toString());
        }

        width = Math.max(this.width(), that.width());
        height = this.height + that.height();

        return new AboveOtherCompositeTextImage(new OneLineTextImage(composite.toString()));
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
