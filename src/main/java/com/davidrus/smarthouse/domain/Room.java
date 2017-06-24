package com.davidrus.smarthouse.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

/**
 * Created by david on 22-Jun-17.
 */
@Getter
@Setter
@Entity
@NamedQueries({
        @NamedQuery(name = Room.GET_ROOM_BY_ID, query = "SELECT r FROM Room r WHERE r.id = :id"),
        @NamedQuery(name = Room.GET_ROOM_BY_NAME, query = "SELECT r FROM Room r WHERE r.name = :name")
})
public class Room {

    public static final String GET_ROOM_BY_ID = "getRoomById";
    public static final String GET_ROOM_BY_NAME = "getRoomByName";

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private int temperature;

    private boolean lightOn;

    private boolean windowsClosed;

    @ManyToOne
    private House house;

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", temperature=" + temperature +
                ", lightOn=" + lightOn +
                ", windowsClosed=" + windowsClosed +
                ", house=" + house +
                '}';
    }
}
