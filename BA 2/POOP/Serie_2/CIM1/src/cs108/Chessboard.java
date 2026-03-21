package cs108;

import static java.lang.Math.*;

public final class Chessboard implements Image<ColorRGB> {
    private final int WIDTH;
    // private final double RANGE;
    private final ColorRGB FIRST_COLOR;
    private final ColorRGB SECOND_COLOR;

    public static final Image<ColorRGB> BASIC = new Chessboard(1, ColorRGB.BLACK, ColorRGB.WHITE);

    public Chessboard(int width, ColorRGB firstColor, ColorRGB secondColor) {
        WIDTH = width * 2;
        // RANGE = width / (double) 2;
        FIRST_COLOR = firstColor;
        SECOND_COLOR = secondColor;
    }



    @Override
    public ColorRGB apply(double x, double y) {
        double approX = floor(x) % WIDTH;
        double approY = floor(y) % WIDTH;

        /**
        boolean firstQuadran = (approX >= 0 && approX < (WIDTH / (double) 2)
                && approY >= 0 && approY < (WIDTH / (double) 2))
                || (approX >= (WIDTH / (double) 2) && approX < WIDTH
                && approY >= (WIDTH / (double) 2) && approY < WIDTH);

        boolean secondQuadran = (approX >= 0 && approX < (WIDTH / (double) 2)
                && approY >= 0 && approY < (WIDTH / (double) 2))
                || (approX >= (WIDTH / (double) 2) && approX < WIDTH
                && approY >= (WIDTH / (double) 2) && approY < WIDTH);

        return ((firstQuadran || secondQuadran) ? FIRST_COLOR : SECOND_COLOR);
        **/

        return (approX == approY ||
                approX - WIDTH == approY ||
                approX == approY - WIDTH) ? FIRST_COLOR : SECOND_COLOR;

        /**
        return ((approX == approY ||
                approX - WIDTH == approY ||
                approX == approY - WIDTH)
                && approX <= (double) WIDTH/ 2
                && approY <= (double) WIDTH/ 2)
                ? FIRST_COLOR : SECOND_COLOR;
        **/
    }
}
