package online.decentworld.rpc.dto.message;

import java.util.Date;

public abstract class LikeMessageBody implements MessageBody {

	private final String icon;
	private final String name;
	private final String likeID;
	private final String beLikedID;
	private final String sex;
	private final Date time ;
	
	
	public LikeMessageBody(String icon, String name, String likeID,
						   String beLikedID, String sex, Date time) {
		super();
		this.icon = icon;
		this.name = name;
		this.likeID = likeID;
		this.beLikedID = beLikedID;
		this.sex = sex;
		this.time = time;
	}
	public String getIcon() {
		return icon;
	}
	public String getName() {
		return name;
	}
	public String getLikeID() {
		return likeID;
	}
	public String getBeLikedID() {
		return beLikedID;
	}
	public String getSex() {
		return sex;
	}
	public Date getTime() {
		return time;
	}
	
	
	
	
}
