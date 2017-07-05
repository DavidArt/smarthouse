package com.davidrus.smarthouse.services;

import com.davidrus.smarthouse.dto.Room;
import org.springframework.stereotype.Service;

/**
 * Created by david on 24-Jun-17.
 */
@Service
public interface RoomService {

    boolean createRoom(Room room);

    Room getRoomById(long id);

    Room getRoomByName(String roomName);

    boolean updateRoom(Room room);

    boolean deleteRoom(long id);

}
