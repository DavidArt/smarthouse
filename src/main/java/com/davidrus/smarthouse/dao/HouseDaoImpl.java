package com.davidrus.smarthouse.dao;

import com.davidrus.smarthouse.domain.House;
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
public class HouseDaoImpl implements HouseDao{

    @PersistenceContext
    public EntityManager em;

    @Override
    @Transactional
    public boolean createHouse(House house) {
        em.persist(house);

        return true;
    }

    @Override
    public House getHouseById(long id) {
        TypedQuery<House> query = em.createNamedQuery(House.GET_HOUSE_BY_ID, House.class);
        query.setParameter("id", id);

        return query.getSingleResult();
    }

    @Override
    public House getHouseByAddress(String houseAdress) {
        TypedQuery<House> query = em.createNamedQuery(House.GET_HOUSE_BY_ADDRESS, House.class);
        query.setParameter("address", houseAdress);

        return query.getSingleResult();
    }

    @Override
    public boolean updateHouse(House house) {
        em.merge(house);

        return true;
    }

    @Override
    public boolean deleteHouse(long id) {
        TypedQuery<House> query = em.createNamedQuery(House.GET_HOUSE_BY_ID, House.class);
        query.setParameter("id", id);
        House house = query.getSingleResult();
        em.remove(house);

        return true;
    }
}
