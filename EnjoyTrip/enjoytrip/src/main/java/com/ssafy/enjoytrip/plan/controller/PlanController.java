package com.ssafy.enjoytrip.plan.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.plan.dto.PlanDto;
import com.ssafy.enjoytrip.plan.service.PlanService;

@RestController("/plans")
@CrossOrigin("*")
public class PlanController {
	
	private PlanService planService;
	
	@Autowired
	public PlanController(PlanService planService) {
		this.planService = planService;
	}
	
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
	public ResponseEntity<?> getPlanList(@PathVariable("planid") String planId, HttpSession session){
		session.setAttribute("userId", "ssafy");
		try {
			planService.deletePlan(planId);
			List<PlanDto> planList = planService.getPlanList((String) session.getAttribute("userId"));
			
			if(planList != null)
				return new ResponseEntity<List<PlanDto>>(planList, HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@PutMapping("/plan")
	public ResponseEntity<?> updatePlan(PlanDto planDto, HttpSession session){
		session.setAttribute("userId", "ssafy");
		try {
			System.out.println(planDto);
			planService.updatePlan(planDto);
			List<PlanDto> planList = planService.getPlanList((String) session.getAttribute("userId"));
			
			if(planList != null)
				return new ResponseEntity<List<PlanDto>>(planList, HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
//	@GetMapping("/{planid}")
//	@DeleteMapping("/{planid}")
	
	
	
	
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
