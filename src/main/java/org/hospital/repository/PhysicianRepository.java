package org.hospital.repository;

import org.hospital.model.Physician;

public interface PhysicianRepository extends UserRepository {
    Physician findByEmail(String email);
}