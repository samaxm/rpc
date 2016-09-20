package online.decentworld.rpc.dto.message;

import online.decentworld.rpc.dto.message.types.ChatRelation;
import online.decentworld.rpc.dto.message.types.ChatStatus;
import online.decentworld.rpc.dto.message.types.MessageType;

/**
 * Created by Sammax on 2016/9/18.
 */
final public class WealthAckMessage implements MessageBody{
    private String tempID;
    private long mid;
    private int wealth;

    public boolean isChargeSuccess() {
        return chargeSuccess;
    }

    public void setChargeSuccess(boolean chargeSuccess) {
        this.chargeSuccess = chargeSuccess;
    }

    private boolean chargeSuccess;
    private ChatRelation relation;
    private ChatStatus status;

    public WealthAckMessage(){};

    public WealthAckMessage(String tempID, long mid, int wealth, boolean chargeSuccess, ChatRelation relation, ChatStatus status) {
        this.tempID = tempID;
        this.mid = mid;
        this.wealth = wealth;
        this.chargeSuccess = chargeSuccess;
        this.relation = relation;
        this.status = status;
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

    public int getWealth() {
        return wealth;
    }

    public void setWealth(int wealth) {
        this.wealth = wealth;
    }

    public ChatRelation getRelation() {
        return relation;
    }

    public void setRelation(ChatRelation relation) {
        this.relation = relation;
    }

    public ChatStatus getStatus() {
        return status;
    }

    public void setStatus(ChatStatus status) {
        this.status = status;
    }

    @Override
    public MessageType getType() {
        return MessageType.WEALTH_ACK;
    }
}
