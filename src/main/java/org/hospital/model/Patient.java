package org.hospital.model;

public class Patient extends User {
    private String username;
    private String password; // Length 4-6 characters

    public Patient() {
    }



    public Patient(String name, int age, String gender, String username, String password) {
        super(name, age, gender);
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
