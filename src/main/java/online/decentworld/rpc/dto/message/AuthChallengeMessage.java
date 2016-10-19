package online.decentworld.rpc.dto.message;

import online.decentworld.rpc.dto.message.types.MessageType;

/**
 * Created by Sammax on 2016/10/19.
 */
public class AuthChallengeMessage implements MessageBody {

    private String challengeString;

    public AuthChallengeMessage(String challengeString) {
        this.challengeString = challengeString;
    }

    public String getChallengeString() {
        return challengeString;
    }

    public void setChallengeString(String challengeString) {
        this.challengeString = challengeString;
    }

    @Override
    public MessageType getType() {
        return MessageType.COMMAND_AUTH_CHALLENGE;
    }
}
