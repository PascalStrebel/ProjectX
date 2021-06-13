package ch.zhaw.springboot.models;

public class PatientRequest {
    private String name;
    private String age;

    public PatientRequest(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}
