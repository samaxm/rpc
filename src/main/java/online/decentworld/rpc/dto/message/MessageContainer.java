package online.decentworld.rpc.dto.message;

import online.decentworld.rpc.dto.message.types.MessageType;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sammax on 2016/9/19.
 */
public class MessageContainer implements MessageBody {



    private List<MessageWrapper> messages=new LinkedList<>();


    public List<MessageWrapper> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageWrapper> messages) {
        this.messages = messages;
    }


    public void addMessage(MessageWrapper wrapper){
         messages.add(wrapper);
    }
    public int size(){
        return messages.size();
    }

    @Override
    public MessageType getType() {
        return MessageType.LIST;
    }
}
