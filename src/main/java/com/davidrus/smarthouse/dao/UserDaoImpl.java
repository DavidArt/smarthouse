package com.davidrus.smarthouse.dao;

import com.davidrus.smarthouse.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 * Created by david on 22-Jun-17.
 */
@Repository
@Slf4j
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    public EntityManager em;

    @Override
    @Transactional
    public boolean createUser(User user) {
        em.persist(user);

        return true;
    }

    @Override
    public User getUserById(long id) {
        TypedQuery<User> query = em.createNamedQuery(User.GET_USER_BY_ID, User.class);
        query.setParameter("id", id);

        return query.getSingleResult();
    }

    @Override
    public User getUserByName(String userName) {
        TypedQuery<User> query = em.createNamedQuery(User.GET_USER_BY_NAME, User.class);
        query.setParameter("name", userName);

        return query.getSingleResult();
    }

    @Override
    public boolean updateUser(User user) {
        em.merge(user);

        return true;
    }

    @Override
    public boolean deleteUser(long id) {
        TypedQuery<User> query = em.createNamedQuery(User.GET_USER_BY_ID, User.class);
        query.setParameter("id", id);
        User user = query.getSingleResult();
        em.remove(user);

        return true;
    }
}
