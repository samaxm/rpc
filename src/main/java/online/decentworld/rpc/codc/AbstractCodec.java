package online.decentworld.rpc.codc;

import online.decentworld.rpc.dto.message.MessageWrapper;

public abstract class AbstractCodec implements Codec{

	public abstract MessageWrapper decode(byte[] data);

	@Override
	public void receiveData(byte[] data) {
		MessageWrapper msg=decode(data);
		if(msg!=null){
			notifyLisener(msg);
		}
	}

	public abstract void addLisener(MessageLisener lisener);

	public abstract void notifyLisener(MessageWrapper msg);

}
