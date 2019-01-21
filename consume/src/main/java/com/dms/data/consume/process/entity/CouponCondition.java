package com.dms.data.consume.process.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CouponCondition implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String couponNo;

    private String type;

    private String conditionType;

    private String conditionValue;

    private String status;

    private Date createTime;

    private String createUser;

    private Date updateTime;

    private String updateUser;
}