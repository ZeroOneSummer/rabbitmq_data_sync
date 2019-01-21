package com.dms.data.push.process.controller;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.dms.data.push.commons.mq.MQDataParam;
import com.dms.data.push.commons.mq.PublicPush;
import com.dms.data.push.commons.utils.Constant;
import com.dms.data.push.commons.utils.Result;
import com.dms.data.push.process.entity.*;
import com.dms.data.push.process.service.CouponService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/data")
public class PublicController {
    Logger logger = LoggerFactory.getLogger(PublicController.class);

    @Autowired
    PublicPush publicPush;

    @Autowired
    CouponService couponService;

    @RequestMapping("/push")
    public Result push(@RequestParam(required = false) String sTime,
                       @RequestParam(required = false) String eTime) {

        //不传值，默认上一天
        sTime = StringUtils.isBlank(sTime) ? DateUtil.format(DateUtil.offsetDay(new Date(), -1) ,"yyyy-MM-dd")
                + " 00:00:00" : sTime + " 00:00:00";
        eTime = StringUtils.isBlank(eTime) ? DateUtil.format(DateUtil.offsetDay(new Date(), -1) ,"yyyy-MM-dd")
                + " 23:59:59" : eTime + " 23:59:59";
        logger.info("查询时间: sTime: {} , eTime: {}", sTime, eTime);

        //coupon_detail
        List <CouponDetail> couponDetails = couponService.queryCouponDetailList(sTime, eTime);
        if (couponDetails != null && couponDetails.size() > 0){
            //封装数据
            MQDataParam dataParam = new MQDataParam(Constant.TABLE_OPT_INSERT, Constant.TABLE_NAME_COUPON_DETAIL, couponDetails);
            logger.info("coupon_detail数据推送对应msgId: {}", dataParam.getMsgId());
            publicPush.sendMessage(JSON.toJSONString(dataParam), Constant.EXCHANGE_ASYNC, Constant.ROUTING_KEY_COUPON);
        }

        //coupon_warehouse
        List <CouponWarehouse> couponWarehouses = couponService.queryCouponWarehouseList(sTime, eTime);
        if (couponWarehouses != null && couponWarehouses.size() > 0){
            //封装数据
            MQDataParam dataParam = new MQDataParam(Constant.TABLE_OPT_INSERT, Constant.TABLE_NAME_COUPON_WAREHOUSE, couponWarehouses);
            logger.info("coupon_warehouse数据推送对应msgId: {}", dataParam.getMsgId());
            publicPush.sendMessage(JSON.toJSONString(dataParam), Constant.EXCHANGE_ASYNC, Constant.ROUTING_KEY_COUPON);
        }

        //coupon_use_logs
        List <CouponUseLogs> couponUseLogs = couponService.queryCouponUseLogsList(sTime, eTime);
        if (couponUseLogs != null && couponUseLogs.size() > 0){
            //封装数据
            MQDataParam dataParam = new MQDataParam(Constant.TABLE_OPT_INSERT, Constant.TABLE_NAME_COUPON_USE_LOGS, couponUseLogs);
            logger.info("coupon_use_logs数据推送对应msgId: {}", dataParam.getMsgId());
            publicPush.sendMessage(JSON.toJSONString(dataParam), Constant.EXCHANGE_ASYNC, Constant.ROUTING_KEY_COUPON);
        }

        //coupon_condition
        List <CouponCondition> couponConditions = couponService.queryCouponConditionList(sTime, eTime);
        if (couponConditions != null && couponConditions.size() > 0){
            //封装数据
            MQDataParam dataParam = new MQDataParam(Constant.TABLE_OPT_INSERT, Constant.TABLE_NAME_COUPON_CONDITION, couponConditions);
            logger.info("coupon_condition数据推送对应msgId: {}", dataParam.getMsgId());
            publicPush.sendMessage(JSON.toJSONString(dataParam), Constant.EXCHANGE_ASYNC, Constant.ROUTING_KEY_COUPON);
        }

        //coupon_amountlog
        List <CouponAmountlog> couponAmountlogs = couponService.queryCouponAmountlogList(sTime, eTime);
        if (couponAmountlogs != null && couponAmountlogs.size() > 0){
            //封装数据
            MQDataParam dataParam = new MQDataParam(Constant.TABLE_OPT_INSERT, Constant.TABLE_NAME_COUPON_AMOUNTLOG, couponAmountlogs);
            logger.info("coupon_amountlog数据推送对应msgId: {}", dataParam.getMsgId());
            publicPush.sendMessage(JSON.toJSONString(dataParam), Constant.EXCHANGE_ASYNC, Constant.ROUTING_KEY_COUPON);
        }

        //coupon_order
        List <CouponOrder> couponOrders = couponService.queryCouponOrderList(sTime, eTime);
        if (couponOrders != null && couponOrders.size() > 0){
            //封装数据
            MQDataParam dataParam = new MQDataParam(Constant.TABLE_OPT_INSERT, Constant.TABLE_NAME_COUPON_ORDER, couponOrders);
            logger.info("coupon_order数据推送对应msgId: {}", dataParam.getMsgId());
            publicPush.sendMessage(JSON.toJSONString(dataParam), Constant.EXCHANGE_ASYNC, Constant.ROUTING_KEY_COUPON);
        }

        //coupon_overdue
        List <CouponOverdue> couponOverdues = couponService.queryCouponOverdueList(sTime, eTime);
        if (couponOverdues != null && couponOverdues.size() > 0){
            //封装数据
            MQDataParam dataParam = new MQDataParam(Constant.TABLE_OPT_INSERT, Constant.TABLE_NAME_COUPON_OVERDUE, couponOverdues);
            logger.info("coupon_overdue数据推送对应msgId: {}", dataParam.getMsgId());
            publicPush.sendMessage(JSON.toJSONString(dataParam), Constant.EXCHANGE_ASYNC, Constant.ROUTING_KEY_COUPON);
        }

        //coupon_realname_sendlog
        List <CouponRealnameSendlog> couponRealnameSendlogs = couponService.queryCouponRealnameSendlogList(sTime, eTime);
        if (couponRealnameSendlogs != null && couponRealnameSendlogs.size() > 0){
            //封装数据
            MQDataParam dataParam = new MQDataParam(Constant.TABLE_OPT_INSERT, Constant.TABLE_NAME_COUPON_REALNAME_SENDLOG, couponRealnameSendlogs);
            logger.info("coupon_realname_sendlog数据推送对应msgId: {}", dataParam.getMsgId());
            publicPush.sendMessage(JSON.toJSONString(dataParam), Constant.EXCHANGE_ASYNC, Constant.ROUTING_KEY_COUPON);
        }

        //coupon_verify_record
        List <CouponVerifyRecord> couponVerifyRecords = couponService.queryCouponVerifyRecordList(sTime, eTime);
        if (couponVerifyRecords != null && couponVerifyRecords.size() > 0){
            //封装数据
            MQDataParam dataParam = new MQDataParam(Constant.TABLE_OPT_INSERT, Constant.TABLE_NAME_COUPON_VERIFY_RECORD, couponVerifyRecords);
            logger.info("coupon_verify_record数据推送对应msgId: {}", dataParam.getMsgId());
            publicPush.sendMessage(JSON.toJSONString(dataParam), Constant.EXCHANGE_ASYNC, Constant.ROUTING_KEY_COUPON);
        }

        return Result.succcess();
    }

}
