package com.dms.data.push.commons.mq;

import cn.hutool.core.date.DateUtil;
import lombok.Data;

import java.util.Date;

@Data
public class MQDataParam <T> {

	private String opt;
	private String tableName;
	private T data;
	private String msgId;
	private String pushDay;

	public MQDataParam(String opt, String tableName, T data){
		this.msgId = String.valueOf(System.currentTimeMillis());
		this.pushDay = DateUtil.format(new Date(),"yyyy-MM-dd");
		this.opt = opt;
		this.tableName = tableName;
		this.data = data;
	}

	@Override
	public String toString() {
		return "MQDataParam [opt=" + opt + ", data=" + data + ", tableName=" + tableName
				+ ", msgId=" + msgId + ", pushDay=" + pushDay + "]";
	}

}
