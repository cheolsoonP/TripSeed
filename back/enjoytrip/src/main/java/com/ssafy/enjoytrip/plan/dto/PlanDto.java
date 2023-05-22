package com.ssafy.enjoytrip.plan.dto;

public class PlanDto {

	private int planId;
	private String userId;
	private String planTitle;
	private String startDate;
	private String endDate;
	private int complete;
	private String image;
	
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPlanTitle() {
		return planTitle;
	}
	public void setPlanTitle(String planTitle) {
		this.planTitle = planTitle;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getComplete() {
		return complete;
	}
	public void setComplete(int complete) {
		this.complete = complete;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "PlanDto [planId=" + planId + ", userId=" + userId + ", planTitle=" + planTitle + ", startDate="
				+ startDate + ", endDate=" + endDate + ", complete=" + complete + ", image=" + image + "]";
	}
	
	

	
}
