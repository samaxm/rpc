package online.decentworld.rpc.dto.message;

public enum MessageType {
	TXT(0),
	AUDIO(1),
	VEDIO(2),
	VEDIO_LIKE(3);
	private int code;
	
	private MessageType(int code){
		this.code=code;
	}
	public int getCode() {
		return code;
	}
	public static MessageType getMessageType(int code){
		for(MessageType type:MessageType.values()){
			if(type.getCode()==code){
				return type;
			}
		}
		return null;
	}
}
