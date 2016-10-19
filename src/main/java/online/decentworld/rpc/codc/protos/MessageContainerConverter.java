package online.decentworld.rpc.codc.protos;

import com.google.protobuf.ByteString;
import online.decentworld.rpc.codc.MessageConverter;
import online.decentworld.rpc.codc.MessageConverterFactory;
import online.decentworld.rpc.dto.message.MessageBody;
import online.decentworld.rpc.dto.message.MessageContainer;
import online.decentworld.rpc.dto.message.MessageWrapper;
import online.decentworld.rpc.dto.message.protos.MessageProtos;
import online.decentworld.rpc.dto.message.types.MessageType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sammax on 2016/9/20.
 */
public class MessageContainerConverter extends ProcosMessageWrapper {


    private MessageConverterFactory converterFactory;
    public void setConverterFactory(MessageConverterFactory converterFactory) {
        this.converterFactory = converterFactory;
    }

    @Override
    protected MessageBody convert2MessageBody(ByteString bodyData) throws Exception {
        MessageContainer container=new MessageContainer();
        MessageProtos.MessageContainer msgs=MessageProtos.MessageContainer.parseFrom(bodyData);
        for(MessageProtos.Message msg:msgs.getMessagesList()){
            MessageConverter converter=converterFactory.getMessageConverter(MessageType.getMessageType(msg.getType().getNumber()));
            MessageWrapper ele=converter.fromStream2Bean(msg);
            container.addMessage(ele);
        }
        return container;
    }

    @Override
    protected ByteString conver2ByteString(MessageBody body) throws Exception {
        MessageContainer container=(MessageContainer)body;
        List<MessageProtos.Message> list=new ArrayList<>(container.getMessages().size());
        for(MessageWrapper message:container.getMessages()){
            MessageConverter converter=converterFactory.getMessageConverter(message.getType());
            MessageProtos.Message msg=MessageProtos.Message.parseFrom(converter.fromBean2Stream(message));
            list.add(msg);
        }
        return MessageProtos.MessageContainer.newBuilder().addAllMessages(list).build().toByteString();
    }
}
