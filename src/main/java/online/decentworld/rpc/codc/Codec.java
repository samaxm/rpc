package online.decentworld.rpc.codc;

import online.decentworld.rpc.dto.message.MessageWrapper;


public interface Codec {

	MessageWrapper decode(byte[] data);

	byte[] encode(MessageWrapper msg);
	
	void receiveData(byte[] data);
	
	void addLisener(MessageLisener lisener);
	
	void notifyLisener(MessageWrapper msg);
}
