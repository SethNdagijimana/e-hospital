package org.hospital.model;


public class Physician extends User {
    private String email;
    private String password; // Length 7-8 characters

    public Physician(String name, int age, String gender, String email, String password) {
        super(name, age, gender);
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
