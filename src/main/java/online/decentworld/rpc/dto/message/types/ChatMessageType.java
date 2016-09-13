package online.decentworld.rpc.dto.message.types;

public enum ChatMessageType {
	TXT(0),
	AUDIO(1),
	IMAGE(2);

	private int code;
	
	private ChatMessageType(int code){
		this.code=code;
	}
	public int getCode() {
		return code;
	}
	public static ChatMessageType getChatMessageType(int code){
		for(ChatMessageType type: ChatMessageType.values()){
			if(type.getCode()==code){
				return type;
			}
		}
		return null;
	}
}
