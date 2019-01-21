package com.dms.data.push.process.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CouponVerifyRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String couponNo;

    private String status;

    private String rmk;

    private Date createTime;

    private Date updateTime;

    private String updateUser;
}