package com.engrz.demo.sharding.jdbc.repository;

import com.engrz.demo.sharding.jdbc.entity.UserLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLogRepository extends JpaRepository<UserLogEntity, Long> {

}
