package online.decentworld.rpc.codc.protos;

import online.decentworld.rpc.dto.message.types.MessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class ReflectBodyCodecFactory implements ProtosBodyCodecFactory{

	private final HashMap<MessageType,Class<? extends ProtosMessageCodec>> map;
	private static Logger logger=LoggerFactory.getLogger(ReflectBodyCodecFactory.class);
	
	public ReflectBodyCodecFactory(){
		map=new HashMap<MessageType, Class<? extends ProtosMessageCodec>>();
		Properties pro=new Properties();
		try {

			pro.load(ReflectBodyCodecFactory.class.getClassLoader().getResourceAsStream("protos-codec-mapper.properties"));
			for(String type:pro.stringPropertyNames()){
				if(type!=null&& MessageType.valueOf(type)!=null&&pro.getProperty(type)!=null){
					@SuppressWarnings("unchecked")
					Class<? extends ProtosMessageCodec> c=(Class<? extends ProtosMessageCodec>)Class.forName(pro.getProperty(type));
					map.put(MessageType.valueOf(type),c);
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			logger.warn("[INIT_BODYCODECFACTORY_ERROR]",e);
		}
	}
	@Override
	public ProtosMessageCodec getMessageCodec(MessageType type) {
		try {
			return map.get(type).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			logger.warn("[INIT_CODEC_FAILED]",e);
			return null;
		}
	}

	public static void main(String[] args) {
		ReflectBodyCodecFactory f=new ReflectBodyCodecFactory();
		ProtosMessageCodec p=f.getMessageCodec(MessageType.LIKE);
		System.out.println(p);
	}
}
