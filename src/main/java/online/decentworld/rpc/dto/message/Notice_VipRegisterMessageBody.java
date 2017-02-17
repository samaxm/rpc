package online.decentworld.rpc.dto.message;

import online.decentworld.rpc.dto.message.types.MessageType;

import java.util.Date;

/**
 * Created by Sammax on 2016/11/25.
 */
public class Notice_VipRegisterMessageBody implements MessageBody {


    private String dwID;
    private Date time;


    public Notice_VipRegisterMessageBody(String dwID, Date time) {
        this.dwID = dwID;
        this.time = time;
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

    @Override
    public MessageType getType() {
        return MessageType.NOTICE_VIP_REGISTER;
    }
}
