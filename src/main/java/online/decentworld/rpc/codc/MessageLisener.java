package online.decentworld.rpc.codc;

import online.decentworld.rpc.dto.message.BaseMessage;

public interface MessageLisener {

	void onMessageReceive(BaseMessage msg);
}
