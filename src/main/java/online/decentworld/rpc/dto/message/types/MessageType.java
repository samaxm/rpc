package online.decentworld.rpc.dto.message.types;

/**
 * Created by Sammax on 2016/9/13.
 */
public enum MessageType {
    CHAT_TEXT(0),CHAT_AUDIO(1),CHAT_IMAGE(2),LIST(3)
    ,COMMAND_WEALTH_ACK(10),COMMAND_MSG_SYNC_NOTIFY(11),COMMAND_MSG_SYNC_REQUEST(12),COMMAND_MSG_SYNC_FIN(13),COMMAND_AUTH_CHALLENGE(14),COMMAND_AUTH_CHALLENGE_RESPONSE(15),COMMAND_AUTH_CHALLENGE_RESPONSE_ACK(16),COMMAND_PING(17)
    ,NOTICE_LIKE(100),NOTICE_RECHARGE(101),NOTICE_TIP(102),NOTICE_LIKE_RESPONSE(103),NOTICE_VIP_REGISTER(104),NOTICE_VIP_RENEW(105);

    private int code;

    private MessageType(int code){
        this.code=code;
    }

    public int getCode() {
        return code;
    }

    public static MessageType getMessageType(int code){
        for(MessageType type: MessageType.values()){
            if(type.getCode()==code){
                return type;
            }
        }
        return null;
    }

    public static boolean isChatMessage(MessageType type){
        if(type==CHAT_TEXT||type==CHAT_AUDIO||type==CHAT_AUDIO){
            return true;
        }else{
            return false;
        }
    }
}
