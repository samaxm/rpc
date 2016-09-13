package online.decentworld.rpc.dto.message;

public interface BaseMessage {

	public String getSender();
	
	public String getReceiver();
	
	public ChatMessageType getMessageType();
	
	public MessageBody getMessageBody();

}
