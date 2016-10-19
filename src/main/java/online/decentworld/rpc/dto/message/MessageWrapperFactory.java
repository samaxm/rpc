package online.decentworld.rpc.dto.message;

import online.decentworld.rpc.dto.message.types.MessageType;

import java.util.Date;

/**
 * Created by Sammax on 2016/10/13.
 */
public class MessageWrapperFactory {

    public static MessageWrapper createLikeMessage(String dwID,String likedID,String name,String icon,String sex){
        return new MessageWrapper(dwID,likedID, MessageType.NOTICE_LIKE,new LikeMessageBody(icon,name,dwID,likedID,sex),new Date(),0);
    }

}
