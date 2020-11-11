package com.engrz.demo.sharding.jdbc.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_user_log")
@Data
public class UserLogEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    @Column
    private String logType;

    @Column
    private String logTitle;

    @Column
    private String logInfo;

    @CreatedDate // 自定义主键生成后不生效
    @Column
    private Date logDate;

}
