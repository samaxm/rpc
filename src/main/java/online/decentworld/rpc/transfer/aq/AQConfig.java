package online.decentworld.rpc.transfer.aq;

import java.util.Properties;

public final class AQConfig {
	final public static String CONNECTSTRING;
	final public static String USERNAME;
	final public static String PASSWORD;
	final public static String IP;
	final public static String PORT;
	final public static int MAX_CONNECTION;
	final public static int MAX_SESSIONS;
	final public static int IDLE_TIME;
	static{
		Properties p=null;
		try{
			p=new Properties();
			p.load(AQConfig.class.getClassLoader().getResourceAsStream("AQConfig.properties"));
		}catch(Exception ex){}
		USERNAME=p.getProperty("USERNAME");
		PASSWORD=p.getProperty("PASSWORD");
		IP=p.getProperty("IP");
		PORT=p.getProperty("PORT");
		IDLE_TIME=Integer.valueOf(p.getProperty("IDLE_TIME"));
		MAX_SESSIONS=Integer.valueOf(p.getProperty("MAX_SESSIONS"));
		MAX_CONNECTION=Integer.valueOf(p.getProperty("MAX_CONNECTION"));
		CONNECTSTRING="failover:(tcp://"+IP+":"+PORT+")?initialReconnectDelay=1000&timeout=3000&startupMaxReconnectAttempts=2";
	}
	
	
	public static void main(String[] args) {
		System.out.println(AQConfig.CONNECTSTRING);
	}
}
