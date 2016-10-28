package online.decentworld.rpc.dto.message;

import online.decentworld.rpc.dto.message.types.MessageType;

import java.util.Date;

public class MessageWrapper {

	private String receiverID;

	private String senderID;

	private MessageType type;

	private MessageBody body;

	private Date time;

	private long mid;

	public MessageWrapper(String from,String to, MessageType type, MessageBody body, Date time, long mid) {
		this.type = type;
		this.body = body;
		this.time = time;
		this.mid = mid;
		this.setSenderID(from);
		this.setReceiverID(to);
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

	public String getReceiverID() {
		return receiverID;
	}

	public void setReceiverID(String receiverID) {
		this.receiverID = receiverID;
	}

	public String getSenderID() {
		return senderID;
	}

	public void setSenderID(String senderID) {
		this.senderID = senderID;
	}

	public static MessageWrapper createMessageWrapper(String from,String to,MessageBody msg,long mid){
		return new MessageWrapper(from,to,msg.getType(),msg,new Date(),0);
	}

	public static MessageWrapper createSimpleCommand(MessageBody command){
		return new MessageWrapper("","",command.getType(),command,new Date(),0);
	}

	public static MessageWrapper createCommand(MessageType command){
		return new MessageWrapper("","",command,null,new Date(),0);
	}
}
