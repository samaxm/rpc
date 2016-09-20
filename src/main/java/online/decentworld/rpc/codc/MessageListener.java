package online.decentworld.rpc.codc;

import online.decentworld.rpc.dto.message.MessageWrapper;

public interface MessageListener {

	void onMessageReceive(MessageWrapper msg);
}
