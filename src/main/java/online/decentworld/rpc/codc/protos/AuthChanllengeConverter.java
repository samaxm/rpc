package online.decentworld.rpc.codc.protos;

import com.google.protobuf.ByteString;
import online.decentworld.rpc.dto.message.AuthChallengeMessage;
import online.decentworld.rpc.dto.message.MessageBody;
import online.decentworld.rpc.dto.message.protos.MessageProtos;

/**
 * Created by Sammax on 2016/10/19.
 */
public class AuthChanllengeConverter extends ProcosMessageWrapper {
    @Override
    protected MessageBody convert2MessageBody(ByteString bodyData) throws Exception {
        MessageProtos.Command_AuthChallenge authChallenge= MessageProtos.Command_AuthChallenge.parseFrom(bodyData);
        return new AuthChallengeMessage(authChallenge.getChallengeString());
    }

    @Override
    protected ByteString conver2ByteString(MessageBody body) throws Exception {
        AuthChallengeMessage msg=(AuthChallengeMessage)body;
        return MessageProtos.Command_AuthChallenge.newBuilder().setChallengeString(msg.getChallengeString()).build().toByteString();
    }
}
