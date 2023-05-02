package com.ssafy.enjoytrip.attraction.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.attraction.dto.GugunDto;
import com.ssafy.enjoytrip.attraction.dto.SidoDto;
import com.ssafy.enjoytrip.attraction.service.AttractionService;

@RestController
@RequestMapping("/attractions")
@CrossOrigin("*")
public class AttractionController {
	
	private AttractionService attractionService;
	
	@Autowired
	public AttractionController(AttractionService attractionService) {
		this.attractionService = attractionService;
	}
	
	@GetMapping("/sido")
	public ResponseEntity<?> getSidoList(){
		try {
			List<SidoDto> sidoList = attractionService.getSidoList();
			return new ResponseEntity<List<SidoDto>>(sidoList, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	@GetMapping("/gugun")
	public ResponseEntity<?> getGugunList(){
		try {
			List<GugunDto> gugunList = attractionService.getGugunList();
			return new ResponseEntity<List<GugunDto>>(gugunList, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	
//	@GetMapping("/{sidoCode}")
//	public ResponseEntity<?> getAttractionList(@RequestAttribute ) {
//		
//		try {
//			attractionService.addPlan(planDto);
//			return new ResponseEntity<Void>(HttpStatus.OK);
//		} catch (Exception e) {
//			return exceptionHandling(e);
//		}
//	}
	

	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
