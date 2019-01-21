package com.dms.data.push.process.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CouponUseLogs implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String couponSn;

    private String useType;

    private Date useTime;

    private String useUser;

    private String orderCode;

    private String memo;
}