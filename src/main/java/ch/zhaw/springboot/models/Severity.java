package ch.zhaw.springboot.models;

public enum Severity {
    WEAK("1"),
    MEDIUM("2"),
    HEAVY("3");

    private final String id;

    Severity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
