package com.ssafy.enjoytrip.plan.service;

import java.util.List;
import java.util.Map;

import com.ssafy.enjoytrip.plan.dto.PlanDto;
import com.ssafy.enjoytrip.plan.dto.RouteDto;

public interface PlanService {

	void addPlan(PlanDto planDto) throws Exception;

	List<PlanDto> getPlanList(String userId) throws Exception;

	void deletePlan(String planId) throws Exception;
	
	void updatePlan(PlanDto planDto) throws Exception;

	PlanDto getPlan(String planId) throws Exception;

	void addRoute(String planId, List<Map<String, Object>> routes) throws Exception;

	List<RouteDto> getRoute(String planId) throws Exception;

}
