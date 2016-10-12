package online.decentworld.rpc.dto.message;

import online.decentworld.rpc.dto.message.types.ChatMessageType;
import online.decentworld.rpc.dto.message.types.ChatRelation;
import online.decentworld.rpc.dto.message.types.ChatStatus;

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

    public TextChatMessage(ChatStatus status, String receiverWealth, String tempID, ChatRelation relation, ChatMessageType type, String fromID, String toID, String text) {
        super(status, receiverWealth, tempID,relation, type, fromID, toID);
        this.text = text;
    }

    public TextChatMessage(){

    };

    public static TextChatMessage createTextMessage(String from,String to,String text){
        TextChatMessage msg=new TextChatMessage();
        msg.setSendDefault();
        msg.setFromID(from);
        msg.setToID(to);
        msg.setText(text);
        msg.setChatType(ChatMessageType.TXT);
        return msg;
    }

}
