package com.dms.data.consume.commons.utils;

public class ResultCode {
    /**
     * 操作成功
     */
    public static final Integer SUCCESS_CODE=200;
    public static final String SUCCESS_MESSAGE="success";

    /**
     * 业务异常
     */
    public static final Integer BUSINESS_CODE=300;
    public static final String BUSINESS_MESSAGE="business error";

    /**
     * 业务参数异常
     */
    public static final Integer BUSINESS_PARAM_CODE=301;
    public static final String BUSINESS_PARAM_MESSAGE="business param error";

    /**
     * 服务器内部异常
     */
    public static final Integer ERROR_CODE=500;
    public static final String ERROR_MESSAGE="error";

}
