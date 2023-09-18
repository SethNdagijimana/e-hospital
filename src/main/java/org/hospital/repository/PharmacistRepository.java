package org.hospital.repository;

import org.hospital.model.Pharmacist;

public interface PharmacistRepository extends UserRepository{
    Pharmacist findByPhoneAndIdentifier(String phone, String identifier);
}