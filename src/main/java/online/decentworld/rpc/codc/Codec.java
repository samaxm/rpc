package online.decentworld.rpc.codc;

import online.decentworld.rpc.dto.message.MessageWrapper;



public interface Codec {

	MessageWrapper decode(byte[] data);

	byte[] encode(MessageWrapper msg);
	
	void receiveData(byte[] data);
	
	void addListener(MessageListener listener);
	
	void notifyListener(MessageWrapper msg);


}
