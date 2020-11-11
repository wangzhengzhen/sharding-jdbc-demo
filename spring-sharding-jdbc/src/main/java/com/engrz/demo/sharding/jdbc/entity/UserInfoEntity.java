package com.engrz.demo.sharding.jdbc.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_user_info")
@Data
public class UserInfoEntity implements Serializable {

    @Id
    private Long userId;

    @Column
    private String loginName;

    @Column
    private String loginPasswd;

    @Column
    private String userName;

    @Column
    private String mobile;

    @Column
    private String status;

    @CreatedDate
    @Column
    private Date registerDate;

    @Column
    private Date lastLoginDate;
}
