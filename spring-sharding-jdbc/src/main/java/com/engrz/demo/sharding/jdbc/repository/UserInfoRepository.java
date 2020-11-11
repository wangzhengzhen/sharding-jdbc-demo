package com.engrz.demo.sharding.jdbc.repository;

import com.engrz.demo.sharding.jdbc.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Long> {


}
