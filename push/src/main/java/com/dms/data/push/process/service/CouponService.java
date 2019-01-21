package com.dms.data.push.process.service;

import com.dms.data.push.process.entity.*;

import java.util.List;

public interface CouponService {

    /* 券详情表 */
    List<CouponDetail> queryCouponDetailList(String sTime, String eTime);

    /* 券仓库表 */
    List<CouponWarehouse> queryCouponWarehouseList(String sTime, String eTime);

    /* 券使用记录表 */
    List<CouponUseLogs> queryCouponUseLogsList(String sTime, String eTime);

    /* 券限制条件表 */
    List<CouponCondition> queryCouponConditionList(String sTime, String eTime);

    /* 券资金流水表 */
    List<CouponAmountlog> queryCouponAmountlogList(String sTime, String eTime);

    /* 券订单表 */
    List<CouponOrder> queryCouponOrderList(String sTime, String eTime);

    /* 券失效表 */
    List<CouponOverdue> queryCouponOverdueList(String sTime, String eTime);

    /* 券实名发放记录表 */
    List<CouponRealnameSendlog> queryCouponRealnameSendlogList(String sTime, String eTime);

    /* 券审核记录表 */
    List<CouponVerifyRecord> queryCouponVerifyRecordList(String sTime, String eTime);
    
}


