package online.decentworld.rpc.codc;

import com.google.protobuf.InvalidProtocolBufferException;
import online.decentworld.rpc.dto.message.protos.MessageProtos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sammax on 2016/9/20.
 */
public class CodecHelper {

    private static Logger logger= LoggerFactory.getLogger(CodecHelper.class);

    public static byte[] toByteArray(List<byte[]> data,String from,String to){

        long maxMid=0;
        List<MessageProtos.Message> list=new ArrayList<>(data.size());
        for(byte[] msg:data){
            try {
                MessageProtos.Message m=MessageProtos.Message.parseFrom(msg);
                if(m.getMid()>=maxMid){
                    maxMid=m.getMid();
                }
                list.add(m);
            } catch (InvalidProtocolBufferException e) {
                logger.warn("", e);
            }
        }
        MessageProtos.MessageContainer container= MessageProtos.MessageContainer.newBuilder().addAllMessages(list).build();
        return MessageProtos.Message.newBuilder().setData(container.toByteString())
                .setFrom(from).setTo(to).setType(MessageProtos.Message.MessageType.LIST)
                .setMid(maxMid).setTime(System.currentTimeMillis())
                .build().toByteArray();
    }

    public static MessageProtos.MessageContainer putInContainer(List<byte[]> data){
        long maxMid=0;
        List<MessageProtos.Message> list=new ArrayList<>(data.size());
        for(byte[] msg:data){
            try {
                MessageProtos.Message m=MessageProtos.Message.parseFrom(msg);
                if(m.getMid()>=maxMid){
                    maxMid=m.getMid();
                }
                list.add(m);
            } catch (InvalidProtocolBufferException e) {
                logger.warn("", e);
            }
        }
        return MessageProtos.MessageContainer.newBuilder().addAllMessages(list).build();
    }
}
