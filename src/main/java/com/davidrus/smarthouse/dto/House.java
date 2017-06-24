package com.davidrus.smarthouse.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by david on 22-Jun-17.
 */
@Getter
@Setter
public class House {

    private long id;

    private String address;

    private User user;

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
