package com.davidrus.smarthouse.services;

import com.davidrus.smarthouse.dto.House;
import org.springframework.stereotype.Service;

/**
 * Created by david on 24-Jun-17.
 */
@Service
public interface HouseService {

    boolean createHouse(House house);

    House getHouseById(long id);

    House getHouseByName(String houseName);

    boolean updateHouse(House house);

    boolean deleteHouse(long id);

}
