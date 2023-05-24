package com.ssafy.enjoytrip.plan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RouteDto {
	private int planId;
	private int attractionId;
	private int visitOrder;
	private String memo;
	private String visitTime;
	private String visitDate;
	private String title;
	private String latitude;
	private String longitude;
	private String image;
	private String addr;
}
