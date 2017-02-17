package online.decentworld.rpc.dto.message;

import online.decentworld.rpc.dto.message.types.MessageType;

import java.util.Date;

/**
 * Created by Sammax on 2016/12/1.
 */
public class Notice_VipRenewMessageBody implements MessageBody {
    private String dwID;
    private Date time;
    private Date expire;
    private Integer amount;

    public Notice_VipRenewMessageBody(String dwID, Date time, Date expire, Integer amount) {
        this.dwID = dwID;
        this.time = time;
        this.expire = expire;
        this.amount = amount;
    }

    public String getDwID() {
        return dwID;
    }

    public void setDwID(String dwID) {
        this.dwID = dwID;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public MessageType getType() {
        return MessageType.NOTICE_VIP_RENEW;
    }
}
