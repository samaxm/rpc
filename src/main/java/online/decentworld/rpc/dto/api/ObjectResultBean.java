package online.decentworld.rpc.dto.api;


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

}
