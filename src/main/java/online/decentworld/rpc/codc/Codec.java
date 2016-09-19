package online.decentworld.rpc.codc;

import online.decentworld.rpc.codc.protos.ReflectBodyCodecFactory;
import online.decentworld.rpc.codc.protos.SimpleProtosCodec;
import online.decentworld.rpc.dto.message.MessageWrapper;
import online.decentworld.rpc.dto.message.WealthAckMessage;
import online.decentworld.rpc.dto.message.types.ChatRelation;
import online.decentworld.rpc.dto.message.types.ChatStatus;
import online.decentworld.rpc.dto.message.types.MessageType;


public interface Codec {

	MessageWrapper decode(byte[] data);

	byte[] encode(MessageWrapper msg);
	
	void receiveData(byte[] data);
	
	void addLisener(MessageLisener lisener);
	
	void notifyLisener(MessageWrapper msg);

	public static void main(String[] args) {
		SimpleProtosCodec c=new SimpleProtosCodec();
		c.setCodecFactory(new ReflectBodyCodecFactory());
		WealthAckMessage msg=new WealthAckMessage("123",123,123,true,ChatRelation.FRIEND, ChatStatus.FREE);
//		TextChatMessage cm=TextChatMessage.createTextMessage("123","321","bbbbb");
		MessageWrapper wrapper=new MessageWrapper("123","321",MessageType.WEALTH_ACK,msg);
		byte[] data=c.encode(wrapper);

		MessageWrapper wrapper1=c.decode(data);
		System.out.println(wrapper1);
		if(wrapper1.getType()==MessageType.WEALTH_ACK){
			WealthAckMessage cm1=(WealthAckMessage)(wrapper1.getBody());
			System.out.println(cm1.getWealth());
		}
	}
}
