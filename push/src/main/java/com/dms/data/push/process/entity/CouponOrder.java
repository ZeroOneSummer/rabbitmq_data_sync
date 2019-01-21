package com.dms.data.push.process.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class CouponOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    private String orderNo;

    private String couponSn;

    private String couponType;

    private String orderCloseNo;

    private String orderCloseDate;

    private String loginCode;

    private String accId;

    private BigDecimal orderMoney;

    private BigDecimal orderCouponMoney;

    private BigDecimal profitClose;

    private BigDecimal returnMoney;

    private Date creDate;

    private String hasTransfer;

    private Date transferDate;

    private Integer transferCount;

    private String remark;

    //SSM
//    private Long chargeOpen;

//    private Long extraCharge;

    //KKG
    private String serialNo;
}