package online.decentworld.rpc.codc.protos;

import com.google.protobuf.ByteString;
import online.decentworld.rpc.codc.MessageConverter;
import online.decentworld.rpc.dto.message.MessageBody;
import online.decentworld.rpc.dto.message.MessageWrapper;
import online.decentworld.rpc.dto.message.protos.MessageProtos;
import online.decentworld.rpc.dto.message.types.MessageType;

import java.util.Date;

/**
 * Created by Sammax on 2016/9/13.
 */
public abstract class ProcosMessageWrapper implements MessageConverter {

    @Override
    public MessageWrapper fromStream2Bean(MessageProtos.Message msg) throws Exception {
        MessageWrapper wrapper=new MessageWrapper();
        wrapper.setTime(new Date(msg.getTime()));
        wrapper.setMid(msg.getMid());
        wrapper.setType(MessageType.getMessageType(msg.getType().getNumber()));
        wrapper.setBody(convert2MessageBody(msg.getData()));
        return wrapper;
    }


    @Override
    public byte[] fromBean2Stream(MessageWrapper wrapper) throws Exception {
        ByteString data=conver2ByteString(wrapper.getBody());
        return MessageProtos.Message.newBuilder()
                .setMid(wrapper.getMid()).setTime(wrapper.getTime().getTime())
                .setType(MessageProtos.Message.MessageType.forNumber(wrapper.getType().getCode())).setData(data).build().toByteArray();
    }

    abstract  protected MessageBody convert2MessageBody(ByteString bodyData) throws Exception;

    abstract  protected ByteString conver2ByteString(MessageBody body) throws Exception;

}
