package online.decentworld.rpc.transfer;

import online.decentworld.rpc.codc.Codec;

public interface Consumer {

	void setCodec(Codec codec);
	
	void setLisenedChannel(MessageChannel channel);
	
	boolean isReady();
	
	void startLisening();
	
}
