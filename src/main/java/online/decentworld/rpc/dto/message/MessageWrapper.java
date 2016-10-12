package online.decentworld.rpc.dto.message;

import online.decentworld.rpc.dto.message.types.MessageType;

import java.util.Date;

public class MessageWrapper {

	private String sender;

	private String receiver;

	private MessageType type;

	private MessageBody body;

	private Date time;

	private long mid;

	public MessageWrapper(String sender, String receiver, MessageType type, MessageBody body, Date time, long mid) {
		this.sender = sender;
		this.receiver = receiver;
		this.type = type;
		this.body = body;
		this.time = time;
		this.mid = mid;
	}


	public MessageWrapper(){}


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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public long getMid() {
		return mid;
	}

	public void setMid(long mid) {
		this.mid = mid;
	}
}
