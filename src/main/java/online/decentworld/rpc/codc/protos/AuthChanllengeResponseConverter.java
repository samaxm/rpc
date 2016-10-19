package online.decentworld.rpc.codc.protos;

import com.google.protobuf.ByteString;
import online.decentworld.rpc.dto.message.AuthChallengeMessage;
import online.decentworld.rpc.dto.message.AuthChallengeResponseMessage;
import online.decentworld.rpc.dto.message.MessageBody;
import online.decentworld.rpc.dto.message.protos.MessageProtos;

/**
 * Created by Sammax on 2016/10/19.
 */
public class AuthChanllengeResponseConverter extends ProcosMessageWrapper {
    @Override
    protected MessageBody convert2MessageBody(ByteString bodyData) throws Exception {
        MessageProtos.Command_AuthChallengeResponse authChallengeResponse= MessageProtos.Command_AuthChallengeResponse.parseFrom(bodyData);
        return new AuthChallengeMessage(authChallengeResponse.getResponse());
    }

    @Override
    protected ByteString conver2ByteString(MessageBody body) throws Exception {
        AuthChallengeResponseMessage msg=(AuthChallengeResponseMessage)body;
        return MessageProtos.Command_AuthChallengeResponse.newBuilder().setResponse(msg.getResponse()).build().toByteString();
    }
}
