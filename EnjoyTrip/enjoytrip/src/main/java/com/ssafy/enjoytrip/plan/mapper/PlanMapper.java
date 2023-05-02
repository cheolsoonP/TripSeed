package com.ssafy.enjoytrip.plan.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.plan.dto.PlanDto;

@Mapper
public interface PlanMapper {

	void addPlan(PlanDto planDto) throws SQLException;

	List<PlanDto> getPlanList(String userId) throws SQLException;

	void deletePlan(String planId) throws SQLException;

	void updatePlan(PlanDto planDto) throws SQLException;

	PlanDto getPlan(String planId) throws SQLException;

}
