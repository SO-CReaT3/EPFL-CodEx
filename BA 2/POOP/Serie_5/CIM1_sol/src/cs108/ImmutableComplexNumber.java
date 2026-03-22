package cs108;

public final class ImmutableComplexNumber {
    private double rl;
    private double im;

    public ImmutableComplexNumber(final double rl, final double im) {
        this.rl = rl;
        this.im = im;
    }

    private double realNumber() {
        return rl;
    }

    private double imaginaryNumber() {
        return im;
    }

    public double module() {
        return Math.sqrt(rl * rl + im * im);
    }

    public ImmutableComplexNumber add(ImmutableComplexNumber c) {
        return new ImmutableComplexNumber(rl + c.realNumber(), im + c.imaginaryNumber());
    }

    public ImmutableComplexNumber square() {
        return new ImmutableComplexNumber(rl * rl - im * im, 2 * rl * im);
    }

    public static ImmutableComplexNumber copyOf(ImmutableComplexNumber c) {
        return new ImmutableComplexNumber(c.realNumber(), c.imaginaryNumber());
    }
}
