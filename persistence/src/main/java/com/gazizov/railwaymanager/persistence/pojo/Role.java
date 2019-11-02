package com.gazizov.railwaymanager.db.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 25.10.2019
 *
 * @author Roman Gazizov
 */

@Getter
@AllArgsConstructor
public enum Role {
    STAFF(1),
    PASSENGER(2);

    private final int id;

    public static Role of(Integer id) {
        if (id == null) {
            return null;
        }

        for (Role value : values()) {
            if (value.id == id) {
                return value;
            }
        }
        return null;
    }

}
