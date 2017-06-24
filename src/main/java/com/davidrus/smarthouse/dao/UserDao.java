package com.davidrus.smarthouse.dao;

import com.davidrus.smarthouse.domain.User;
import org.springframework.stereotype.Repository;

/**
 * Created by david on 22-Jun-17.
 */
@Repository
public interface UserDao {

    boolean createUser(User user);

    User getUserById(long id);

    User getUserByName(String userName);

    boolean updateUser(User user);

    boolean deleteUser(long id);

}
