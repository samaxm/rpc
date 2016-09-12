package online.decentworld.rpc.dto.message;


public abstract class AbstractMessage implements BaseMessage{
	
	private final MessageRecipient sender;
	private final MessageRecipient recevier;
	private final MessageType type;
	private final MessageBody body;
	
	protected AbstractMessage(MessageRecipient sender,MessageRecipient receiver,MessageBody body,MessageType type){
		this.body=body;
		this.sender=sender;
		this.recevier=receiver;
		this.type=type;
	}
	
	@Override
	public MessageRecipient getSender() {
		return sender;
	}

	@Override
	public MessageRecipient getReceiver() {
		return recevier;
	}

	@Override
	public MessageType getMessageType() {
		return type;
	}

	
	@Override
	public MessageBody getMessageBody() {
		return body;
	}
	
}
