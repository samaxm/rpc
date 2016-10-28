package online.decentworld.rpc.dto.message;

import online.decentworld.rpc.dto.message.types.MessageType;

/**
 * Created by Sammax on 2016/10/19.
 */
public class AuthChallengeResponseMessage implements MessageBody {

    private String response;
    private String dwID;

    public AuthChallengeResponseMessage(String dwID,String response) {
        this.response = response;
        this.dwID=dwID;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public MessageType getType() {
        return MessageType.COMMAND_AUTH_CHALLENGE_RESPONSE;
    }

    public String getDwID() {
        return dwID;
    }

    public void setDwID(String dwID) {
        this.dwID = dwID;
    }
}
