package com.dms.data.consume.process.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class CouponAmountlog implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Long amId;

    private Date tradingDay;

    private String couponSn;

    private BigDecimal amChange;

    private String type;

    private BigDecimal desAftDrawable;

    private BigDecimal desBefDrawable;

    private BigDecimal srcAftDrawable;

    private BigDecimal srcBefDrawable;

    private String desAccid;

    private String srcAccid;

    private Date createTime;

    private Date completeDate;

    private String rmk1;

    private String rmk2;

    private String status;

    private String remark;
}