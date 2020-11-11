package com.engrz.demo.sharding.jdbc.service;

import com.engrz.demo.sharding.jdbc.entity.UserLogEntity;

import java.util.List;

public interface UserLogService {

    /**
     * 保存日志
     * @param entity
     */
    void save(UserLogEntity entity);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    UserLogEntity findById(Long id);

    /**
     * 查询所有
     * @param condition
     * @return
     */
    List<UserLogEntity> queryAll(UserLogEntity condition);

}
