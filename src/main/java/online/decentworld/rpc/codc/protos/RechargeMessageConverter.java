package online.decentworld.rpc.codc.protos;

import com.google.protobuf.ByteString;
import online.decentworld.rpc.dto.message.MessageBody;
import online.decentworld.rpc.dto.message.Notic_RechargeMessageBody;
import online.decentworld.rpc.dto.message.protos.MessageProtos;

/**
 * Created by Sammax on 2016/10/28.
 */
public class RechargeMessageConverter extends ProcosMessageWrapper {
    @Override
    protected MessageBody convert2MessageBody(ByteString bodyData) throws Exception {
        MessageProtos.Notice_Recharge rechargeNotice= MessageProtos.Notice_Recharge.parseFrom(bodyData);
        return new Notic_RechargeMessageBody(rechargeNotice.getDwID(),rechargeNotice.getTime(),rechargeNotice.getAmount());
    }

    @Override
    protected ByteString conver2ByteString(MessageBody body) throws Exception {
        Notic_RechargeMessageBody msg=(Notic_RechargeMessageBody)body;
        return  MessageProtos.Notice_Recharge.newBuilder().setTime(msg.getTime()).setDwID(msg.getDwID()).setAmount(msg.getAmount()).build().toByteString();
    }
}