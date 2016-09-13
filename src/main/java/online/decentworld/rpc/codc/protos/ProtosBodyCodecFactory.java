package online.decentworld.rpc.codc.protos;


import online.decentworld.rpc.dto.message.types.MessageType;

public interface ProtosBodyCodecFactory {
	ProtosMessageCodec getMessageCodec(MessageType type);
}
