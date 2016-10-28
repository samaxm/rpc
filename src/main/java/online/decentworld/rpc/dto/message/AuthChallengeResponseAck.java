package online.decentworld.rpc.dto.message;

import online.decentworld.rpc.dto.message.types.MessageType;

/**
 * Created by Sammax on 2016/10/22.
 */
public class AuthChallengeResponseAck implements MessageBody {


    @Override
    public MessageType getType() {
        return MessageType.COMMAND_AUTH_CHALLENGE_RESPONSE_ACK;
    }
}
