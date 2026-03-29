package cs108;

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

    // ------------ Exercice 1 ------------
    static OneLineTextImage fromString(String imageString) {
        return new OneLineTextImage(imageString);
    }

    static FilledTextImage filled(int width, int height, char charToFill) {
        return new FilledTextImage(width, height, charToFill);
    }

    // ------------ Exercice 2 ------------
    default TextImage flippedHorizontally() {
        return new FlippedHorizontalTextImage(this);
    }

    default TextImage transposed() {
        return new TransposedTextImage(this);
    }

    // ------------ Exercice 2 ------------
    default TextImage leftOf(TextImage textImage) {
        return new SideBySideCompositeTextImage(this).leftOf(textImage);
    }

    default TextImage above(TextImage textImage) {
        return new AboveOtherCompositeTextImage(this).above(textImage);
    }
}
