package com.davidrus.smarthouse.services;

import com.davidrus.smarthouse.dao.UserDao;
import com.davidrus.smarthouse.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by david on 24-Jun-17.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private Mapper mapper;
    @Resource
    private UserDao userDao;

    @Override
    public boolean createUser(User user) {
        com.davidrus.smarthouse.domain.User userDomain = mapper.map(user, com.davidrus.smarthouse.domain.User.class);
        return userDao.createUser(userDomain);
    }

    @Override
    public User getUserById(long id) {
        com.davidrus.smarthouse.domain.User userDomain = userDao.getUserById(id);
        User userDto = mapper.map(userDomain, User.class);
        return userDto;
    }

    @Override
    public User getUserByName(String userName) {
        com.davidrus.smarthouse.domain.User userDomain = userDao.getUserByName(userName);
        User userDto = mapper.map(userDomain, User.class);
        return userDto;
    }

    @Override
    public boolean updateUser(User user) {
        com.davidrus.smarthouse.domain.User userDomain = mapper.map(user, com.davidrus.smarthouse.domain.User.class);
        return userDao.updateUser(userDomain);
    }

    @Override
    public boolean deleteUser(long id) {
        return userDao.deleteUser(id);
    }
}
