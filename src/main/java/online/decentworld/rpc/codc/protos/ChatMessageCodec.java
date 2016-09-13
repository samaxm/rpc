package online.decentworld.rpc.codc.protos;

import com.google.protobuf.ByteString;
import online.decentworld.rpc.dto.message.*;
import online.decentworld.rpc.dto.message.protos.MessageProtos;
import online.decentworld.rpc.dto.message.types.ChatMessageType;
import online.decentworld.rpc.dto.message.types.ChatRelation;
import online.decentworld.rpc.dto.message.types.ChatStatus;
import online.decentworld.rpc.dto.message.types.ChatrDirect;

/**
 * Created by Sammax on 2016/9/14.
 */
public class ChatMessageCodec extends ProcosMessageWrapper {



    @Override
    protected MessageWrapper warpMessageBody(MessageWrapper wrapper, MessageProtos.Message msg) throws Exception {
        MessageProtos.ChatMessage cm= MessageProtos.ChatMessage.parseFrom(msg.getData());
        MessageProtos.ChatMessage.ChatMessageType type=cm.getMessageType();
        ChatMessage chatMessage=null;
        switch (type){
            case TEXT:
                MessageProtos.TextChatMessageInfo text=MessageProtos.TextChatMessageInfo.parseFrom(cm.getContent());
                chatMessage=new TextChatMessage(ChatStatus.getChatStatus(cm.getStatus().getNumber()),cm.getReceiverWealth(),cm.getTempID(),cm.getMid(), ChatrDirect.getChatrDirect(cm.getDirect()),cm.getTime(), ChatRelation.getChatRelation(cm.getRelationType().getNumber())
                    , ChatMessageType.getChatMessageType(cm.getMessageType().getNumber()),text.getText());
                break;
            case AUDIO:
                MessageProtos.AudioChatMessageInfo audio=MessageProtos.AudioChatMessageInfo.parseFrom(cm.getContent());
                chatMessage=new AudioChatMessage(ChatStatus.getChatStatus(cm.getStatus().getNumber()),cm.getReceiverWealth(),cm.getTempID(),cm.getMid(), ChatrDirect.getChatrDirect(cm.getDirect()),cm.getTime(), ChatRelation.getChatRelation(cm.getRelationType().getNumber())
                        , ChatMessageType.getChatMessageType(cm.getMessageType().getNumber()),audio.getLength(),audio.getUrl());
                break;
            case IMAGE:
                MessageProtos.ImageChatMessageInfo image=MessageProtos.ImageChatMessageInfo.parseFrom(cm.getContent());
                chatMessage=new ImageChatMessage(ChatStatus.getChatStatus(cm.getStatus().getNumber()),cm.getReceiverWealth(),cm.getTempID(),cm.getMid(), ChatrDirect.getChatrDirect(cm.getDirect()),cm.getTime(), ChatRelation.getChatRelation(cm.getRelationType().getNumber())
                        , ChatMessageType.getChatMessageType(cm.getMessageType().getNumber()),image.getCompress().toByteArray(),image.getUrl());
                break;

        }
        wrapper.setBody(chatMessage);
        return wrapper;
    }

    @Override
    protected ByteString encodeMessageBody(MessageBody body) throws Exception {
        ChatMessage cm=(ChatMessage)body;
        ChatMessageType type=cm.getType();
        ByteString info=null;
        switch (type){
            case TXT:
                info=MessageProtos.TextChatMessageInfo.newBuilder().setText(((TextChatMessage)body).getText()).build().toByteString();
                break;
            case AUDIO:
                info= MessageProtos.AudioChatMessageInfo.newBuilder().setLength(((AudioChatMessage)body).getLength())
                        .setUrl(((AudioChatMessage)body).getUrl()).build().toByteString();
                break;
            case IMAGE:
                info=MessageProtos.ImageChatMessageInfo.newBuilder().setCompress(ByteString.copyFrom(((ImageChatMessage) body).getCompress())).setUrl(((ImageChatMessage) body).getUrl())
                        .build().toByteString();
                break;
        }
        return MessageProtos.ChatMessage.newBuilder().setTime(cm.getTime()).setContent(info).setDirect(cm.getDirect().getCode())
                .setMessageType(MessageProtos.ChatMessage.ChatMessageType.forNumber(cm.getType().getCode())).setMid(cm.getMid())
                .setReceiverWealth(cm.getReceiverWealth()).setRelationType(MessageProtos.ChatMessage.FriendType.forNumber(cm.getRelation().getCode()))
                .setStatus(MessageProtos.ChatMessage.ChargeStatus.forNumber(cm.getStatus().getCode())).setTempID(cm.getTempID())
                .build().toByteString();

    }


}
