package org.hospital.repository;

import org.hospital.model.Patient;

public interface PatientRepository extends UserRepository {
    Patient findByUsername(String username);
}