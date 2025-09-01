package src.colors;

public enum colors {
    BLACK("\u001B[0;30m"),
    RED("\u001B[0;31m"),
    GREEN("\u001B[0;32m"),
    YELLOW("\u001B[0;33m"),
    BLUE("\u001B[0;34m"),
    PURPLE("\u001B[0;35m"),
    CYAN("\u001B[0;36m"),
    WHITE("\u001B[0;37m");

    public final String code;

    colors(String code) {
        this.code = code;
    }

    public String toString() {
        return this.code;
    }
}
