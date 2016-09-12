package online.decentworld.rpc.codc.protos;

import online.decentworld.rpc.dto.message.BaseMessage;
import online.decentworld.rpc.dto.message.protos.MessageProtos.Message;

public interface ProtosMessageCodec {
	BaseMessage parseMessage(Message msg) throws Exception;
}
