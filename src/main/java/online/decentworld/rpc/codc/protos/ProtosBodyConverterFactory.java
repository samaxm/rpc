package online.decentworld.rpc.codc.protos;


import online.decentworld.rpc.dto.message.types.MessageType;

public interface ProtosBodyConverterFactory {
	ProtosMessageConverter getMessageConverter(MessageType type);
}
