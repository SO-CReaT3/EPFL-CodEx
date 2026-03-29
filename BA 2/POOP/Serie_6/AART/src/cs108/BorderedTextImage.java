package cs108;

public class BorderedTextImage implements TextImage {
    private TextImage image;

    private int width;
    private char wSep;

    private int height;
    private char hSep;

    private char cornerSep;

    public BorderedTextImage(TextImage image) {
        this.image = image;
    }

    public TextImage framed(int width, char wSep, int height, char hSep, char cornerSep) {
        this.width = width;
        this.wSep = wSep;

        this.height = height;
        this.hSep = hSep;

        this.cornerSep = cornerSep;

        TextImage upDownBorderedImage = upDownSeparation().above(this).above(upDownSeparation());
        image = sideSeparation().leftOf(upDownBorderedImage).leftOf(sideSeparation());

        // Add the border size
        this.width += 2;
        this.height += 2;

        return this;
    }

    @Override
    public int width() {
        return width;
    }

    public TextImage upDownSeparation() {
        return new AboveOtherCompositeTextImage(new FilledTextImage(width, 1, wSep));
    }

    @Override
    public int height() {
        return height;
    }

    public TextImage sideSeparation() {
        TextImage side = new FilledTextImage(1, height, hSep);
        TextImage cornerImage = new FilledTextImage(1, 1, cornerSep);

        return cornerImage.above(side).above(cornerImage);
    }

    @Override
    public char charAt(int x, int y) {
        return image.charAt(x, y);
    }
}
