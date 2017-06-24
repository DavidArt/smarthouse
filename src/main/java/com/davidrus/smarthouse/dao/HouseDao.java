package com.davidrus.smarthouse.dao;

import com.davidrus.smarthouse.domain.House;
import org.springframework.stereotype.Repository;

/**
 * Created by david on 22-Jun-17.
 */
@Repository
public interface HouseDao {

    boolean createHouse(House house);

    House getHouseById(long id);

    House getHouseByAddress(String houseAdress);

    boolean updateHouse(House house);

    boolean deleteHouse(long id);

}
