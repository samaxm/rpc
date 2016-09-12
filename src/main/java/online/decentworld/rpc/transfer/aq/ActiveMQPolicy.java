package online.decentworld.rpc.transfer.aq;

import javax.jms.Session;

import online.decentworld.rpc.transfer.TransferPolicy;

import org.apache.activemq.store.kahadb.data.KahaDestination.DestinationType;

public class ActiveMQPolicy implements TransferPolicy{

	private boolean isTransactional;
	private int sessionMode;
	private boolean isPersistence;
	private DestinationType type;
	public static ActiveMQPolicy BRIEF=new ActiveMQPolicy(false, Session.AUTO_ACKNOWLEDGE, false,DestinationType.QUEUE);
	public static ActiveMQPolicy BRIEF_ACK=new ActiveMQPolicy(false, Session.CLIENT_ACKNOWLEDGE, false,DestinationType.QUEUE);
	
	public boolean isTransactional() {
		return isTransactional;
	}
	public void setTransactional(boolean isTransactional) {
		this.isTransactional = isTransactional;
	}
	public int getSessionMode() {
		return sessionMode;
	}
	public void setSessionMode(int sessionMode) {
		this.sessionMode = sessionMode;
	}
	public boolean isPersistence() {
		return isPersistence;
	}
	public void setPersistence(boolean isPersistence) {
		this.isPersistence = isPersistence;
	}
	public ActiveMQPolicy(boolean isTransactional, int sessionMode,
			boolean isPersistence,DestinationType type) {
		super();
		this.type=type;
		this.isTransactional = isTransactional;
		this.sessionMode = sessionMode;
		this.isPersistence = isPersistence;
	}
	public DestinationType getType() {
		return type;
	}
	public void setType(DestinationType type) {
		this.type = type;
	}

	
	
}
