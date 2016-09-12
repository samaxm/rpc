package online.decentworld.rpc.transfer.aq;

import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.pool.PooledConnection;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AQConnetionHelper {
	private static Logger log=LoggerFactory.getLogger(AQConnetionHelper.class);
	private static PooledConnectionFactory pooledFactory;
	private static PooledConnection conn; 

	static{
		//初始化factory
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
        	 log.warn("【MQ_INIT_ERROR】",e);
         }  
	}
        public static PooledConnection getConn() {  
            return conn;  
        }  
}
