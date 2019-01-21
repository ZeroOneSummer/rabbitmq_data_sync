package com.dms.data.consume.process.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CouponRealnameSendlog implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String loginCode;

    private String status;

    private String rmk;

    private Date createTime;

    private Date updateTime;

    private String dealerCode;

    private String couponSn;
}