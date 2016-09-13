package online.decentworld.rpc.codc;

import online.decentworld.rpc.dto.message.MessageWrapper;

public interface MessageLisener {

	void onMessageReceive(MessageWrapper msg);
}
