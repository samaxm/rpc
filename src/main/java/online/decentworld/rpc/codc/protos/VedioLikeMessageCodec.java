package online.decentworld.rpc.codc.protos;

import online.decentworld.rpc.dto.message.BaseMessage;
import online.decentworld.rpc.dto.message.protos.MessageProtos.Message;
import online.decentworld.rpc.dto.message.protos.MessageProtos.VedioLikeMessageInfo;
import online.decentworld.rpc.dto.message.protos.ProtosVedioLikeMessage;
import online.decentworld.rpc.dto.message.protos.ProtosVedioLikeMessageBody;

public class VedioLikeMessageCodec implements ProtosMessageCodec{

	
	
	@Override
	public BaseMessage parseMessage(Message data) throws Exception {
		return ProtosVedioLikeMessage.create(new ProtosVedioLikeMessageBody(VedioLikeMessageInfo.parseFrom(data.getData())));
	}

	

}
