package online.decentworld.rpc.dto.api;


import com.alibaba.fastjson.JSON;

public class ObjectResultBean extends ResultBean {
	private Object data;
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	public ObjectResultBean(int statusCode,String msg,Object data) {
		this.setStatusCode(statusCode);
		this.setMsg(msg);
		this.data = data;
	}

	public ObjectResultBean(){};

	public static ObjectResultBean SUCCESS(Object data){
		return new ObjectResultBean(StatusCode.SUCCESS,null,data);
	}
	public static ResultBean FAIL(String msg){
		ObjectResultBean bean=new ObjectResultBean();
		bean.setStatusCode(StatusCode.FAILED);
		bean.setMsg(msg);
		return bean;
	}

	public static void main(String[] args) {
		ResultBean bean=ResultBean.FAIL("123");
		System.out.println(JSON.toJSONString(bean));
	}
}
