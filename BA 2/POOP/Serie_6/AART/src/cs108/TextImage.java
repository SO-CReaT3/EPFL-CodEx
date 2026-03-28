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

    static OneLineTextImage fromString(String imageString) {
        return new OneLineTextImage(imageString);
    }

    static FilledTextImage filled(int width, int height, char charToFill) {
        return new FilledTextImage(width, height, charToFill);
    }
}
