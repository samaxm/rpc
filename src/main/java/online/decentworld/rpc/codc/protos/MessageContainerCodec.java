package online.decentworld.rpc.codc.protos;

import com.google.protobuf.ByteString;
import online.decentworld.rpc.codc.Codec;
import online.decentworld.rpc.dto.message.MessageBody;
import online.decentworld.rpc.dto.message.MessageWrapper;

/**
 * Created by Sammax on 2016/9/20.
 */
public class MessageContainerCodec extends ProcosMessageWrapper {


    private Codec codec;

    @Override
    protected MessageWrapper warpMessageBody(MessageWrapper wrapper, ByteString bodyData) throws Exception {

        return null;
    }

    @Override
    protected ByteString encodeMessageBody(MessageBody body) throws Exception {
        return null;
    }
}
