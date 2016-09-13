package online.decentworld.rpc.transfer;


public interface Sender {
	public void send(byte[] data,String receiver,TransferPolicy policy) throws Exception;
}
