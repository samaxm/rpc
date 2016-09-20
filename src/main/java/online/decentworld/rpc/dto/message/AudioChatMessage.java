package online.decentworld.rpc.dto.message;

import online.decentworld.rpc.dto.message.types.ChatMessageType;
import online.decentworld.rpc.dto.message.types.ChatRelation;
import online.decentworld.rpc.dto.message.types.ChatStatus;

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

    public AudioChatMessage(ChatStatus status, String receiverWealth, String tempID, long mid,long time, ChatRelation relation, ChatMessageType type, String fromID, String toID, int length, String url) {
        super(status, receiverWealth, tempID, mid, time, relation, type, fromID, toID);
        this.length = length;
        this.url = url;
    }

    public AudioChatMessage(){};

    public static AudioChatMessage createAudioMessage(String from,String to,int length,String url){
        AudioChatMessage msg=new AudioChatMessage();
        msg.setSendDefault();
        msg.setToID(to);
        msg.setFromID(from);
        msg.setLength(length);
        msg.setUrl(url);
        msg.setChatType(ChatMessageType.AUDIO);
        return msg;
    }
}
