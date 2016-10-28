package online.decentworld.rpc.codc.protos;

import com.google.protobuf.ByteString;
import online.decentworld.rpc.dto.message.MessageBody;

/**
 * Created by Sammax on 2016/10/22.
 */
public class EmptyBodyMessageConverter extends ProcosMessageWrapper {


    @Override
    protected MessageBody convert2MessageBody(ByteString bodyData) throws Exception {
        return null;
    }

    @Override
    protected ByteString conver2ByteString(MessageBody body) throws Exception {
        return null;
    }
}
