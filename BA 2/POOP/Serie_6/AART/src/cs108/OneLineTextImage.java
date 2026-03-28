package cs108;

public final class OneLineTextImage implements TextImage {
    private final String imageString;

    public OneLineTextImage(String imageString){
        this.imageString = imageString;
    }

    @Override
    public int width() {
        return imageString.length();
    }

    @Override
    public int height() {
        return 1;
    }

    @Override
    public char charAt(int x, int y) {
        return imageString.charAt(x);
    }
}
