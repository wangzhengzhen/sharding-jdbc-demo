package com.engrz.demo.sharding.jdbc.service.impl;

import com.engrz.demo.sharding.jdbc.entity.UserLogEntity;
import com.engrz.demo.sharding.jdbc.repository.UserLogRepository;
import com.engrz.demo.sharding.jdbc.service.UserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserLogServiceImpl implements UserLogService {

    @Autowired
    private UserLogRepository userLogRepository;

    @Override
    public void save(UserLogEntity entity) {
        entity.setLogDate(new Date());
        userLogRepository.save(entity);
    }

    @Override
    public UserLogEntity findById(Long id) {

        return userLogRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserLogEntity> queryAll(UserLogEntity condition) {

        return userLogRepository.findAll();
    }
}
