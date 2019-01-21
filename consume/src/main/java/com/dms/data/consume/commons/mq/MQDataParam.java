package com.dms.data.consume.commons.mq;


import com.alibaba.fastjson.JSONObject;

public class MQDataParam {

	private String opt;
	private JSONObject data;
	private String tableName;
	private Integer msgId;
	private String pushDay;

	public String getOpt() {
		return opt;
	}

	public void setOpt(String opt) {
		this.opt = opt;
	}

	public JSONObject getData() {
		return data;
	}

	public void setData(JSONObject data) {
		this.data = data;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Integer getMsgId() {
		return msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}

	public String getPushDay() {
		return pushDay;
	}

	public void setPushDay(String pushDay) {
		this.pushDay = pushDay;
	}

	@Override
	public String toString() {
		return "MQDataParam [opt=" + opt + ", data=" + data + ", tableName=" + tableName
				+ ", msgId=" + msgId + ", pushDay=" + pushDay + "]";
	}

}
