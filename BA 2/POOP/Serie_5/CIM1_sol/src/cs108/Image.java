package cs108;

import static java.lang.Math.*;

/**
 * Une image continue et infinie, représentée par une fonction associant une
 * valeur d'un type donné (p.ex. une couleur) à chaque point du plan.
 */

@FunctionalInterface
public interface Image<T> {
    T apply(double x, double y);

    // -------- static attributes (from classes without constructors) --------

    public static final Image<ColorRGB> RED_DISK = (x, y) -> {
        double r = sqrt(x * x + y * y);
        return r <= 1d ? ColorRGB.RED : ColorRGB.WHITE;
    };

    public static final Image<Double> HORIZONTAL_GRADIENT_MASK = (x, y) -> {
        return max(0, min((x + 1d) / 2d, 1d));
    };

    // -------- static methods (from classes with constructors) --------

    public static Image<Double> mandelbrot (int maxIt) {
        return (x, y) -> {
            final ImmutableComplexNumber c = new ImmutableComplexNumber(x, y);

            int m = 0;
            ImmutableComplexNumber z = new ImmutableComplexNumber(0, 0);

            System.out.println("m : " + m + ", z.module() : " + z.module());

            while (m < maxIt && z.module() < 2) {
                m++;
                z = ImmutableComplexNumber.copyOf(z.square().add(c));

                System.out.println("m : " + m + ", z.module() : " + z.module());
            }
            return (double)m / (double)maxIt;
        };
    }

    public static Image<ColorRGB> chessboard(ColorRGB c1, ColorRGB c2, double w) {
        if (!(w > 0))
            throw new IllegalArgumentException("non-positive width: " + w);

        return (x, y) -> {
            int sqX = (int)floor(x / w), sqY = (int)floor(y / w);
            return (sqX + sqY) % 2 == 0 ? c1 : c2;
        };
    }

    public static Image<ColorRGB> composed(Image<ColorRGB> bg, Image<ColorRGB> fg, Image<Double> mask) {
        return (x, y) -> bg.apply(x, y).mixWith(fg.apply(x, y), mask.apply(x, y));
    }

    public default Image<T> rotated(double angle) {
        double cosA, sinA;

        cosA = cos(-angle);
        sinA = sin(-angle);

        return (x, y) -> {
            double x1 = x * cosA - y * sinA;
            double y1 = x * sinA + y * cosA;
            return this.apply(x1, y1);
        };
    }
}
