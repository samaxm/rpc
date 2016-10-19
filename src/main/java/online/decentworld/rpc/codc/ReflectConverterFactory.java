package online.decentworld.rpc.codc;

import online.decentworld.rpc.codc.protos.MessageContainerConverter;
import online.decentworld.rpc.dto.message.types.MessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class ReflectConverterFactory implements MessageConverterFactory {

	private final HashMap<MessageType,MessageConverter> map;
	private static Logger logger=LoggerFactory.getLogger(ReflectConverterFactory.class);

	public ReflectConverterFactory(){
		map=new HashMap<>();
		Properties pro=new Properties();
		try {
			pro.load(ReflectConverterFactory.class.getClassLoader().getResourceAsStream("protos-codec-mapper.properties"));
			for(MessageType type:MessageType.values()){
				if(pro.getProperty(type.name())!=null){
					Class<? extends MessageConverter> c=(Class<? extends MessageConverter>)Class.forName(pro.getProperty(type.name()));
					MessageConverter messageConverter=c.newInstance();
					if(messageConverter instanceof MessageContainerConverter){
						((MessageContainerConverter) messageConverter).setConverterFactory(this);
					}
					map.put(type, messageConverter);
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			logger.warn("[INIT_BODYCODECFACTORY_ERROR]",e);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	@Override
	public MessageConverter getMessageConverter(MessageType type) {
			return map.get(type);
	}
	public static void main(String[] args) {

	}
}
