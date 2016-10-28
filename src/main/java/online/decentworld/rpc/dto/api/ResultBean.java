package online.decentworld.rpc.dto.api;

import com.alibaba.fastjson.JSON;

public class ResultBean {
	private int statusCode;
	private String msg;
	final public static ResultBean SUCCESS=new ObjectResultBean(StatusCode.SUCCESS,null,null);
	public int getStatusCode() {
		return statusCode;
	}
	
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public ResultBean(int statusCode) {
		super();
		this.statusCode = statusCode;
	}
	public ResultBean() {
	}

	public String toJSON(){
		return JSON.toJSONString(this);
	}
	public static ResultBean FAIL(String msg){
		return ObjectResultBean.FAIL(msg);
	}
}
