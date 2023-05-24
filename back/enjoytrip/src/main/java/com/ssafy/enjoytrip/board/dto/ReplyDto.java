package com.ssafy.enjoytrip.board.dto;

public class ReplyDto {
	private int replyId;
	private int postId;
	private String writerId;
	private String replyContent;
	private String writeDate;
	private String updateDate;
	
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	@Override
	public String toString() {
		return "ReplyDto [replyId=" + replyId + ", postId=" + postId + ", writerId=" + writerId + ", replyContent="
				+ replyContent + ", writeDate=" + writeDate + ", updateDate=" + updateDate + "]";
	}
	

}
