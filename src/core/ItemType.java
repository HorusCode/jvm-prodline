package core;

public enum ItemType {
    AUDIO("AU"),
    VISUAL("VI"),
    AUDIOMOBILE("VI"),
    VISUALMOBILE("VI");

    private final String code;

    ItemType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
