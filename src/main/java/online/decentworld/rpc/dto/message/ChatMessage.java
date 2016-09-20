package online.decentworld.rpc.dto.message;

import online.decentworld.rpc.dto.message.types.ChatMessageType;
import online.decentworld.rpc.dto.message.types.ChatRelation;
import online.decentworld.rpc.dto.message.types.ChatStatus;
import online.decentworld.rpc.dto.message.types.MessageType;

/**
 * Created by Sammax on 2016/9/13.
 */
public class ChatMessage implements MessageBody {

    private ChatStatus status;
    private String receiverWealth;
    private String tempID ;
    private long mid;
    private long time;
    private ChatRelation relation;
    private ChatMessageType chatType;
    private String fromID;

    public String getFromID() {
        return fromID;
    }

    public void setFromID(String fromID) {
        this.fromID = fromID;
    }

    public String getToID() {
        return toID;
    }

    public void setToID(String toID) {
        this.toID = toID;
    }

    private String toID;

    public ChatMessage(){};

    public ChatMessage(ChatStatus status, String receiverWealth, String tempID, long mid,long time, ChatRelation relation, ChatMessageType type, String fromID, String toID) {
        this.status = status;
        this.receiverWealth = receiverWealth;
        this.tempID = tempID;
        this.mid = mid;
        this.time = time;
        this.relation = relation;
        this.chatType = type;
        this.fromID = fromID;
        this.toID = toID;
    }

    public void setSendDefault(){
        this.receiverWealth="";
        this.relation=ChatRelation.STRANGER;
        this.status=ChatStatus.FREE;
        this.tempID=randomToken();
    }


    private static String randomToken(){
        String retStr = "";
        String strTable = "1234567890ABCDEFGHIJKLMNPQRSTUVWXYZ";
        int len = strTable.length();
        boolean bDone = true;
        do {
            retStr = "";
            int count = 0;
            for (int i = 0; i < 16; i++) {
                double dblR = Math.random() * len;
                int intR = (int) Math.floor(dblR);
                char c = strTable.charAt(intR);
                if (('0' <= c) && (c <= '9')) {
                    count++;
                }
                retStr += strTable.charAt(intR);
            }
            if (count >= 2) {
                bDone = false;
            }
        } while (bDone);

        return retStr;
    }

    public ChatStatus getStatus() {
        return status;
    }

    public void setStatus(ChatStatus status) {
        this.status = status;
    }

    public String getReceiverWealth() {
        return receiverWealth;
    }

    public void setReceiverWealth(String receiverWealth) {
        this.receiverWealth = receiverWealth;
    }

    public String getTempID() {
        return tempID;
    }

    public void setTempID(String tempID) {
        this.tempID = tempID;
    }

    public long getMid() {
        return mid;
    }

    public void setMid(long mid) {
        this.mid = mid;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public ChatRelation getRelation() {
        return relation;
    }

    public void setRelation(ChatRelation relation) {
        this.relation = relation;
    }

    public ChatMessageType getChatType() {
        return chatType;
    }

    public void setChatType(ChatMessageType chatType) {
        this.chatType = chatType;
    }
    @Override
    public MessageType getType() {
        return MessageType.CHAT;
    }

}