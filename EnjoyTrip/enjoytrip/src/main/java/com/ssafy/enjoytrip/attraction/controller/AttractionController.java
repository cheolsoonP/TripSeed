package com.ssafy.enjoytrip.attraction.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.attraction.dto.AttractionDto;
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
	
	@GetMapping("")
	public ResponseEntity<?> getAttractionList(@RequestParam(value = "sido", required = false) Integer sidoCode, 
												@RequestParam(value = "gugun", required = false) Integer gugunCode,
												@RequestParam(value = "contentType", required = false) Integer contentTypeId,
												@RequestParam(value = "keyword", required = false) String keyword){
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("sidoCode", sidoCode);
			map.put("gugunCode", gugunCode);
			map.put("contentTypeId", contentTypeId);
			map.put("keyword", keyword);			
			List<AttractionDto> attractionList = attractionService.getAttractionList(map);
			return new ResponseEntity<List<AttractionDto>>(attractionList, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
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
	
	@GetMapping("/sido/{sidoCode}/gugun")
	public ResponseEntity<?> getGugunList(@PathVariable("sidoCode") String sidoCode){
		try {
			List<GugunDto> gugunList = attractionService.getGugunList(sidoCode);
			return new ResponseEntity<List<GugunDto>>(gugunList, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	
	@GetMapping("/hotplace")
	public ResponseEntity<?> getHotplaceList(@RequestParam(value = "sido", required = false) Integer sidoCode, 
												@RequestParam(value = "gugun", required = false) Integer gugunCode,
												@RequestParam(value = "limit", required = false) Integer limit,
												@RequestParam(value = "keyword", required = false) String keyword){
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("sidoCode", sidoCode);
			map.put("gugunCode", gugunCode);
			map.put("limit", limit);
			map.put("keyword", keyword);	
			List<AttractionDto> hotPlaceList = attractionService.getHotplaceList(map);
			return new ResponseEntity<List<AttractionDto>>(hotPlaceList, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	

	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
