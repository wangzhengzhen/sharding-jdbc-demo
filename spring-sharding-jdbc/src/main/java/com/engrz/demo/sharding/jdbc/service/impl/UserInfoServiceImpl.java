package com.engrz.demo.sharding.jdbc.service.impl;

import com.engrz.demo.sharding.jdbc.entity.UserInfoEntity;
import com.engrz.demo.sharding.jdbc.repository.UserInfoRepository;
import com.engrz.demo.sharding.jdbc.service.UserInfoService;
import com.engrz.demo.sharding.jdbc.util.SnowFlake;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public void save(UserInfoEntity entity) {

        if (null == entity.getUserId()) {
            Long userId = SnowFlake.nextId();
            log.info("生成user id：{}", userId);
            entity.setUserId(userId);
            userInfoRepository.save(entity);
        } else {
            userInfoRepository.saveAndFlush(entity);
        }
    }

    @Override
    public UserInfoEntity findById(Long id) {

        return userInfoRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserInfoEntity> queryAll(UserInfoEntity condition) {

        return userInfoRepository.findAll();
    }
}
