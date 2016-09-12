package online.decentworld.rpc.dto.message.protos;

import online.decentworld.rpc.dto.message.AbstractMessage;
import online.decentworld.rpc.dto.message.MessageBody;
import online.decentworld.rpc.dto.message.MessageRecipient;
import online.decentworld.rpc.dto.message.MessageType;
import online.decentworld.rpc.dto.message.SimpleMessageRecipient;
import online.decentworld.rpc.dto.message.VedioLikeMessageBody;
import online.decentworld.rpc.dto.message.protos.MessageProtos.Message;

import com.google.protobuf.ByteString;

public class ProtosVedioLikeMessage extends AbstractMessage implements ProtosMessge{

	protected ProtosVedioLikeMessage(MessageRecipient sender,
			MessageRecipient receiver, MessageBody body, MessageType type) {
		super(sender, receiver, body, type);
	}

	
	public static ProtosVedioLikeMessage create(ProtosVedioLikeMessageBody body){
		return new ProtosVedioLikeMessage(
				new SimpleMessageRecipient(body.getLikeID()),
				new SimpleMessageRecipient(body.getBeLikedID()),
				body,MessageType.VEDIO_LIKE
				);
	}

	public static ProtosVedioLikeMessage create(VedioLikeMessageBody body){
		return ProtosVedioLikeMessage.create(new ProtosVedioLikeMessageBody(body));
	}
	
	
	@Override
	public ByteString encode() {
		return Message.newBuilder().setFrom(getSender().stringValue()).setTo(getReceiver().stringValue())
				.setType(getMessageType().getCode()).setData(((ProtosMessge)getMessageBody()).encode()).build().toByteString();
	}
	
	@Override
	public byte[] getWriteByte() {
		return Message.newBuilder().setFrom(getSender().stringValue()).setTo(getReceiver().stringValue())
		.setType(getMessageType().getCode()).setData(((ProtosMessge)getMessageBody()).encode()).build().toByteArray();
	}
}
