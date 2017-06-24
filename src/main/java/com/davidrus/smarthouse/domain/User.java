package com.davidrus.smarthouse.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by david on 22-Jun-17.
 */
@Getter
@Setter
@Entity
@NamedQueries({
        @NamedQuery(name = User.GET_USER_BY_ID, query = "SELECT u FROM User u WHERE u.id = :id"),
        @NamedQuery(name = User.GET_USER_BY_NAME, query = "SELECT u FROM User u WHERE u.name = :name")
})
public class User {

    public static final String GET_USER_BY_ID = "getUserById";
    public static final String GET_USER_BY_NAME = "getUserByName";

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String email;

    private String password;

    @OneToMany(mappedBy = "user")
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
