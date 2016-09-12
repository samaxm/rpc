package online.decentworld.rpc.codc;

import online.decentworld.rpc.dto.message.BaseMessage;

public abstract class AbstractCodec implements Codec{

	public abstract BaseMessage decode(byte[] data);

	@Override
	public void receiveData(byte[] data) {
		BaseMessage msg=decode(data);
		if(msg!=null){
			notifyLisener(msg);
		}
	}

	public abstract void addLisener(MessageLisener lisener);

	public abstract void notifyLisener(BaseMessage msg);

}
