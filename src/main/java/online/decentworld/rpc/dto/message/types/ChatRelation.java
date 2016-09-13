package online.decentworld.rpc.dto.message.types;

/**
 * Created by Sammax on 2016/9/13.
 */
public enum ChatRelation {
    STRANGER(0),FRIEND(1);
    private int code;
    private ChatRelation(int code){
        this.code=code;
    }
    public int getCode() {
        return code;
    }
    public static ChatRelation getChatRelation(int code){
        for(ChatRelation type: ChatRelation.values()){
            if(type.getCode()==code){
                return type;
            }
        }
        return null;
    }

}
