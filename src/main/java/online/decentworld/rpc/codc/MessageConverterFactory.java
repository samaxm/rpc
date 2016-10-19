package online.decentworld.rpc.codc;


import online.decentworld.rpc.dto.message.types.MessageType;

public interface MessageConverterFactory {
	MessageConverter getMessageConverter(MessageType type);

}
