package com.dms.data.consume.process.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class CouponOverdue implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String couponSn;

    private BigDecimal overdueMoney;

    private Date creDate;

    private String hasTransfer;

    private String type;

    private Date transferDate;

    private Integer transferCount;

    private String remark;
}