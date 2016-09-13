package online.decentworld.rpc.dto.message.types;

/**
 * Created by Sammax on 2016/9/13.
 */
public enum ChatStatus {
    FREE(0),NORMAL(1),OVERFLOW(2);
    private int code;
    private ChatStatus(int code){
        this.code=code;
    }
    public int getCode() {
        return code;
    }
    public static ChatStatus getChatStatus(int code){
        for(ChatStatus type: ChatStatus.values()){
            if(type.getCode()==code){
                return type;
            }
        }
        return null;
    }

}
