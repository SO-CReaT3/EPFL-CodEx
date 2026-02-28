package cs108;

public class HorizontalGradientMask implements Image<ColorRGB> {
    private final Image<ColorRGB> image;
    private final double MASK = 0.2;
    private ColorRGB color;

    public HorizontalGradientMask(Image<ColorRGB> image) {
        this.image = image;
    }

    public ColorRGB Composed(Image forgroundImage, Image backgroundImage) {
        color.mixWith(backgroundImage, 2);
    }

    @Override
    public ColorRGB apply(double x, double y) {
        return ColorRGB.BLACK;
    }
}
