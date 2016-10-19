package online.decentworld.rpc.codc.protos;

import com.google.protobuf.ByteString;
import online.decentworld.rpc.dto.message.MessageBody;
import online.decentworld.rpc.dto.message.SyncRequestMessage;
import online.decentworld.rpc.dto.message.protos.MessageProtos;

/**
 * Created by Sammax on 2016/10/19.
 */
public class SyncRequestMessageConverter extends ProcosMessageWrapper {


    @Override
    protected MessageBody convert2MessageBody(ByteString bodyData) throws Exception {
        MessageProtos.Command_SyncRequest request= MessageProtos.Command_SyncRequest.parseFrom(bodyData);
        return new SyncRequestMessage(request.getSyncNum());
    }

    @Override
    protected ByteString conver2ByteString(MessageBody body) throws Exception {
        SyncRequestMessage msg=(SyncRequestMessage)body;
        return MessageProtos.Command_SyncRequest.newBuilder().setSyncNum(msg.getSyncNum()).build().toByteString();
    }


}
