package Cards;

public enum Color {
    RED("\033[0;31m", "RED"),      // RED
    GREEN("\033[0;32m", "GREEN"),    // GREEN
    YELLOW("\033[0;33m", "YELLOW"),   // YELLOW
    BLUE("\033[0;34m", "BLUE"),     // BLUE
    NO_COLOR("\033[0m", "NO_COLOR"); // NO_COLOR (BLACK);

    private final String code;
    private final String color;

    Color(String code, String color) {
        this.code = code;
        this.color = color;
    }

    public String getColorName() {
        return color;
    }

    @Override
    public String toString() {
        return code;
    }
}
