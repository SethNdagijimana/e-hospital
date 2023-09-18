package org.hospital.services;

import org.hospital.model.User;

public interface UserService {
    boolean register(User user);
    boolean login(String identifier, String password);
}