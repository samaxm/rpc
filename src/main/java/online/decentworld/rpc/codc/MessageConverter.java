package online.decentworld.rpc.codc;

import online.decentworld.rpc.dto.message.MessageWrapper;
import online.decentworld.rpc.dto.message.protos.MessageProtos.Message;

/**
 * convert protos message bean and normal java bean
 */
public interface MessageConverter {
	MessageWrapper fromStream2Bean(Message msg) throws Exception;
	byte[] fromBean2Stream(MessageWrapper wrapper) throws Exception;
}
