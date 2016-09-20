package online.decentworld.rpc.codc.protos;

import online.decentworld.rpc.dto.message.MessageWrapper;
import online.decentworld.rpc.dto.message.protos.MessageProtos.Message;

/**
 * convert protos message bean and normal java bean
 */
public interface ProtosMessageConverter {
	MessageWrapper convertFromProtos2Bean(Message msg) throws Exception;
	Message convertFromBean2Protos(MessageWrapper wrapper) throws Exception;
}
