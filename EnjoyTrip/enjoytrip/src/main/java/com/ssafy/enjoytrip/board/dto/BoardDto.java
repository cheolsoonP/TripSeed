package com.ssafy.enjoytrip.board.dto;

public class BoardDto {
	private int contentId;
	private String title;
	private String writerId;
	private String content;
	private int likeCount;
	private int viewCount;
	private String writeDate;
	private String updateDate;
	private int sidoCode;
	private int gugunCode;
	
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
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
	public int getSidoCode() {
		return sidoCode;
	}
	public void setSidoCode(int sidoCode) {
		this.sidoCode = sidoCode;
	}
	public int getGugunCode() {
		return gugunCode;
	}
	public void setGugunCode(int gugunCode) {
		this.gugunCode = gugunCode;
	}
	
	@Override
	public String toString() {
		return "BoardDto [contentId=" + contentId + ", title=" + title + ", writerId=" + writerId + ", content="
				+ content + ", likeCount=" + likeCount + ", viewCount=" + viewCount + ", writeDate=" + writeDate
				+ ", updateDate=" + updateDate + ", sidoCode=" + sidoCode + ", gugunCode=" + gugunCode + "]";
	}
}
