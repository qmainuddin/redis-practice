package com.example.redis.repositories.impl;

import com.example.redis.models.SearchCriteria;
import com.example.redis.models.User;
import com.example.redis.repositories.UserRepository;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;


import java.util.Map;

/**
 * Created by Mainuddin on 20-Feb-19.
 */

@Repository
public class UserRepositoryImpl implements UserRepository {
    private RedisTemplate<String, User> redisTemplate;
    private HashOperations hashOperations;

    public UserRepositoryImpl(RedisTemplate<String, User> redisTemplate){
        this.redisTemplate = redisTemplate;

        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(User user) {
        hashOperations.put("USER", user.getNid(), user);
    }

    @Override
    public Map<String, User> findAll() {
        return hashOperations.entries(("USER"));
    }

    @Override
    public User findByNID(String nid) {
        return (User) hashOperations.get("USER", nid);
    }

    @Override
    public void update(User user) {
        save(user);
    }

    @Override
    public void delete(String nid) {
        hashOperations.delete("USER", nid);
    }

    @Override
    public void save(SearchCriteria searchCriteria, User user){
        hashOperations.put("USER", searchCriteria, user);
    }

    @Override
    public User findBySearchCriteria(SearchCriteria searchCriteria){
        return (User) hashOperations.get("USER", searchCriteria);
    }
}
