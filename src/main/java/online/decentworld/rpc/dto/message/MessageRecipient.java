package online.decentworld.rpc.dto.message;

public interface MessageRecipient {
	
	String getID();
	
	String stringValue();
	
	Object getDestination();
	
}
