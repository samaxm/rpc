package online.decentworld.rpc.codc.protos;

import com.google.protobuf.ByteString;
import online.decentworld.rpc.dto.message.ImageChatMessage;
import online.decentworld.rpc.dto.message.MessageBody;
import online.decentworld.rpc.dto.message.protos.MessageProtos;
import online.decentworld.rpc.dto.message.types.ChatRelation;
import online.decentworld.rpc.dto.message.types.ChatStatus;

/**
 * Created by Sammax on 2016/10/19.
 */
public class ImageChatMessageConverter extends ProcosMessageWrapper {
    @Override
    protected MessageBody convert2MessageBody(ByteString bodyData) throws Exception {
        MessageProtos.ImageChatMessage cm= MessageProtos.ImageChatMessage.parseFrom(bodyData);
        return new ImageChatMessage(ChatStatus.getChatStatus(cm.getStatus().getNumber()),cm.getReceiverWealth(),cm.getTempID(), ChatRelation.getChatRelation(cm.getRelationType().getNumber())
                ,cm.getFromID(),cm.getToID(),cm.getCompress().toByteArray(),cm.getUrl());
    }

    @Override
    protected ByteString conver2ByteString(MessageBody body) throws Exception {
        ImageChatMessage cm=(ImageChatMessage)body;
        return MessageProtos.ImageChatMessage.newBuilder()
                .setReceiverWealth(cm.getReceiverWealth()).setRelationType(MessageProtos.FriendType.forNumber(cm.getRelation().getCode()))
                .setStatus(MessageProtos.ChargeStatus.forNumber(cm.getStatus().getCode())).setTempID(cm.getTempID())
                .setFromID(cm.getFromID()).setToID(cm.getToID()).setUrl(cm.getUrl()).setCompress(ByteString.copyFrom(cm.getCompress()))
                .build().toByteString();
    }
}
