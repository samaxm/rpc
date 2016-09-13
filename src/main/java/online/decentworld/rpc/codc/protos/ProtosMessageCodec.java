package online.decentworld.rpc.codc.protos;

import online.decentworld.rpc.dto.message.MessageWrapper;
import online.decentworld.rpc.dto.message.protos.MessageProtos.Message;

public interface ProtosMessageCodec {
	MessageWrapper parseMessage(Message msg) throws Exception;
	byte[] encodeMessage(MessageWrapper wrapper) throws Exception;
}
