package ch.zhaw.springboot.models;

public class PatientSeverityCount {
    private int count;
    private Severity severity;
    private String name;

    public PatientSeverityCount(int count, Severity severity, String name) {
        this.count = count;
        this.severity = severity;
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
