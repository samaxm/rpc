package online.decentworld.rpc.dto.message.types;

/**
 * Created by Sammax on 2016/9/13.
 */
public enum ChatrDirect {
    FROM(0),TO(1);
    private int code;
    private ChatrDirect(int code){
        this.code=code;
    }
    public int getCode() {
        return code;
    }
    public static ChatrDirect getChatrDirect(int code){
        for(ChatrDirect type: ChatrDirect.values()){
            if(type.getCode()==code){
                return type;
            }
        }
        return null;
    }

}
