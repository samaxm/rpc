package online.decentworld.rpc.dto.message;

import online.decentworld.rpc.dto.message.types.MessageType;

import java.util.Date;

/**
 * Created by Sammax on 2016/11/16.
 */
public class Notice_TipMessageBody implements MessageBody{
    private UserInfo info;
    private int amount;
    private Date time;

    public Notice_TipMessageBody() {}

    public Notice_TipMessageBody(UserInfo info, int amount, Date time) {
        this.info = info;
        this.amount = amount;
        this.time = time;
    }

    public UserInfo getInfo() {
        return info;
    }

    public void setInfo(UserInfo info) {
        this.info = info;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public MessageType getType() {
        return MessageType.NOTICE_TIP;
    }
}
