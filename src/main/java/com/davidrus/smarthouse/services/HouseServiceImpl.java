package com.davidrus.smarthouse.services;

import com.davidrus.smarthouse.dao.HouseDao;
import com.davidrus.smarthouse.dto.House;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by david on 04-Jul-17.
 */
@Service
@Slf4j
public class HouseServiceImpl implements HouseService {

    @Resource
    private Mapper mapper;

    @Resource
    private HouseDao houseDao;

    @Override
    public boolean createHouse(House house) {
        com.davidrus.smarthouse.domain.House houseDomain = mapper.map(house, com.davidrus.smarthouse.domain.House.class);
        return houseDao.createHouse(houseDomain);
    }

    @Override
    public House getHouseById(long id) {
        com.davidrus.smarthouse.domain.House houseDomain = houseDao.getHouseById(id);
        House houseDto = mapper.map(houseDomain, House.class);
        return houseDto;
    }

    @Override
    public House getHouseByName(String houseName) {
        com.davidrus.smarthouse.domain.House houseDomain = houseDao.getHouseByAddress(houseName);
        House houseDto = mapper.map(houseDomain, House.class);
        return houseDto;
    }

    @Override
    public boolean updateHouse(House house) {
        com.davidrus.smarthouse.domain.House houseDomain = mapper.map(house, com.davidrus.smarthouse.domain.House.class);
        return houseDao.updateHouse(houseDomain);
    }

    @Override
    public boolean deleteHouse(long id) {
        return houseDao.deleteHouse(id);
    }
}
