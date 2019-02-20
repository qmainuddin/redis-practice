package com.example.redis.repositories;

import com.example.redis.models.SearchCriteria;
import com.example.redis.models.User;

import java.util.Map;

/**
 * Created by Mainuddin on 20-Feb-19.
 */

public interface UserRepository {
    void save(User user);
    Map<String, User> findAll();
    User findByNID(String nid);
    void update(User user);
    void delete(String nid);

    void save(SearchCriteria searchCriteria, User user);
    public User findBySearchCriteria(SearchCriteria searchCriteria);
}
