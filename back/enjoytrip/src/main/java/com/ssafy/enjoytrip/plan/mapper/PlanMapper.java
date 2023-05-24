package com.ssafy.enjoytrip.plan.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.plan.dto.PlanDto;
import com.ssafy.enjoytrip.plan.dto.RouteDto;

@Mapper
public interface PlanMapper {

	int addPlan(PlanDto planDto) throws SQLException;

	List<PlanDto> getPlanList(String userId) throws SQLException;

	void deletePlan(String planId) throws SQLException;

	void updatePlan(PlanDto planDto) throws SQLException;

	PlanDto getPlan(String planId) throws SQLException;

	void addRoute(Map<String, Object> data) throws SQLException;

	List<RouteDto> getRoute(String planId) throws SQLException;

	void updateRoute(Map<String, Object> data) throws SQLException;

	void deleteRoute(String planId) throws SQLException;

	void updateMemo(Map<String, Object> data) throws SQLException;

	void updateVisitTime(Map<String, Object> data) throws SQLException;

	void addPartner(Map<String, Object> data) throws SQLException;

}
