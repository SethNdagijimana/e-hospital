package org.hospital.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class UserDataStore {
    private static Map<String, User> userMap = new LinkedHashMap<>();

    public static void addUser(String key, User user) {
        userMap.put(key, user);
    }

    public static User getUser(String key) {
        return userMap.get(key);
    }
}
