package online.decentworld.rpc.dto.message;

public interface BaseMessage {

	public MessageRecipient getSender();
	
	public MessageRecipient getReceiver();
	
	public MessageType getMessageType();
	
	public MessageBody getMessageBody();
	
	public byte[] getWriteByte();
	
}
