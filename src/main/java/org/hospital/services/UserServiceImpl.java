package org.hospital.services;

import org.hospital.model.Patient;
import org.hospital.model.Pharmacist;
import org.hospital.model.Physician;
import org.hospital.model.User;
import java.util.*;

// Service
public class UserServiceImpl implements UserService {
    private Map<String, Patient> patients = new HashMap<>();
    private Map<String, Physician> physicians = new HashMap<>();
    private Map<String, Pharmacist> pharmacists = new HashMap<>();

    @Override
    public boolean register(User user) {
        if (user instanceof Patient) {
            Patient patient = (Patient) user;
            if (patients.containsKey(patient.getUsername())) {
                return false; // Username already exists
            }
            patients.put(patient.getUsername(), patient);
            return true;
        } else if (user instanceof Physician) {
            Physician physician = (Physician) user;
            if (physicians.containsKey(physician.getEmail())) {
                return false; // Email already exists
            }
            physicians.put(physician.getEmail(), physician);
            return true;
        } else if (user instanceof Pharmacist) {
            Pharmacist pharmacist = (Pharmacist) user;
            String identifier = pharmacist.getPhone() + pharmacist.getIdentifier();
            if (pharmacists.containsKey(identifier)) {
                return false; // Phone and Identifier combination already exists
            }
            pharmacists.put(identifier, pharmacist);
            return true;
        }
        return false; // Unsupported user type
    }


    @Override
    public boolean login(String identifier, String password) {
        if (patients.containsKey(identifier)) {
            Patient patient = patients.get(identifier);
            return patient.getPassword().equals(password);
        } else if (physicians.containsKey(identifier)) {
            Physician physician = physicians.get(identifier);
            return physician.getPassword().equals(password);
        } else if (pharmacists.containsKey(identifier)) {
            Pharmacist pharmacist = pharmacists.get(identifier);
            return pharmacist.getPassword().equals(password);
        }
        return false; // User not found
    }
}

