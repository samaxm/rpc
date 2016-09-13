package online.decentworld.rpc.dto.message;

import online.decentworld.rpc.dto.message.types.ChatMessageType;
import online.decentworld.rpc.dto.message.types.ChatRelation;
import online.decentworld.rpc.dto.message.types.ChatStatus;
import online.decentworld.rpc.dto.message.types.ChatrDirect;

/**
 * Created by Sammax on 2016/9/13.
 */
public class ImageChatMessage extends ChatMessage {
    private byte[] compress;
    private String url;

    public byte[] getCompress() {
        return compress;
    }

    public void setCompress(byte[] compress) {
        this.compress = compress;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public ImageChatMessage(ChatStatus status, String receiverWealth, String tempID, long mid, ChatrDirect direct, long time, ChatRelation relation, ChatMessageType type, byte[] compress,String url) {
        super(status, receiverWealth, tempID, mid, direct, time, relation, type);
        this.compress = compress;
        this.url=url;
    }

    public ImageChatMessage() {

    }
}
