package com.davidrus.smarthouse.dao;

import com.davidrus.smarthouse.domain.Room;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 * Created by david on 24-Jun-17.
 */
@Repository
@Slf4j
public class RoomDaoImpl implements RoomDao {

    @PersistenceContext
    public EntityManager em;

    @Override
    @Transactional
    public boolean createRoom(Room room) {
        em.persist(room);
        return true;
    }

    @Override
    public Room getRoomById(long id) {
        TypedQuery<Room> query = em.createNamedQuery(Room.GET_ROOM_BY_ID, Room.class);
        query.setParameter("id",id);

        return query.getSingleResult();
    }

    @Override
    public Room getRoomByName(String roomName) {
        TypedQuery<Room> query = em.createNamedQuery(Room.GET_ROOM_BY_NAME, Room.class);
        query.setParameter("name", roomName);

        return query.getSingleResult();
    }

    @Override
    public boolean updateRoom(Room room) {
        em.merge(room);

        return true;
    }

    @Override
    public boolean deleteRoom(long id) {
        TypedQuery<Room> query = em.createNamedQuery(Room.GET_ROOM_BY_ID, Room.class);
        query.setParameter("id", id);
        Room room = query.getSingleResult();
        em.remove(room);

        return true;
    }
}
