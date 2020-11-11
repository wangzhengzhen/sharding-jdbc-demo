package com.engrz.demo.sharding.jdbc.service;

import com.engrz.demo.sharding.jdbc.entity.UserInfoEntity;

import java.util.List;

public interface UserInfoService {

    /**
     * 保存/更新用户信息
     * @param entity
     */
    void save(UserInfoEntity entity);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    UserInfoEntity findById(Long id);

    /**
     * 查询所有
     * @param condition
     * @return
     */
    List<UserInfoEntity> queryAll(UserInfoEntity condition);

}
