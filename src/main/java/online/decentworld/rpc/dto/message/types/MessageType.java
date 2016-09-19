package online.decentworld.rpc.dto.message.types;

/**
 * Created by Sammax on 2016/9/13.
 */
public enum MessageType {
    CHAT(0),LIKE(1),WEALTH_ACK(2);

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
}
