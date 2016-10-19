package online.decentworld.rpc.dto.message;

import online.decentworld.rpc.dto.message.types.MessageType;

import java.util.Date;

public class MessageWrapper {

	private MessageType type;

	private MessageBody body;

	private Date time;

	private long mid;

	public MessageWrapper( MessageType type, MessageBody body, Date time, long mid) {
		this.type = type;
		this.body = body;
		this.time = time;
		this.mid = mid;
	}


	public MessageWrapper(){}

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
