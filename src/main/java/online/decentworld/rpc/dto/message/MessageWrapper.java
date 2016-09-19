package online.decentworld.rpc.dto.message;

import online.decentworld.rpc.dto.message.types.MessageType;

public class MessageWrapper {

	private String sender;

	private String receiver;

	private MessageType type;

	private MessageBody body;

	public MessageWrapper(String sender, String receiver, MessageType type, MessageBody body) {
		this.sender = sender;
		this.receiver = receiver;
		this.type = type;
		this.body = body;
	}

	public static MessageWrapper  wrapChatMessage(ChatMessage msg){
		return new MessageWrapper(msg.getFromID(),msg.getToID(),MessageType.CHAT,msg);
	}

	public MessageWrapper() {

	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public MessageBody getBody() {
		return body;
	}

	public void setBody(MessageBody body) {
		this.body = body;
	}
}
