package com.ssafy.enjoytrip.plan.controller;

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
	public ResponseEntity<?> addPlan(PlanDto planDto) {
		
		try {
			planService.addPlan(planDto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/{userid}")
	public ResponseEntity<?> getPlanList(@PathVariable("userid") String userId){
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
	
	@DeleteMapping("/{planid}")
	public ResponseEntity<?> deletePlan(@PathVariable("planid") String planId){
		
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
	public ResponseEntity<?> updatePlan(PlanDto planDto){
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
	
	@GetMapping("/{planid}")
	public ResponseEntity<?> getPlan(@PathVariable("planid") String planId){
		
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
	@PostMapping("/{planid}/routes")
	public ResponseEntity<?> addRoute(@PathVariable("planid") String planId, @RequestBody Map<String, Object> param){
		try {
			List<Map<String, Object>> routes = (List<Map<String, Object>>) param.get("routes");
			planService.addRoute(planId, routes);
				return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	/* 여행 경로 조회 */
	@GetMapping("/{planid}/routes")
	public ResponseEntity<?> getRoute(@PathVariable("planid") String planId){
		try {
			List<RouteDto> routeList = planService.getRoute(planId);
				return new ResponseEntity<List<RouteDto>>(routeList, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
