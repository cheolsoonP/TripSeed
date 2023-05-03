package com.ssafy.enjoytrip.plan.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.enjoytrip.plan.dto.PlanDto;


@SpringBootTest()
@Transactional
class PlanServiceImplTest {
	
	@Autowired
	PlanService planService;
	
	@Test
	@DisplayName("여행 계획 추가 테스트")
	void testAddPlan() {
		try {
			PlanDto planDto = new PlanDto();
			planDto.setPlanTitle("강릉 3박4일 여행");
			planDto.setUserId("ssafy");
			planDto.setStartDate("2022-01-01");
			planDto.setEndDate("2022-01-04");
			planDto.setComplete(0);
			planService.addPlan(planDto);
		} catch (Exception e) {
			fail("여행 계획 추가 실패");
		}	
	}

	@Test
	@DisplayName("여행 계획 리스트 조회 테스트")
	void testGetPlanList() {
		try {
			planService.getPlanList("ssafy");
		} catch (Exception e) {
			fail("여행 계획 리스트 조회 실패");
		}	
	}

	@Test
	@DisplayName("여행 계획 삭제 테스트")
	void testDeletePlan() {
		try {
			planService.deletePlan("1");
		} catch (Exception e) {
			fail("여행 계획 삭제 실패");
		}	
	}

	@Test
	@DisplayName("여행 계획 변경 테스트")
	void testUpdatePlan() {
		try {
			PlanDto planDto = new PlanDto();
			planDto.setPlanTitle("속초 1박2일 여행");
			planDto.setUserId("ssafy");
			planDto.setStartDate("2022-02-01");
			planDto.setEndDate("2022-02-03");
			planService.updatePlan(planDto);
		} catch (Exception e) {
			fail("여행 계획 변경 실패");
		}		
	}

	@Test
	@DisplayName("여행 계획 내용 조회 테스트")
	void testGetPlan() {
		try {
			planService.getPlan("1");
		} catch (Exception e) {
			fail("여행 계획 내용 조회 실패");
		}	
	}

	@Test
	@DisplayName("여행 경로 추가 테스트")
	void testAddRoute() {
		try {			
			List<Map<String, Object>> list = new ArrayList<>();
			Map<String, Object> map1 = new HashMap<>();
			map1.put("order", "1");
			map1.put("attraction_id", "2028440");
			list.add(map1);

			Map<String, Object> map2 = new HashMap<>();
			map2.put("order", "2");
			map2.put("attraction_id", "2028440");
			list.add(map2);

			Map<String, Object> map3 = new HashMap<>();
			map3.put("order", "3");
			map3.put("attraction_id", "2028440");
			list.add(map3);

			Map<String, Object> map4 = new HashMap<>();
			map4.put("order", "4");
			map4.put("attraction_id", "2028440");
			list.add(map4);
			
			planService.addRoute("1", list);
		} catch (Exception e) {
			fail("여행 경로 추가 실패");
		}	
	}
}
