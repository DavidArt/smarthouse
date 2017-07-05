package com.davidrus.smarthouse.services;

import com.davidrus.smarthouse.dao.RoomDao;
import com.davidrus.smarthouse.dto.Room;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * Created by david on 04-Jul-17.
 */
@Service
@Slf4j
public class RoomServiceImpl implements RoomService {

    @Resource
    private Mapper mapper;
    @Resource
    private RoomDao roomDao;

    @Override
    public boolean createRoom(Room room) {
        com.davidrus.smarthouse.domain.Room roomDomain = mapper.map(room, com.davidrus.smarthouse.domain.Room.class);
        return roomDao.createRoom(roomDomain);
    }

    @Override
    public Room getRoomById(long id) {
        com.davidrus.smarthouse.domain.Room roomDomain = roomDao.getRoomById(id);
        Room roomDto = mapper.map(roomDomain, Room.class);
        return roomDto;
    }

    @Override
    public Room getRoomByName(String roomName) {
        com.davidrus.smarthouse.domain.Room roomDomain = roomDao.getRoomByName(roomName);
        Room roomDto = mapper.map(roomDomain, Room.class);
        return roomDto;
    }

    @Override
    public boolean updateRoom(Room room) {
        com.davidrus.smarthouse.domain.Room roomDomain = mapper.map(room, com.davidrus.smarthouse.domain.Room.class);
        return roomDao.updateRoom(roomDomain);
    }

    @Override
    public boolean deleteRoom(long id) {
        return roomDao.deleteRoom(id);
    }
}
