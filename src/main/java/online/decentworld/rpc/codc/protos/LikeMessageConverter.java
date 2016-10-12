package online.decentworld.rpc.codc.protos;

import com.google.protobuf.ByteString;
import online.decentworld.rpc.dto.message.LikeMessageBody;
import online.decentworld.rpc.dto.message.MessageBody;
import online.decentworld.rpc.dto.message.MessageWrapper;
import online.decentworld.rpc.dto.message.protos.MessageProtos.VedioLikeMessageInfo;

public class LikeMessageConverter extends ProcosMessageWrapper{

	
	
	@Override
	public MessageWrapper warpMessageBody(MessageWrapper wrapper,ByteString bodyData) throws Exception {
		VedioLikeMessageInfo info=VedioLikeMessageInfo.parseFrom(bodyData);
		LikeMessageBody likeMessageBody=new LikeMessageBody(info.getIcon(),info.getName(),info.getLikeID(),info.getBelikeID(),info.getSex());
		wrapper.setBody(likeMessageBody);
		return wrapper;
	}

	@Override
	protected ByteString encodeMessageBody(MessageBody body) throws Exception {
		LikeMessageBody likebody=(LikeMessageBody)body;
		return VedioLikeMessageInfo.newBuilder().setBelikeID(likebody.getBeLikedID()).setIcon(likebody.getIcon())
				.setLikeID(likebody.getLikeID()).setName(likebody.getName()).setSex(likebody.getSex())
				.build().toByteString();
	}
}
