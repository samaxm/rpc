package online.decentworld.rpc.dto.message;

import online.decentworld.rpc.dto.message.types.ChatMessageType;
import online.decentworld.rpc.dto.message.types.ChatRelation;
import online.decentworld.rpc.dto.message.types.ChatStatus;
import online.decentworld.rpc.dto.message.types.ChatrDirect;

/**
 * Created by Sammax on 2016/9/13.
 */
public class ChatMessage implements MessageBody {

    private ChatStatus status;
    private String receiverWealth;
    private String tempID ;
    private long mid;
    private ChatrDirect direct;
    private long time;
    private ChatRelation relation;
    private ChatMessageType type;

    public ChatMessage(){};

    public ChatMessage(ChatStatus status, String receiverWealth, String tempID, long mid, ChatrDirect direct, long time, ChatRelation relation, ChatMessageType type) {
        this.status = status;
        this.receiverWealth = receiverWealth;
        this.tempID = tempID;
        this.mid = mid;
        this.direct = direct;
        this.time = time;
        this.relation = relation;
        this.type = type;
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

    public ChatrDirect getDirect() {
        return direct;
    }

    public void setDirect(ChatrDirect direct) {
        this.direct = direct;
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

    public ChatMessageType getType() {
        return type;
    }

    public void setType(ChatMessageType type) {
        this.type = type;
    }
}