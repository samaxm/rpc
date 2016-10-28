package online.decentworld.rpc.dto.message;

import online.decentworld.rpc.dto.message.types.MessageType;

/**
 * Created by Sammax on 2016/10/28.
 */
public class Notic_RechargeMessageBody implements MessageBody  {
    private String dwID;
    private long time;
    private int amount;


    public Notic_RechargeMessageBody(String dwID,  int amount) {
        this.dwID = dwID;
        this.time = System.currentTimeMillis();
        this.amount = amount;
    }
    public Notic_RechargeMessageBody(String dwID,long time,  int amount) {
        this.dwID = dwID;
        this.time = time;
        this.amount = amount;
    }
    public String getDwID() {
        return dwID;
    }

    public void setDwID(String dwID) {
        this.dwID = dwID;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public MessageType getType() {
        return MessageType.NOTICE_RECHARGE;
    }



}
