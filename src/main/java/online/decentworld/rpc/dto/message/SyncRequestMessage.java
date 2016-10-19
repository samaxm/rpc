package online.decentworld.rpc.dto.message;

import online.decentworld.rpc.dto.message.types.MessageType;

/**
 * Created by Sammax on 2016/10/19.
 */
public class SyncRequestMessage implements MessageBody {

    private long syncNum;

    public SyncRequestMessage(long syncNum) {
        this.syncNum = syncNum;
    }

    @Override
    public MessageType getType() {
        return MessageType.COMMAND_MSG_SYNC_REQUEST;
    }

    public long getSyncNum() {
        return syncNum;
    }

    public void setSyncNum(long syncNum) {
        this.syncNum = syncNum;
    }
}
