package online.decentworld.rpc.dto.message.protos;

import com.google.protobuf.ByteString;
import online.decentworld.rpc.dto.message.MessageBody;
import online.decentworld.rpc.dto.message.MessageRecipient;
import online.decentworld.rpc.dto.message.ChatMessageType;
import online.decentworld.rpc.dto.message.LikeMessageBody;
import online.decentworld.rpc.dto.message.protos.MessageProtos.Message;

public class ProtosVedioLikeMessage  implements ProtosMessge{

	protected ProtosVedioLikeMessage(MessageRecipient sender,
			MessageRecipient receiver, MessageBody body, ChatMessageType type) {
		super(sender, receiver, body, type);
	}

	
	public static ProtosVedioLikeMessage create(ProtosVedioLikeMessageBody body){
		return new ProtosVedioLikeMessage(
				new SimpleMessageRecipient(body.getLikeID()),
				new SimpleMessageRecipient(body.getBeLikedID()),
				body, ChatMessageType.VEDIO_LIKE
				);
	}

	public static ProtosVedioLikeMessage create(LikeMessageBody body){
		return ProtosVedioLikeMessage.create(new ProtosVedioLikeMessageBody(body));
	}
	
	
	@Override
	public ByteString encode() {
		return Message.newBuilder().setFrom(getSender().stringValue()).setTo(getReceiver().stringValue())
				.setType(Message.MessageType.forNumber(getMessageType().getCode())).setData(((ProtosMessge)getMessageBody()).encode()).build().toByteString();
	}
	
	@Override
	public byte[] getWriteByte() {
		return Message.newBuilder().setFrom(getSender().stringValue()).setTo(getReceiver().stringValue())
		.setType(Message.MessageType.forNumber(getMessageType().getCode())).setData(((ProtosMessge) getMessageBody()).encode()).build().toByteArray();
	}
}
