package online.decentworld.rpc.codc.protos;

import com.google.protobuf.ByteString;
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


    public ProtosBodyConverterFactory getConverterFactory() {
        return converterFactory;
    }

    public void setConverterFactory(ProtosBodyConverterFactory converterFactory) {
        this.converterFactory = converterFactory;
    }

    private ProtosBodyConverterFactory converterFactory;

    @Override
    protected MessageWrapper warpMessageBody(MessageWrapper wrapper, ByteString bodyData) throws Exception {
        MessageContainer container=new MessageContainer();
        MessageProtos.MessageContainer msgs=MessageProtos.MessageContainer.parseFrom(bodyData);
        for(MessageProtos.Message msg:msgs.getMessagesList()){
            ProtosMessageConverter converter=converterFactory.getMessageConverter(MessageType.getMessageType(msg.getType().getNumber()));
            MessageWrapper ele=converter.convertFromProtos2Bean(msg);
            container.addMessage(ele);
        }
        wrapper.setBody(container);
        return wrapper;
    }

    @Override
    protected ByteString encodeMessageBody(MessageBody body) throws Exception {
        MessageContainer container=(MessageContainer)body;
        List<MessageProtos.Message> list=new ArrayList<>(container.getMessages().size());
        for(MessageWrapper message:container.getMessages()){
            ProtosMessageConverter converter=converterFactory.getMessageConverter(message.getType());
            MessageProtos.Message msg=converter.convertFromBean2Protos(message);
            list.add(msg);
        }
        return MessageProtos.MessageContainer.newBuilder().addAllMessages(list).build().toByteString();
    }
}
