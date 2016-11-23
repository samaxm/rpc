package online.decentworld.rpc.dto.message;

import online.decentworld.rpc.dto.message.types.MessageType;

/**
 * Created by Sammax on 2016/11/17.
 */
public class Notice_LikeResponseMessageBody implements MessageBody {
    private UserInfo info;
    private boolean accept;



    public Notice_LikeResponseMessageBody(UserInfo info, boolean accept) {
        this.info = info;
        this.accept = accept;
    }

    public UserInfo getInfo() {
        return info;
    }

    public void setInfo(UserInfo info) {
        this.info = info;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

    @Override
    public MessageType getType() {
        return MessageType.NOTICE_LIKE_RESPONSE;
    }
}
