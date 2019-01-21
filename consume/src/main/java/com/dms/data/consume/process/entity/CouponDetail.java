package com.dms.data.consume.process.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class CouponDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String couponNo;

    private String couponName;

    private String status;

    private String couponType;

    private String dealerId;

    private BigDecimal totalPrice;

    private BigDecimal price;

    private BigDecimal fullPrice;

    private Date startDate;

    private Date endDate;

    private Integer couponGetInvalidDay;

    private Integer couponNumber;

    private String messageType;

    private String photo;

    private String description;

    private String obtainType;

    private Integer obtainLimit;

    private String sendType;

    private String getType;

    private Date createTime;

    private String createUser;

    private Date updateTime;

    private String updateUser;
}