package online.decentworld.rpc.dto.message.protos;

import java.util.Date;

import online.decentworld.rpc.dto.message.LikeMessageBody;
import online.decentworld.rpc.dto.message.protos.MessageProtos.VedioLikeMessageInfo;

import com.google.protobuf.ByteString;

public final class ProtosVedioLikeMessageBody extends LikeMessageBody implements ProtosMessge{

	public ProtosVedioLikeMessageBody(String icon, String name, String likeID,
			String beLikedID, String sex, Date time) {
		super(icon, name, likeID, beLikedID, sex, time);
	}

	public ProtosVedioLikeMessageBody(LikeMessageBody body) {
		super(body.getIcon(), body.getName(), body.getLikeID(), body.getBeLikedID(), body.getSex(), body.getTime());
	}
	
	public ProtosVedioLikeMessageBody(VedioLikeMessageInfo info) {
		super(info.getIcon(), info.getName(),info.getLikeID(),info.getBelikeID(),info.getSex(),new Date(info.getTime()));
	}
	
	
	@Override
	public byte[] toByteArrary() {
		return VedioLikeMessageInfo.newBuilder().setBelikeID(getBeLikedID()).setLikeID(getLikeID())
				.setName(getName()).setSex(getSex()).setIcon(getIcon()).setTime(getTime().getTime())
				.build().toByteArray();
	}

	@Override
	public ByteString encode() {
		return
		VedioLikeMessageInfo.newBuilder().setBelikeID(getBeLikedID()).setLikeID(getLikeID())
		.setName(getName()).setSex(getSex()).setIcon(getIcon()).setTime(getTime().getTime())
		.build()
		.toByteString();
	}

}
