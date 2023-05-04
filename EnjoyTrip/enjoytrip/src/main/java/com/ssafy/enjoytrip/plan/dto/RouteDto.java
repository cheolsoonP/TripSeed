package com.ssafy.enjoytrip.plan.dto;

public class RouteDto {
	private int planId;
	private int attractionId;
	private int order;
	private String memo;
	private String visitTime;
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public int getAttractionId() {
		return attractionId;
	}
	public void setAttractionId(int attractionId) {
		this.attractionId = attractionId;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}
	@Override
	public String toString() {
		return "RouteDto [planId=" + planId + ", attractionId=" + attractionId + ", order=" + order + ", memo=" + memo
				+ ", visitTime=" + visitTime + "]";
	}
	
	
}
