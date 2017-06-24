package com.davidrus.smarthouse.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by david on 22-Jun-17.
 */
@Getter
@Setter
public class User {

    private long id;

    private String name;

    private String email;

    private String password;

    private List<House> housesOwned;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", housesOwned=" + housesOwned +
                '}';
    }
}
