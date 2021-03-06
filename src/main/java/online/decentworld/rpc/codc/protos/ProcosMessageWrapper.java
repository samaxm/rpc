package online.decentworld.rpc.codc.protos;

import com.google.protobuf.ByteString;
import online.decentworld.rpc.dto.message.MessageBody;
import online.decentworld.rpc.dto.message.MessageWrapper;
import online.decentworld.rpc.dto.message.protos.MessageProtos;
import online.decentworld.rpc.dto.message.types.MessageType;

import java.util.Date;

/**
 * Created by Sammax on 2016/9/13.
 */
public abstract class ProcosMessageWrapper implements ProtosMessageConverter {


    @Override
    public MessageWrapper convertFromProtos2Bean(MessageProtos.Message msg) throws Exception {
        MessageWrapper wrapper=new MessageWrapper();
        wrapper.setSender(msg.getFrom());
        wrapper.setReceiver(msg.getTo());
        wrapper.setTime(new Date(msg.getTime()));
        wrapper.setMid(msg.getMid());
        wrapper.setType(MessageType.getMessageType(msg.getType().getNumber()));
        wrapper=warpMessageBody(wrapper,msg.getData());
        return wrapper;
    }


    @Override
    public MessageProtos.Message convertFromBean2Protos(MessageWrapper wrapper) throws Exception {
        ByteString data=encodeMessageBody(wrapper.getBody());
        return MessageProtos.Message.newBuilder().setTo(wrapper.getReceiver()).setFrom(wrapper.getSender())
                .setMid(wrapper.getMid()).setTime(wrapper.getTime().getTime())
                .setType(MessageProtos.Message.MessageType.forNumber(wrapper.getType().getCode())).setData(data).build();
    }

    abstract  protected MessageWrapper warpMessageBody(MessageWrapper wrapper,ByteString bodyData) throws Exception;

    abstract  protected ByteString encodeMessageBody(MessageBody body) throws Exception;
}
