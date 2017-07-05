package com.davidrus.smarthouse.services;

import com.davidrus.smarthouse.dto.User;
import org.springframework.stereotype.Service;

/**
 * Created by david on 24-Jun-17.
 */
@Service
public interface UserService {

    boolean createUser(User user);

    User getUserById(long id);

    User getUserByName(String userName);

    boolean updateUser(User user);

    boolean deleteUser(long id);
}
