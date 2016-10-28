package online.decentworld.rpc.codc.protos;

import com.google.protobuf.ByteString;
import online.decentworld.rpc.dto.message.MessageBody;
import online.decentworld.rpc.dto.message.TextChatMessage;
import online.decentworld.rpc.dto.message.protos.MessageProtos;
import online.decentworld.rpc.dto.message.types.ChatRelation;
import online.decentworld.rpc.dto.message.types.ChatStatus;

/**
 * Created by Sammax on 2016/9/14.
 */
public class TextChatMessageConverter extends ProcosMessageWrapper {


    @Override
    protected MessageBody convert2MessageBody(ByteString bodyData) throws Exception {
        MessageProtos.TextChatMessage cm= MessageProtos.TextChatMessage.parseFrom(bodyData);
        return new TextChatMessage(ChatStatus.getChatStatus(cm.getStatus().getNumber()),cm.getReceiverWealth(),cm.getTempID(),ChatRelation.getChatRelation(cm.getRelationType().getNumber())
                ,cm.getFromID(),cm.getToID(),cm.getText());
    }
    @Override
    protected ByteString conver2ByteString(MessageBody body) throws Exception {
        TextChatMessage cm=(TextChatMessage)body;
        return MessageProtos.TextChatMessage.newBuilder()
                .setReceiverWealth(cm.getReceiverWealth()).setRelationType(MessageProtos.FriendType.forNumber(cm.getRelation().getCode()))
                .setStatus(MessageProtos.ChargeStatus.forNumber(cm.getStatus().getCode())).setTempID(cm.getTempID())
                .setFromID(cm.getFromID()).setToID(cm.getToID()).setText(cm.getText())
                .build().toByteString();
    }
}
