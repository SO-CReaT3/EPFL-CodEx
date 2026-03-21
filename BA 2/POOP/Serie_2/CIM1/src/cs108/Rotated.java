package cs108;

public final class Rotated<T> implements Image<T> {
    private final Image<T> image;

    public Rotated(Image<T> image) {
        this.image = image;
    }

    @Override
    public T apply(double x, double y) {
        double angle = 0.174533;
        return image.apply( Math.cos(angle)*x + Math.sin(angle)*y, -Math.sin(angle)*x + Math.cos(angle)*y);
    }
}