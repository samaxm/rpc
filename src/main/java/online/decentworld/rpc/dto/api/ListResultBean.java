package online.decentworld.rpc.dto.api;

import java.util.LinkedList;
import java.util.List;

public class ListResultBean<E> extends ResultBean {
	
	private List<E> data=new LinkedList<E>();
	

	public List<E> getData() {
		return data;
	}
	public void setData(List<E> data) {
		this.data = data;
	}
	
}
