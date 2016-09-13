package online.decentworld.rpc.codc.protos;

import online.decentworld.rpc.dto.message.ChatMessageType;

public interface ProtosBodyCodecFactory {
	ProtosMessageCodec getMessageCodec(ChatMessageType type);
}
