package online.decentworld.rpc.codc.protos;

import com.google.protobuf.InvalidProtocolBufferException;
import online.decentworld.rpc.codc.AbstractCodec;
import online.decentworld.rpc.codc.MessageListener;
import online.decentworld.rpc.dto.message.types.MessageType;
import online.decentworld.rpc.dto.message.MessageWrapper;
import online.decentworld.rpc.dto.message.protos.MessageProtos.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class SimpleProtosCodec extends AbstractCodec{

	private static Logger logger=LoggerFactory.getLogger(SimpleProtosCodec.class);


	private ProtosBodyConverterFactory converterFactory;
	
	private List<MessageListener> list=new LinkedList<MessageListener>();


	public ProtosBodyConverterFactory getConverterFactory() {
		return converterFactory;
	}

	public void setConverterFactory(ProtosBodyConverterFactory converterFactory) {
		this.converterFactory = converterFactory;
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
		ProtosMessageConverter converter=getMessageConverter(msg.getType());
		if(converter!=null){
			try {
				return converter.convertFromBean2Protos(msg).toByteArray();
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
	public void addListener(MessageListener listener) {
		synchronized (this) {
			list.add(listener);
		}
	}


	@Override
	public void notifyListener(MessageWrapper msg) {
		if(msg!=null){
			for(MessageListener listener:list){
				listener.onMessageReceive(msg);
			}
		}
	}
	
	private MessageWrapper messageParser(Message msg){
		MessageType type=MessageType.getMessageType(msg.getType().getNumber());
		if(type!=null){
			try {
				return  getMessageConverter(type).convertFromProtos2Bean(msg);
			} catch (Exception e) {
				logger.warn("[PARSE_MESSAGE_FAILED]",e);
			}
		}else{
			logger.warn("[UNSUPPORTED_MESSAGE_TYPE] type#"+msg.getType());
		}
		return null;
	}

	private ProtosMessageConverter getMessageConverter(MessageType type){
		return converterFactory.getMessageConverter(type);
	}

}
