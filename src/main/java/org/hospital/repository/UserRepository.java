package org.hospital.repository;

import org.hospital.model.User;

public interface UserRepository {
    User findById(String id);
    boolean save(User user);
    boolean update(User user);
    boolean delete(String id);
}
