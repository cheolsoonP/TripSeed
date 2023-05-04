package com.ssafy.enjoytrip.plan.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.plan.dto.PlanDto;
import com.ssafy.enjoytrip.plan.dto.RouteDto;
import com.ssafy.enjoytrip.plan.mapper.PlanMapper;

@Service
public class PlanServiceImpl implements PlanService {

	private PlanMapper planMapper;
	
	public PlanServiceImpl(PlanMapper planMapper) {
		this.planMapper = planMapper;
	}
	
	@Override
	public void addPlan(PlanDto planDto) throws Exception {
		planMapper.addPlan(planDto);
	}

	@Override
	public List<PlanDto> getPlanList(String userId) throws Exception {
		return planMapper.getPlanList(userId);
	}

	@Override
	public void deletePlan(String planId) throws Exception {
		planMapper.deletePlan(planId);
	}

	@Override
	public void updatePlan(PlanDto planDto) throws Exception {
		planMapper.updatePlan(planDto);
	}

	@Override
	public PlanDto getPlan(String planId) throws Exception {
		return planMapper.getPlan(planId);
	}

	@Override
	public void addRoute(String planId, List<Map<String, Object>> routes) throws Exception {
		planMapper.addRoute(planId, routes);
	}

	@Override
	public List<RouteDto> getRoute(String planId) throws Exception {
		return planMapper.getRoute(planId);
	}

}
