package com.ssafy.enjoytrip.plan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.plan.dto.PlanDto;

@Mapper
public interface PlanMapper {

	void addPlan(PlanDto planDto);

	List<PlanDto> getPlanList(String userid);

}
