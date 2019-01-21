package com.dms.data.consume.commons.mq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dms.data.consume.commons.utils.Constant;
import com.dms.data.consume.process.entity.*;
import com.dms.data.consume.process.service.CouponService;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PublicCustomer implements ChannelAwareMessageListener {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    CouponService couponService;

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {

        try {
            String mq_message = new String(message.getBody(), "UTF-8");
            JSONObject jsonObject = JSONObject.parseObject(mq_message);

            String tableName = jsonObject.getString("tableName");
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            if (jsonArray.size() == 0) return;

            switch (tableName){
                case Constant.TABLE_NAME_COUPON_DETAIL: //coupon_detail
                    List<CouponDetail> couponDetails = JSONArray.parseArray(jsonArray.toJSONString() ,CouponDetail.class);
                    logger.info("接收到消息总数{}，开始写入表coupon_detail：{}", couponDetails.size(), JSON.toJSONString(couponDetails.get(0)));
                    couponService.addCouponDetails(couponDetails);
                    break;
                case Constant.TABLE_NAME_COUPON_WAREHOUSE: //coupon_warehouse
                    List<CouponWarehouse> couponWarehouses = JSONArray.parseArray(jsonArray.toJSONString() ,CouponWarehouse.class);
                    logger.info("接收到消息总数{}，开始写入表coupon_warehouse：{}", couponWarehouses.size(), JSON.toJSONString(couponWarehouses.get(0)));
                    couponService.addCouponWarehouses(couponWarehouses);
                    break;
                case Constant.TABLE_NAME_COUPON_USE_LOGS: //coupon_use_logs
                    List<CouponUseLogs> couponUseLogs = JSONArray.parseArray(jsonArray.toJSONString() ,CouponUseLogs.class);
                    logger.info("接收到消息总数{}，开始写入表coupon_use_logs：{}", couponUseLogs.size(), JSON.toJSONString(couponUseLogs.get(0)));
                    couponService.addCouponUseLogs(couponUseLogs);
                    break;
                case Constant.TABLE_NAME_COUPON_CONDITION: //coupon_condition
                    List<CouponCondition> couponConditions = JSONArray.parseArray(jsonArray.toJSONString() ,CouponCondition.class);
                    logger.info("接收到消息总数{}，开始写入表coupon_condition：{}", couponConditions.size(), JSON.toJSONString(couponConditions.get(0)));
                    couponService.addCouponConditions(couponConditions);
                    break;
                case Constant.TABLE_NAME_COUPON_AMOUNTLOG: //coupon_amountlog
                    List<CouponAmountlog> couponAmountlogs = JSONArray.parseArray(jsonArray.toJSONString() ,CouponAmountlog.class);
                    logger.info("接收到消息总数{}，开始写入表coupon_amountlog：{}", couponAmountlogs.size(), JSON.toJSONString(couponAmountlogs.get(0)));
                    couponService.addCouponAmountlogs(couponAmountlogs);
                    break;
                case Constant.TABLE_NAME_COUPON_ORDER: //coupon_order
                    List<CouponOrder> couponOrders = JSONArray.parseArray(jsonArray.toJSONString() ,CouponOrder.class);
                    logger.info("接收到消息总数{}，开始写入表coupon_order：{}", couponOrders.size(), JSON.toJSONString(couponOrders.get(0)));
                    couponService.addCouponOrders(couponOrders);
                    break;
                case Constant.TABLE_NAME_COUPON_OVERDUE: //coupon_overdue
                    List<CouponOverdue> couponOverdues = JSONArray.parseArray(jsonArray.toJSONString() ,CouponOverdue.class);
                    logger.info("接收到消息总数{}，开始写入表coupon_overdue：{}", couponOverdues.size(), JSON.toJSONString(couponOverdues.get(0)));
                    couponService.addCouponOverdues(couponOverdues);
                    break;
                case Constant.TABLE_NAME_COUPON_REALNAME_SENDLOG: //coupon_realname_sendlog
                    List<CouponRealnameSendlog> couponRealnameSendlogs = JSONArray.parseArray(jsonArray.toJSONString() ,CouponRealnameSendlog.class);
                    logger.info("接收到消息总数{}，开始写入表coupon_realname_sendlog：{}", couponRealnameSendlogs.size(), JSON.toJSONString(couponRealnameSendlogs.get(0)));
                    couponService.addCouponRealnameSendlogs(couponRealnameSendlogs);
                    break;
                case Constant.TABLE_NAME_COUPON_VERIFY_RECORD: //coupon_verify_record
                    List<CouponVerifyRecord> couponVerifyRecords = JSONArray.parseArray(jsonArray.toJSONString() ,CouponVerifyRecord.class);
                    logger.info("接收到消息总数{}，开始写入表coupon_verify_record：{}", couponVerifyRecords.size(), JSON.toJSONString(couponVerifyRecords.get(0)));
                    couponService.addCouponVerifyRecords(couponVerifyRecords);
                    break;
                default:
                    logger.info("未匹配到任何表");
                    break;
            }
        } finally {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); //确认消息成功消费
        }
    }

}
