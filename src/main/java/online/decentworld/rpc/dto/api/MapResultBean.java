package online.decentworld.rpc.dto.api;

import java.util.HashMap;
import java.util.Map;

public class MapResultBean<K,E>  extends ResultBean{
	private Map<K,E> data=new HashMap<K,E>();
	public Map<K, E> getData() {
		return data;
	}
	public void setData(Map<K, E> data) {
		this.data = data;
	}
	
}
