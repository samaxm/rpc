package online.decentworld.rpc.codc.protos;

import com.google.protobuf.ByteString;
import online.decentworld.rpc.dto.message.MessageBody;
import online.decentworld.rpc.dto.message.MessageWrapper;
import online.decentworld.rpc.dto.message.protos.MessageProtos;
import online.decentworld.rpc.dto.message.types.MessageType;

/**
 * Created by Sammax on 2016/9/13.
 */
public abstract class ProcosMessageWrapper implements ProtosMessageCodec{


    @Override
    public MessageWrapper parseMessage(MessageProtos.Message msg) throws Exception {
        MessageWrapper wrapper=new MessageWrapper();
        wrapper.setSender(msg.getFrom());
        wrapper.setReceiver(msg.getTo());
        wrapper.setType(MessageType.getMessageType(msg.getType().getNumber()));
        wrapper=warpMessageBody(wrapper,msg.getData());
        return wrapper;
    }


    @Override
    public byte[] encodeMessage(MessageWrapper wrapper) throws Exception {
        ByteString data=encodeMessageBody(wrapper.getBody());
        return MessageProtos.Message.newBuilder().setTo(wrapper.getReceiver()).setFrom(wrapper.getSender())
                .setType(MessageProtos.Message.MessageType.forNumber(wrapper.getType().getCode())).setData(data).build().toByteArray();
    }

    abstract  protected MessageWrapper warpMessageBody(MessageWrapper wrapper,ByteString bodyData) throws Exception;

    abstract  protected ByteString encodeMessageBody(MessageBody body) throws Exception;
}
