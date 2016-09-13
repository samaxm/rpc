package online.decentworld.rpc.dto.message;

import online.decentworld.rpc.dto.message.types.ChatMessageType;
import online.decentworld.rpc.dto.message.types.ChatRelation;
import online.decentworld.rpc.dto.message.types.ChatStatus;
import online.decentworld.rpc.dto.message.types.ChatrDirect;

/**
 * Created by Sammax on 2016/9/13.
 */
public final class TextChatMessage extends ChatMessage {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TextChatMessage(ChatStatus status, String receiverWealth, String tempID, long mid, ChatrDirect direct, long time, ChatRelation relation, ChatMessageType type, String text) {
        super(status, receiverWealth, tempID, mid, direct, time, relation, type);
        this.text = text;
    }

    public TextChatMessage(){};
}
