package online.decentworld.rpc.codc.protos;

import com.google.protobuf.ByteString;
import online.decentworld.rpc.dto.message.MessageBody;
import online.decentworld.rpc.dto.message.MessageWrapper;
import online.decentworld.rpc.dto.message.WealthAckMessage;
import online.decentworld.rpc.dto.message.protos.MessageProtos;
import online.decentworld.rpc.dto.message.types.ChatRelation;
import online.decentworld.rpc.dto.message.types.ChatStatus;

/**
 * Created by Sammax on 2016/9/18.
 */
public class WealthACKMessageCodeec extends ProcosMessageWrapper  {


    @Override
    protected MessageWrapper warpMessageBody(MessageWrapper wrapper, ByteString bodyData) throws Exception {
        MessageProtos.WealthACK wealthACK=MessageProtos.WealthACK.parseFrom(bodyData);
        WealthAckMessage wACK=new WealthAckMessage(wealthACK.getTempID(),wealthACK.getMid(),wealthACK.getWealth(),wealthACK.getChargeSuccess(), ChatRelation.getChatRelation(wealthACK.getRelationType().getNumber()), ChatStatus.getChatStatus(wealthACK.getStatus().getNumber()));
        wrapper.setBody(wACK);
        return wrapper;
    }

    @Override
    protected ByteString encodeMessageBody(MessageBody body) throws Exception {
        WealthAckMessage msg=(WealthAckMessage)body;
        return MessageProtos.WealthACK.newBuilder().setMid(msg.getMid()).setTempID(msg.getTempID()).setWealth(msg.getWealth())
                .setRelationType(MessageProtos.FriendType.forNumber(msg.getRelation().getCode())).setStatus(MessageProtos.ChargeStatus.forNumber(msg.getStatus().getCode()))
                .setChargeSuccess(msg.isChargeSuccess()).build().toByteString();
    }
}
