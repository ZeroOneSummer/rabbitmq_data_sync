package com.dms.data.consume.process.dao;

import com.dms.data.consume.process.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CouponDao{

    /* 券详情表 */
    void addCouponDetails(List<CouponDetail> list);

    /* 券仓库表 */
    void addCouponWarehouses(List<CouponWarehouse> list);

    /* 券使用记录表 */
    void addCouponUseLogs(List<CouponUseLogs> list);

    /* 券限制条件表 */
    void addCouponConditions(List<CouponCondition> list);

    /* 券资金流水表 */
    void addCouponAmountlogs(List<CouponAmountlog> list);

    /* 券订单表 */
    void addCouponOrders(List<CouponOrder> list);

    /* 券失效表 */
    void addCouponOverdues(List<CouponOverdue> list);

    /* 券实名发放记录表 */
    void addCouponRealnameSendlogs(List<CouponRealnameSendlog> list);

    /* 券审核记录表 */
    void addCouponVerifyRecords(List<CouponVerifyRecord> list);
}
