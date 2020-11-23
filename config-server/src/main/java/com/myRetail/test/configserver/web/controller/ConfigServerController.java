package com.myRetail.test.configserver.web.controller;


import com.myRetail.test.configserver.dao.ConfigPropertiesRepository;
import com.myRetail.test.configserver.entity.ConfigProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Mriganka Shekhar Roy on 12/18/2018.
 */
@RestController
@RequestMapping(path = "/")
public class ConfigServerController {

    @Autowired
    private ConfigPropertiesRepository configPropertiesRepository;

    @RequestMapping(path = "/applications", method = {RequestMethod.GET}, produces = "application/json")
    public ResponseEntity<?> getApplicationsAndProfiles() {
        List<ConfigProfile> data = configPropertiesRepository.findAll();
        return ResponseEntity.ok(data);
    }

}
