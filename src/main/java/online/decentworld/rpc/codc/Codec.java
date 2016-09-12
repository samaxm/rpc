package online.decentworld.rpc.codc;

import online.decentworld.rpc.dto.message.BaseMessage;


public interface Codec {

	BaseMessage decode(byte[] data);
	
	void receiveData(byte[] data);
	
	void addLisener(MessageLisener lisener);
	
	void notifyLisener(BaseMessage msg);
}
