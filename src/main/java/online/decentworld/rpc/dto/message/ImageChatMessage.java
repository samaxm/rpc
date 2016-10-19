package online.decentworld.rpc.dto.message;

import online.decentworld.rpc.dto.message.types.ChatRelation;
import online.decentworld.rpc.dto.message.types.ChatStatus;
import online.decentworld.rpc.dto.message.types.MessageType;

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


    public ImageChatMessage(ChatStatus status, String receiverWealth, String tempID,ChatRelation relation,String fromID, String toID, byte[] compress, String url) {
        super(status, receiverWealth, tempID, relation,fromID, toID);
        this.compress = compress;
        this.url = url;
    }

    public ImageChatMessage() {

    }

    public static ImageChatMessage createImageMessage(String from,String to,byte[] compress,String url){
        ImageChatMessage msg=new ImageChatMessage();
        msg.setToID(to);
        msg.setFromID(from);
        msg.setCompress(compress);
        msg.setUrl(url);
        msg.setSendDefault();
        return msg;
    }

    @Override
    public MessageType getType() {
        return MessageType.CHAT_IMAGE;
    }
}
