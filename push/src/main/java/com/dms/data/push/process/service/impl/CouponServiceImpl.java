package com.dms.data.push.process.service.impl;

import com.dms.data.push.process.dao.CouponDao;
import com.dms.data.push.process.entity.*;
import com.dms.data.push.process.service.CouponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CouponDao couponDao;

    @Override
    public List<CouponDetail> queryCouponDetailList(String sTime, String eTime) {
        return couponDao.queryCouponDetailList(sTime, eTime);
    }

    @Override
    public List <CouponWarehouse> queryCouponWarehouseList(String sTime, String eTime) {
        return couponDao.queryCouponWarehouseList(sTime, eTime);
    }

    @Override
    public List <CouponUseLogs> queryCouponUseLogsList(String sTime, String eTime) {
        return couponDao.queryCouponUseLogsList(sTime, eTime);
    }

    @Override
    public List <CouponCondition> queryCouponConditionList(String sTime, String eTime) {
        return couponDao.queryCouponConditionList(sTime, eTime);
    }

    @Override
    public List <CouponAmountlog> queryCouponAmountlogList(String sTime, String eTime) {
        return couponDao.queryCouponAmountlogList(sTime, eTime);
    }

    @Override
    public List <CouponOrder> queryCouponOrderList(String sTime, String eTime) {
        return couponDao.queryCouponOrderList(sTime, eTime);
    }

    @Override
    public List <CouponOverdue> queryCouponOverdueList(String sTime, String eTime) {
        return couponDao.queryCouponOverdueList(sTime, eTime);
    }

    @Override
    public List <CouponRealnameSendlog> queryCouponRealnameSendlogList(String sTime, String eTime) {
        return couponDao.queryCouponRealnameSendlogList(sTime, eTime);
    }

    @Override
    public List <CouponVerifyRecord> queryCouponVerifyRecordList(String sTime, String eTime) {
        return couponDao.queryCouponVerifyRecordList(sTime, eTime);
    }

}
