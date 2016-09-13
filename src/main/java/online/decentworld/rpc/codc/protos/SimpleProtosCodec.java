package online.decentworld.rpc.codc.protos;

import com.google.protobuf.InvalidProtocolBufferException;
import online.decentworld.rpc.codc.AbstractCodec;
import online.decentworld.rpc.codc.MessageLisener;
import online.decentworld.rpc.dto.message.BaseMessage;
import online.decentworld.rpc.dto.message.ChatMessageType;
import online.decentworld.rpc.dto.message.protos.MessageProtos.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class SimpleProtosCodec extends AbstractCodec{

	private static Logger logger=LoggerFactory.getLogger(SimpleProtosCodec.class);
	
	private ProtosBodyCodecFactory codecFactory=new ReflectBodyCodecFactory();
	
	private List<MessageLisener> list=new LinkedList<MessageLisener>();
	
	
	@Override
	public BaseMessage decode(byte[] data) {
		try {
			Message msg=Message.parseFrom(data);
			return messageParser(msg);
		} catch (InvalidProtocolBufferException e) {
			logger.info("[PARSE_FAILED]",e);
			return null;
		}
		
	}

	@Override
	public void addLisener(MessageLisener lisener) {
		synchronized (this) {
			list.add(lisener);
		}
	}

	@Override
	public void notifyLisener(BaseMessage msg) {
		if(msg!=null){
			for(MessageLisener lisener:list){
				lisener.onMessageReceive(msg);
			}
		}
	}
	
	private BaseMessage messageParser(Message msg){
		ChatMessageType type= ChatMessageType.getMessageType(msg.getType().getNumber());
		if(type!=null){
			try {
				return codecFactory.getMessageCodec(type).parseMessage(msg);
			} catch (Exception e) {
				logger.warn("[CODEC_ERROR]",e);
			}
		}
		return null;

	}

}
