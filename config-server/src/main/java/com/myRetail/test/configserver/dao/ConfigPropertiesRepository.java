package com.myRetail.test.configserver.dao;

import com.myRetail.test.configserver.entity.ConfigProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by Mriganka Shekhar Roy on 12/11/2018.
 */
public interface ConfigPropertiesRepository extends MongoRepository<ConfigProfile, String> {

    @Query("{ 'application': ?0, 'profile': ?1}")
    List<ConfigProfile> findByApplicationAndProfile(String application, String profile);
}
