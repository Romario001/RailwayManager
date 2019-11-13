package com.gazizov.railwaymanager.persistence.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Table;

/**
 * 25.10.2019
 *
 * @author Roman Gazizov
 */

@Getter
@AllArgsConstructor
//@Table(name="roles")
public enum RolePO {
    STAFF(1),
    PASSENGER(2);

    private final int id;

    public static RolePO of(Integer id) {
        if (id == null) {
            return null;
        }

        for (RolePO value : values()) {
            if (value.id == id) {
                return value;
            }
        }
        return null;
    }

}
