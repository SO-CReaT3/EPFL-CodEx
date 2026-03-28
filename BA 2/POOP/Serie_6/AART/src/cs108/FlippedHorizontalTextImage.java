package cs108;

import javax.swing.*;
import java.awt.*;

public final class FlippedHorizontalTextImage implements TextImage {
    private final TextImage image;

    public FlippedHorizontalTextImage(TextImage image) {
        StringBuilder imageStringBuilder = new StringBuilder();
        for (int line = 0; line < image.height(); line++) {
            for (int column = image.width() - 1; column >= 0; column--) {
                imageStringBuilder.append(image.charAt(column, line));
            }
            if (line < image.height() - 1) imageStringBuilder.append("\n");
        }

        this.image = TextImage.fromString(imageStringBuilder.toString());
    }

    @Override
    public int width() {
        return image.width();
    }

    @Override
    public int height() {
        return image.height();
    }

    @Override
    public char charAt(int x, int y) {
        return image.charAt(x, y);
    }
}
