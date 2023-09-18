package org.hospital.model;

// Model
public class Pharmacist extends User {
    private String phone;
    private String identifier;
    private String password; // Length 9-10 characters

    public Pharmacist(String name, int age, String gender, String phone, String identifier, String password) {
        super(name, age, gender);
        this.phone = phone;
        this.identifier = identifier;
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getPassword() {
        return password;
    }
}
