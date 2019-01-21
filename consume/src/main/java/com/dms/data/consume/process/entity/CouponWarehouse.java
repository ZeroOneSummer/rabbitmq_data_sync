package com.dms.data.consume.process.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class CouponWarehouse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String couponSn;

    private String couponNo;

    private BigDecimal price;

    private String couponPass;

    private String logincode;

    private String useStatus;

    private Date couponUseEndDate;

    private Date useTime;
}