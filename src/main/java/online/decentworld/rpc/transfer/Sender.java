package online.decentworld.rpc.transfer;


import online.decentworld.rpc.dto.message.MessageWrapper;

public interface Sender {
	public void send(byte[] data,String receiver,TransferPolicy policy) throws Exception;
	public void send(MessageWrapper msg,String receiver) throws Exception;
}
