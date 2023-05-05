package com.ssafy.enjoytrip.plan.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.enjoytrip.plan.dto.PlanDto;
import com.ssafy.enjoytrip.plan.dto.RouteDto;


@SpringBootTest()
@Transactional
class PlanServiceImplTest {
	
	private Logger log = LoggerFactory.getLogger(PlanServiceImplTest.class);
	
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
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("planId", "1");
			
			List<Map<String, Object>> routes = new ArrayList<>();
			Map<String, Object> map1 = new HashMap<>();
			map1.put("visitOrder", "1");
			map1.put("attractionId", "2028440");
			routes.add(map1);

			Map<String, Object> map2 = new HashMap<>();
			map2.put("visitOrder", "2");
			map2.put("attractionId", "2028440");
			routes.add(map2);

			Map<String, Object> map3 = new HashMap<>();
			map3.put("visitOrder", "3");
			map3.put("attractionId", "2028440");
			routes.add(map3);

			Map<String, Object> map4 = new HashMap<>();
			map4.put("visitOrder", "4");
			map4.put("attractionId", "2028440");
			routes.add(map4);
			
			data.put("routes", routes);
			
			planService.addRoute(data);
		} catch (Exception e) {
			fail("여행 경로 추가 실패");
		}	
	}
	
	@Test
	@DisplayName("여행 경로 조회 테스트")
	void testGetRoute() {
		try {
			planService.getRoute("1");
		} catch (Exception e) {
			fail("여행 경로 조회 실패");
		}
	}
	
	@Test
	@DisplayName("여행 경로 수정 테스트")
	void testUpdateRoute() {
		try {			
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("planId", "1");
			
			List<Map<String, Object>> routes = new ArrayList<>();
			Map<String, Object> map1 = new HashMap<>();
			map1.put("visitOrder", "1");
			map1.put("attractionId", "2028440");
			routes.add(map1);

			Map<String, Object> map2 = new HashMap<>();
			map2.put("visitOrder", "2");
			map2.put("attractionId", "2028440");
			routes.add(map2);

			Map<String, Object> map3 = new HashMap<>();
			map3.put("visitOrder", "3");
			map3.put("attractionId", "2028440");
			routes.add(map3);

			Map<String, Object> map4 = new HashMap<>();
			map4.put("visitOrder", "4");
			map4.put("attractionId", "2028440");
			routes.add(map4);
			
			data.put("routes", routes);
			
			planService.updateRoute(data);
		} catch (Exception e) {
			fail("여행 경로 수정 실패");
		}	
	}
	
	@Test
	@DisplayName("메모 추가 테스트")
	void testUpdateMemo() {
		try {			
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("memo", "이곳은 메밀전병이 맛있습니다.");
			data.put("planId", "2");
			data.put("attractionId", "126479");
			
			planService.updateMemo(data);
		} catch (Exception e) {
			fail("메모 변경 실패");
		}
	}
	
	@Test
	@DisplayName("메모 삭제 테스트")
	void testDeleteMemo() {
		try {			
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("planId", "2");
			data.put("attractionId", "126479");
			
			planService.updateMemo(data);
		} catch (Exception e) {
			fail("메모 삭제 실패");
		}
	}
	
	@Test
	@DisplayName("방문 시간 추가 테스트")
	void testUpdateVisitTime() {
		try {			
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("visitTime", "17:00");
			data.put("planId", "2");
			data.put("attractionId", "126479");
			
			planService.updateVisitTime(data);
		} catch (Exception e) {
			fail("방문 시간 변경 실패");
		}
	}
	
	@Test
	@DisplayName("방문 시간 삭제 테스트")
	void testDeleteVisitTime() {
		try {			
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("planId", "2");
			data.put("attractionId", "126479");
			
			planService.updateVisitTime(data);
		} catch (Exception e) {
			fail("방문 시간 삭제 실패");
		}
	}
}
