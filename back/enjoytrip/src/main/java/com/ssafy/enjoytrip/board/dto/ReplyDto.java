package com.ssafy.enjoytrip.board.dto;

public class ReplyDto {
	private int replyId;
	private int contentId;
	private String writeId;
	private String replyContent;
	private String writeDate;
	private String updateDate;
	
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public String getWriteId() {
		return writeId;
	}
	public void setWriteId(String writeId) {
		this.writeId = writeId;
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
	
	@Override
	public String toString() {
		return "ReplyDto [replyId=" + replyId + ", contentId=" + contentId + ", writeId=" + writeId + ", replyContent="
				+ replyContent + ", writeDate=" + writeDate + ", updateDate=" + updateDate + "]";
	}
}
