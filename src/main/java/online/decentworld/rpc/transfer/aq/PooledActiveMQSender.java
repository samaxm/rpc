package online.decentworld.rpc.transfer.aq;

import online.decentworld.rpc.codc.Codec;
import online.decentworld.rpc.dto.message.MessageWrapper;
import online.decentworld.rpc.transfer.Sender;
import online.decentworld.rpc.transfer.TransferPolicy;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.jms.pool.PooledConnection;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.apache.activemq.store.kahadb.data.KahaDestination.DestinationType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;

public class PooledActiveMQSender implements Sender{
	
	private PooledConnectionFactory pooledFactory;
	private PooledConnection conn;
	private Codec codec;
	private static Logger logger=LoggerFactory.getLogger(PooledActiveMQSender.class);
	
	
	@Override
	public void send(byte[] data, String receiver,
			TransferPolicy policy) throws Exception {
		
		if(check(data, receiver, policy)){
			ActiveMQPolicy aqp=(ActiveMQPolicy)policy;
			Session session=getConnection().createSession(aqp.isTransactional(),aqp.getSessionMode());
			BytesMessage msg=session.createBytesMessage();
			msg.writeBytes(data);
			Destination d=null;
			if(DestinationType.QUEUE==aqp.getType()){
				d=session.createQueue(receiver);
			}else{
				d=session.createTopic(receiver);
			}
			MessageProducer producer=session.createProducer(d);
			producer.setDeliveryMode(aqp.getSessionMode());
			producer.send(msg);
		}
	}
	
	public void send(MessageWrapper msg,String receiver) throws Exception{
		send(codec.encode(msg), receiver,ActiveMQPolicy.BRIEF);
	}
	
	private boolean check(byte[] data, String receiver,
			TransferPolicy policy){
		if(!(policy instanceof ActiveMQPolicy)){
			return false;
		}
		return true;
	}
	
	public PooledConnection getConnection(){
		if(conn==null){
			initConnectionPool();
		}
		return conn;
	}
	
	private synchronized void initConnectionPool(){
		if(conn==null){
			ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(AQConfig.CONNECTSTRING);  
			factory.setUserName(AQConfig.USERNAME);
			factory.setPassword(AQConfig.PASSWORD);
	        try {  
	       	 pooledFactory = new PooledConnectionFactory(factory);
	       	 pooledFactory.setIdleTimeout(AQConfig.IDLE_TIME);
	       	 pooledFactory.setMaxConnections(AQConfig.MAX_CONNECTION);
	       	 pooledFactory.setMaximumActiveSessionPerConnection(AQConfig.MAX_SESSIONS);
	       	 //立即初始化connection
	       	 pooledFactory.setCreateConnectionOnStartup(true);
	       	 //开启自动重连
	       	 pooledFactory.setReconnectOnException(true);
	       	 //在确定发送用户所在服务器时指定destination
	       	 pooledFactory.setUseAnonymousProducers(true);
	         conn = (PooledConnection) pooledFactory.createConnection();
	         conn.start();  
	        } catch (JMSException e) {  
	        	logger.warn("【MQ_INIT_ERROR】",e);
	        } 
		}
	}
	
	public static void main(String[] args) {
//		new Thread(()->{
//			System.out.println("------consumer-----");
//			Connection connection=AQConnetionHelper.getConn();
//			javax.jms.Session session=null;
//			try {
//				session=connection.createSession(false,javax.jms.Session.AUTO_ACKNOWLEDGE);
//				Destination d=session.createQueue("testA");
//				MessageConsumer consumer=session.createConsumer(d);
//				while(true){
//					BytesMessage msg=(BytesMessage)consumer.receive();
//					byte[] data=new byte[(int) msg.getBodyLength()];
//					msg.readBytes(data);
//					System.out.println(data.length);
//					SimpleProtosCodec codec=new SimpleProtosCodec();
//					codec.addLisener(new MessageLisener() {
//						@Override
//						public void onMessageReceive(BaseMessage msg) {
//							if(msg instanceof ProtosVedioLikeMessage){
//								ProtosVedioLikeMessage m=(ProtosVedioLikeMessage)msg;
//								ProtosVedioLikeMessageBody body=(ProtosVedioLikeMessageBody)m.getMessageBody();
//								System.out.println(body.getName());
//							}
//						}
//					});
//					codec.receiveData(data);
//				}
//			} catch (JMSException e) {
//				e.printStackTrace();
//			}
//		}).start();
//
// 		PooledActiveMQSender sender=new PooledActiveMQSender();
//		ProtosVedioLikeMessageBody body=new ProtosVedioLikeMessageBody("123", "sam", "123", "123", "1", new Date());
//		try {
//			sender.send(ProtosVedioLikeMessage.create(body), new SimpleMessageRecipient("testA"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
