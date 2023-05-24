package com.ssafy.enjoytrip.plan.service;

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
	public int addPlan(PlanDto planDto) throws Exception {
		return planMapper.addPlan(planDto);
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
	public void addRoute(Map<String, Object> data) throws Exception {
		planMapper.addRoute(data);
	}

	@Override
	public List<RouteDto> getRoute(String planId) throws Exception {
		return planMapper.getRoute(planId);
	}

	@Override
	public void updateRoute(Map<String, Object> data) throws Exception {
		String planId = (String) data.get("planId");
		planMapper.deleteRoute(planId);
		planMapper.addRoute(data);
	}

	@Override
	public void deleteRoute(String planId) throws Exception {
		planMapper.deleteRoute(planId);
	}

	@Override
	public void updateMemo(Map<String, Object> data) throws Exception {
		planMapper.updateMemo(data);
	}

	@Override
	public void updateVisitTime(Map<String, Object> data) throws Exception {
		planMapper.updateVisitTime(data);
	}

	@Override
	public void addPartner(Map<String, Object> data) throws Exception {
		planMapper.addPartner(data);
	}




}
