package cs108;

public class Composed implements Image<ColorRGB> {
    private final double MASK;
    private Image<ColorRGB> foregroundImage;
    private Image<ColorRGB> backgroundImage;

    public Composed(double mask, Image<ColorRGB> foregroundImage, Image<ColorRGB> backgroundImage) {
        this.MASK = mask;
        this.foregroundImage = foregroundImage;
        this.backgroundImage = backgroundImage;
    }

    @Override
    public ColorRGB apply(double x, double y) {
        return backgroundImage.apply(x,y).mixWith(foregroundImage.apply(x, y), HorizontalGradientMask.gradientMask(x));
    }
}
