package com.davidrus.smarthouse.dao;

import com.davidrus.smarthouse.domain.Room;
import org.springframework.stereotype.Repository;

/**
 * Created by david on 22-Jun-17.
 */
@Repository
public interface RoomDao {

    boolean createRoom(Room room);

    Room getRoomById(long id);

    Room getRoomByName(String roomName);

    boolean updateRoom(Room room);

    boolean deleteRoom(long id);

}
