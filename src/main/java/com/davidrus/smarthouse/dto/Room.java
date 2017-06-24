package com.davidrus.smarthouse.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by david on 22-Jun-17.
 */
@Getter
@Setter
public class Room {

    private long id;

    private String name;

    private int temperature;

    private boolean lightOn;

    private boolean windowsClosed;

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
