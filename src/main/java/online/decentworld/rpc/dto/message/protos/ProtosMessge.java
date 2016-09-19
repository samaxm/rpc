package online.decentworld.rpc.dto.message.protos;

import com.google.protobuf.ByteString;

public interface ProtosMessge {
	
	ByteString encode();

	public static void main(String[] args) {
		MessageProtos.TextChatMessageInfo info=MessageProtos.TextChatMessageInfo.newBuilder().build();

	}
}
