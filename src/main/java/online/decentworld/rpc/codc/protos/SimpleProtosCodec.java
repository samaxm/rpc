package online.decentworld.rpc.codc.protos;

import com.google.protobuf.InvalidProtocolBufferException;
import online.decentworld.rpc.codc.AbstractCodec;
import online.decentworld.rpc.codc.MessageLisener;
import online.decentworld.rpc.dto.message.types.MessageType;
import online.decentworld.rpc.dto.message.MessageWrapper;
import online.decentworld.rpc.dto.message.protos.MessageProtos.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class SimpleProtosCodec extends AbstractCodec{

	private static Logger logger=LoggerFactory.getLogger(SimpleProtosCodec.class);

	private ProtosBodyCodecFactory codecFactory;
	
	private List<MessageLisener> list=new LinkedList<MessageLisener>();

	public ProtosBodyCodecFactory getCodecFactory() {
		return codecFactory;
	}

	public void setCodecFactory(ProtosBodyCodecFactory codecFactory) {
		this.codecFactory = codecFactory;
	}


	@Override
	public MessageWrapper decode(byte[] data) {
		try {
			Message msg=Message.parseFrom(data);
			return messageParser(msg);
		} catch (InvalidProtocolBufferException e) {
			logger.info("[PARSE_FAILED]",e);
			return null;
		}
		
	}

	@Override
	public byte[] encode(MessageWrapper msg) {
		ProtosMessageCodec codec=getMessageCodec(msg.getType());
		if(codec!=null){
			try {
				return codec.encodeMessage(msg);
			} catch (Exception e) {
				e.printStackTrace();
				logger.warn("[PARSE_MESSAGE_FAILED]",e);
			}
		}else{
			logger.warn("[UNSUPPORTED_MESSAGE_TYPE] type#"+msg.getType());
		}
		return null;
	}

	@Override
	public void addLisener(MessageLisener lisener) {
		synchronized (this) {
			list.add(lisener);
		}
	}

	@Override
	public void notifyLisener(MessageWrapper msg) {
		if(msg!=null){
			for(MessageLisener lisener:list){
				lisener.onMessageReceive(msg);
			}
		}
	}
	
	private MessageWrapper messageParser(Message msg){
		MessageType type=MessageType.getMessageType(msg.getType().getNumber());
		if(type!=null){
			try {
				return  getMessageCodec(type).parseMessage(msg);
			} catch (Exception e) {
				logger.warn("[PARSE_MESSAGE_FAILED]",e);
			}
		}else{
			logger.warn("[UNSUPPORTED_MESSAGE_TYPE] type#"+msg.getType());
		}
		return null;
	}

	private ProtosMessageCodec getMessageCodec(MessageType type){
		return codecFactory.getMessageCodec(type);
	}

}
