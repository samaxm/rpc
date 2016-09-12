package online.decentworld.rpc.transfer;

import online.decentworld.rpc.dto.message.MessageRecipient;

public interface Sender {
	public void send(byte[] data,MessageRecipient receiver,TransferPolicy policy) throws Exception;
}
