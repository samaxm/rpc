package online.decentworld.rpc.codc.protos;

import com.google.protobuf.ByteString;
import online.decentworld.rpc.dto.message.Notice_LikeMessageBody;
import online.decentworld.rpc.dto.message.MessageBody;
import online.decentworld.rpc.dto.message.protos.MessageProtos;

public class LikeMessageConverter extends ProcosMessageWrapper{

	@Override
	protected MessageBody convert2MessageBody(ByteString bodyData) throws Exception {
		MessageProtos.Notice_Like info=MessageProtos.Notice_Like.parseFrom(bodyData);
		return new Notice_LikeMessageBody(info.getIcon(),info.getName(),info.getLikeID(),info.getBelikeID(),info.getSex());
	}

	@Override
	protected ByteString conver2ByteString(MessageBody body) throws Exception {
		Notice_LikeMessageBody likebody=(Notice_LikeMessageBody)body;
		return MessageProtos.Notice_Like.newBuilder().setBelikeID(likebody.getBeLikedID()).setIcon(likebody.getIcon())
				.setLikeID(likebody.getLikeID()).setName(likebody.getName()).setSex(likebody.getSex())
				.build().toByteString();
	}
}
