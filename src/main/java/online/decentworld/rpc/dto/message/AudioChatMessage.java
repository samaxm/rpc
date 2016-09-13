package online.decentworld.rpc.dto.message;

import online.decentworld.rpc.dto.message.types.ChatMessageType;
import online.decentworld.rpc.dto.message.types.ChatRelation;
import online.decentworld.rpc.dto.message.types.ChatStatus;
import online.decentworld.rpc.dto.message.types.ChatrDirect;

/**
 * Created by Sammax on 2016/9/13.
 */
public final class AudioChatMessage extends ChatMessage {
    private int length;
    private String url;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public AudioChatMessage(ChatStatus status, String receiverWealth, String tempID, long mid, ChatrDirect direct, long time, ChatRelation relation, ChatMessageType type, int length, String url) {
        super(status, receiverWealth, tempID, mid, direct, time, relation, type);
        this.length = length;
        this.url = url;
    }

    public AudioChatMessage(){};
}
