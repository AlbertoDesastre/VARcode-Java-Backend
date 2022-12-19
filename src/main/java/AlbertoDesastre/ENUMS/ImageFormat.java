package AlbertoDesastre.ENUMS;

public enum ImageFormat {
    JPG("jpg"),
    JPEG("jpeg"),
    PNG("png");

    private final String string;

    ImageFormat(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}