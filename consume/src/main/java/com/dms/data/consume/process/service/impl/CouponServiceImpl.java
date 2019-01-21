package com.dms.data.consume.process.service.impl;

import com.dms.data.consume.process.dao.CouponDao;
import com.dms.data.consume.process.entity.*;
import com.dms.data.consume.process.service.CouponService;
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
    public void addCouponDetails(List<CouponDetail> list) {
        couponDao.addCouponDetails(list);
    }

    @Override
    public void addCouponWarehouses(List <CouponWarehouse> list) {
        couponDao.addCouponWarehouses(list);
    }

    @Override
    public void addCouponUseLogs(List <CouponUseLogs> list) {
        couponDao.addCouponUseLogs(list);
    }

    @Override
    public void addCouponConditions(List <CouponCondition> list) {
        couponDao.addCouponConditions(list);
    }

    @Override
    public void addCouponAmountlogs(List <CouponAmountlog> list) {
        couponDao.addCouponAmountlogs(list);
    }

    @Override
    public void addCouponOrders(List <CouponOrder> list) {
        couponDao.addCouponOrders(list);
    }

    @Override
    public void addCouponOverdues(List <CouponOverdue> list) {
        couponDao.addCouponOverdues(list);
    }

    @Override
    public void addCouponRealnameSendlogs(List <CouponRealnameSendlog> list) {
        couponDao.addCouponRealnameSendlogs(list);
    }

    @Override
    public void addCouponVerifyRecords(List <CouponVerifyRecord> list) {
        couponDao.addCouponVerifyRecords(list);
    }
}
