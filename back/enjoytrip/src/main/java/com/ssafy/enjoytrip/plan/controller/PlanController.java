package com.ssafy.enjoytrip.plan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.plan.dto.PlanDto;
import com.ssafy.enjoytrip.plan.dto.RouteDto;
import com.ssafy.enjoytrip.plan.service.PlanService;

@RestController
@RequestMapping("/plans")
@CrossOrigin("*")
public class PlanController {
	
	private PlanService planService;
	
	@Autowired
	public PlanController(PlanService planService) {
		this.planService = planService;
	}
	
	/* 여행 계획 추가/조회/수정/삭제  */
	@PostMapping("/plan")
	public ResponseEntity<?> addPlan(@RequestBody PlanDto planDto) {
		try {
			planService.addPlan(planDto);
			String planId = Integer.toString(planDto.getPlanId());
			return new ResponseEntity<String>(planId, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/list/{userId}")
	public ResponseEntity<?> getPlanList(@PathVariable("userId") String userId){
		try {
			List<PlanDto> planList = planService.getPlanList(userId);
			if(planList != null)
				return new ResponseEntity<List<PlanDto>>(planList, HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@DeleteMapping("/{planId}")
	public ResponseEntity<?> deletePlan(@PathVariable("planId") String planId){
		
		try {
			planService.deletePlan(planId);
			List<PlanDto> planList = planService.getPlanList("ssafy");
			
			if(planList != null)
				return new ResponseEntity<List<PlanDto>>(planList, HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@PutMapping("/plan")
	public ResponseEntity<?> updatePlan(@RequestBody PlanDto planDto){
		try {
			planService.updatePlan(planDto);
			List<PlanDto> planList = planService.getPlanList("ssafy");
			
			if(planList != null)
				return new ResponseEntity<List<PlanDto>>(planList, HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/view/{planId}")
	public ResponseEntity<?> getPlan(@PathVariable("planId") String planId){
		
		try {
			PlanDto planDto = planService.getPlan(planId);			
			if(planDto != null)
				return new ResponseEntity<PlanDto>(planDto, HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	
	/* 여행 경로 추가/조회/변경/삭제 */
	@PostMapping("/{planId}/routes")
	public ResponseEntity<?> addRoute(@PathVariable("planId") String planId, @RequestBody Map<String, Object> data){
		try {
			data.put("planId", planId);
			planService.addRoute(data);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	/* 여행 경로 조회 */
	@GetMapping("/{planId}/routes")
	public ResponseEntity<?> getRoute(@PathVariable("planId") String planId){
		try {
			List<RouteDto> routeList = planService.getRoute(planId);
			return new ResponseEntity<List<RouteDto>>(routeList, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	/* 여행 경로 변경 */
	@PutMapping("/{planId}/routes")
	public ResponseEntity<?> updateRoute(@PathVariable("planId") String planId, 
										@RequestBody Map<String, Object> data){
		try {

			data.put("planId", planId);
			planService.updateRoute(data);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	/* 여행 경로 변경 */
	@DeleteMapping("/{planId}/routes")
	public ResponseEntity<?> updateRoute(@PathVariable("planId") String planId){
		try {
			planService.deleteRoute(planId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	/* 메모 추가/변경/삭제 */
	@PutMapping("/{planId}/routes/{attractionId}/memo")
	public ResponseEntity<?> updateMemo(@PathVariable("planId") String planId,
									@PathVariable("attractionId") String attractionId,
									@RequestBody Map<String, Object> data){
		try {
			data.put("planId", planId);
			data.put("attractionId", attractionId);
			planService.updateMemo(data);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	/* 방문 시간 추가/변경/삭제 */
	@PutMapping("/{planId}/routes/{attractionId}/time")
	public ResponseEntity<?> updateVisitTime(@PathVariable("planId") String planId,
									@PathVariable("attractionId") String attractionId,
									@RequestBody Map<String, Object> data){
		try {
			data.put("planId", planId);
			data.put("attractionId", attractionId);
			planService.updateVisitTime(data);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	
	@PostMapping("/{planId}/partners")
	public ResponseEntity<?> addPartners(@PathVariable("planId") String planId,
										@RequestBody Map<String, Object> data) {
		try {
			data.put("planId", planId);
			planService.addPartner(data);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
