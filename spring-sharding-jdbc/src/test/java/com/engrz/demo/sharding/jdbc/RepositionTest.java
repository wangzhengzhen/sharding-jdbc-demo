package com.engrz.demo.sharding.jdbc;

import com.engrz.demo.sharding.jdbc.entity.UserInfoEntity;
import com.engrz.demo.sharding.jdbc.entity.UserLogEntity;
import com.engrz.demo.sharding.jdbc.repository.UserLogRepository;
import com.engrz.demo.sharding.jdbc.service.UserInfoService;
import com.engrz.demo.sharding.jdbc.service.UserLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RepositionTest {

    @Autowired
    private UserInfoService userInfoServiceImpl;

    @Autowired
    private UserLogService userLogServiceImpl;

    @Test
    public void saveUserInfo() {

        UserInfoEntity entity = new UserInfoEntity();
        entity.setUserName("junit test");
        entity.setMobile("13899990000");
        entity.setLoginName("engrz_" + new Random().nextInt(Integer.MAX_VALUE));
        entity.setLoginPasswd("******");
        entity.setStatus("01");
        entity.setRegisterDate(new Date());
        userInfoServiceImpl.save(entity);
    }

    @Test
    public void saveUserLog() {

        UserLogEntity entity = new UserLogEntity();
        entity.setLogType("01");
        entity.setLogTitle("junit测试");
        entity.setLogInfo("springboot集成测试");
        userLogServiceImpl.save(entity);

    }

}
