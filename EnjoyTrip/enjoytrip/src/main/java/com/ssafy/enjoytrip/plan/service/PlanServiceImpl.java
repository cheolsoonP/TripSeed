package com.ssafy.enjoytrip.plan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.plan.dto.PlanDto;
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

}
