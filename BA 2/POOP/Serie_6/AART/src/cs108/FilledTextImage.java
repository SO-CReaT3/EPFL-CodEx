package cs108;

import java.util.ArrayList;

public final class FilledTextImage implements TextImage {
    private final String imageString;
    private final int width;
    private final int height;

    public FilledTextImage(int width, int height, char charToFill) {
        imageString = Character.toString(charToFill).repeat(width * height);
        this.width = width;
        this.height = height;

        System.out.println("Width: " + width() + " Height: " + height());
    }

    @Override
    public int width() {
        return width;
    }

    @   Override
    public int height() {
        return height;
    }

    @Override
    public char charAt(int x, int y) {
        return imageString.charAt(y * width + x);
    }
}
