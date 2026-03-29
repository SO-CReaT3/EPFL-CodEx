package cs108;

import org.w3c.dom.Text;

import java.io.PrintStream;

public interface TextImage {
    int width();
    int height();
    char charAt(int x, int y);

    default void printOn(PrintStream stream) {
        for (var y = 0; y < height(); y += 1) {
            for (var x = 0; x < width(); x += 1)
                stream.print(charAt(x, y));
            stream.println();
        }
    }

    //region ------------ Exercice 1 ------------
    static OneLineTextImage fromString(String imageString) {
        return new OneLineTextImage(imageString);
    }

    static FilledTextImage filled(int width, int height, char charToFill) {
        return new FilledTextImage(width, height, charToFill);
    }
    //endregion

    //region ------------ Exercice 2 ------------
    default TextImage flippedHorizontally() {
        return new FlippedHorizontalTextImage(this);
    }

    default TextImage transposed() {
        return new TransposedTextImage(this);
    }
    //endregion

    //region ------------ Exercice 3 ------------
    default TextImage leftOf(TextImage textImage) {
        return new SideBySideCompositeTextImage(this).leftOf(textImage);
    }

    default TextImage above(TextImage textImage) {
        return new AboveOtherCompositeTextImage(this).above(textImage);
    }
    //endregion

    //region ------------ Exercice 4 ------------
    default TextImage framed() {
        return new BorderedTextImage(this).framed(this.width(), '-', this.height(), '|', '+');
    }

    static TextImage chessboard() {
        TextImage blackSquare = new FilledTextImage(3, 2, '#');
        TextImage whiteSquare = new FilledTextImage(3, 2, ' ');

        TextImage evenPairOfSquares = blackSquare.leftOf(whiteSquare);

        TextImage chessboard = null;
        TextImage chessboardLine = null;

        for (int i = 0; i < 3; i++) {
            chessboardLine = (chessboardLine == null) ? evenPairOfSquares : chessboardLine.leftOf(evenPairOfSquares);
        }

        for (int line = 0; line < 8; line++) {
            if (chessboard == null) chessboard = chessboardLine;
            else if (line % 2 == 0) chessboard = chessboard.above(chessboardLine);
            else chessboard = chessboard.above(chessboardLine.flippedHorizontally());
        }

        return chessboard.framed();
    }
    //endregion
}
