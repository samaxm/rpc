package online.decentworld.rpc.dto.message;

import online.decentworld.rpc.dto.message.types.MessageType;

public final class Notice_LikeMessageBody implements MessageBody {

	private final String icon;
	private final String name;
	private final String likeID;
	private final String beLikedID;
	private final String sex;

	
	public Notice_LikeMessageBody(String icon, String name, String likeID,
								  String beLikedID, String sex) {
		super();
		this.icon = icon;
		this.name = name;
		this.likeID = likeID;
		this.beLikedID = beLikedID;
		this.sex = sex;
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


	@Override
	public MessageType getType() {
		return MessageType.NOTICE_LIKE;
	}
}
