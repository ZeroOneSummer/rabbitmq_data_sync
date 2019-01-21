package com.dms.data.push.process.dao;

import com.dms.data.push.process.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CouponDao {

    /* 券详情表 */
    List<CouponDetail> queryCouponDetailList(@Param("sTime") String sTime, @Param("eTime") String eTime);

    /* 券仓库表 */
    List<CouponWarehouse> queryCouponWarehouseList(@Param("sTime") String sTime, @Param("eTime") String eTime);

    /* 券使用记录表 */
    List<CouponUseLogs> queryCouponUseLogsList(@Param("sTime") String sTime, @Param("eTime") String eTime);

    /* 券限制条件表 */
    List<CouponCondition> queryCouponConditionList(@Param("sTime") String sTime, @Param("eTime") String eTime);

    /* 券资金流水表 */
    List<CouponAmountlog> queryCouponAmountlogList(@Param("sTime") String sTime, @Param("eTime") String eTime);

    /* 券订单表 */
    List<CouponOrder> queryCouponOrderList(@Param("sTime") String sTime, @Param("eTime") String eTime);

    /* 券失效表 */
    List<CouponOverdue> queryCouponOverdueList(@Param("sTime") String sTime, @Param("eTime") String eTime);

    /* 券实名发放记录表 */
    List<CouponRealnameSendlog> queryCouponRealnameSendlogList(@Param("sTime") String sTime, @Param("eTime") String eTime);

    /* 券审核记录表 */
    List<CouponVerifyRecord> queryCouponVerifyRecordList(@Param("sTime") String sTime, @Param("eTime") String eTime);
}
