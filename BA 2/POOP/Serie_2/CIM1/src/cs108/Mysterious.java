package cs108;

public final class Mysterious<T> implements Image<T> {
    private final Image<T> image;
    private final double WIDTH;

    public Mysterious(Image<T> image, double width) {
        this.image = image;
        this.WIDTH = width;
    }

    @Override
    public T apply(double x, double y) {
        return image.apply(x / WIDTH, y / WIDTH);
    }
}