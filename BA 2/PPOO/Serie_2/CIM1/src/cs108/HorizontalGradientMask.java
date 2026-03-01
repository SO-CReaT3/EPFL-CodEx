package cs108;

public final class HorizontalGradientMask implements Image<ColorRGB> {
    private final Image<ColorRGB> image;

    public HorizontalGradientMask(Image<ColorRGB> image) {
        this.image = image;
    }

    public static double gradientMask(double x) {
        if (x < -1) {
            return 0;
        } else if (x > 1) {
            return 1;
        } else {
            return (x + 1) / 2;
        }
    }

    @Override
    public ColorRGB apply(double x, double y) {
        return ColorRGB.WHITE.mixWith(image.apply(x, y), gradientMask(x));
    }
}
