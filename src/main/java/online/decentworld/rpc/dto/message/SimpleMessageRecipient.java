package online.decentworld.rpc.dto.message;

final public class SimpleMessageRecipient implements MessageRecipient{
	
	private final String userID;
	
	public SimpleMessageRecipient(String dwID){
		this.userID=dwID;
	}

	
	@Override
	public String getID() {
		return userID;
	}

	@Override
	public String stringValue() {
		return userID;
	}


	@Override
	public Object getDestination() {
		return userID;
	}
	

	
}
