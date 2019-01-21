package com.dms.data.consume.commons.utils;

/**
 * @author jp
 * @Description: 常量类
 * @date 2019/1/15 11:09
 */
public class Constant {

    /**
     * MQ
     */
    public static final String EXCHANGE_ASYNC = "exchange:fanout:sadmin:ws";                    //交换机名称
    public static final String EXCHANGE_TYPE_FANOUT = "fanout";                                 //交换机fanout类型
    public static final String EXCHANGE_TYPE_DIRECT = "direct";                                 //交换机direct类型
    public static final String EXCHANGE_TYPE_TOPIC = "topic";                                   //交换机topic类型
    public static final String QUEUE_COUPON = "fanout:queue:sadmin:couponQueue";                //路由键

    /**
     * TABLE
     */
    public static final String TABLE_OPT_INSERT = "insert";                                     //insert表操作
    public static final String TABLE_OPT_UPDATE = "update";                                     //update表操作
    public static final String TABLE_NAME_COUPON_DETAIL = "coupon_detail";                      //券详情表
    public static final String TABLE_NAME_COUPON_WAREHOUSE = "coupon_warehouse";                //券仓库表
    public static final String TABLE_NAME_COUPON_USE_LOGS = "coupon_use_logs";                  //券使用记录表
    public static final String TABLE_NAME_COUPON_CONDITION = "coupon_condition";                //券限制条件表
    public static final String TABLE_NAME_COUPON_AMOUNTLOG = "coupon_amountlog";                //券资金流水表
    public static final String TABLE_NAME_COUPON_ORDER = "coupon_order";                        //券订单表
    public static final String TABLE_NAME_COUPON_OVERDUE = "coupon_overdue";                    //券失效表
    public static final String TABLE_NAME_COUPON_REALNAME_SENDLOG = "coupon_realname_sendlog";  //券实名发放记录表
    public static final String TABLE_NAME_COUPON_VERIFY_RECORD = "coupon_verify_record";        //券审核记录表

}
