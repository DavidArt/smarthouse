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
        @NamedQuery(name = House.GET_HOUSE_BY_ID, query = "SELECT h FROM House h WHERE h.id = :id"),
        @NamedQuery(name = House.GET_HOUSE_BY_ADDRESS, query = "SELECT h FROM House h WHERE h.name = :name")
})
public class House {

    public static final String GET_HOUSE_BY_ID = "getHouseById";
    public static final String GET_HOUSE_BY_ADDRESS = "getHouseByAddress";

    @Id
    @GeneratedValue
    private long id;

    private String address;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "house")
    private List<Room> rooms;

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", user=" + user +
                ", rooms=" + rooms +
                '}';

    }
}
