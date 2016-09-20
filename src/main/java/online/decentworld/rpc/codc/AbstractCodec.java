package online.decentworld.rpc.codc;

import online.decentworld.rpc.dto.message.MessageWrapper;

public abstract class AbstractCodec implements Codec{

	@Override
	public void receiveData(byte[] data) {
		if(data==null)
			return;
		MessageWrapper msg=decode(data);
		if(msg!=null){
			notifyListener(msg);
		}
	}

}
