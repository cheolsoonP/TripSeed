package com.ssafy.enjoytrip.attraction.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest()
class AttractionServiceImplTest {
	private Logger log = LoggerFactory.getLogger(AttractionServiceImplTest.class);

	@Autowired
	AttractionService attractionService;
	
	@Test
	@DisplayName("시도 리스트 불러오기 테스트")
	void testGetSidoList() {
		try {
			attractionService.getSidoList();
		} catch (Exception e) {
			fail("시도 리스트 불러오기 실패");
		}	
	}

	@Test
	@DisplayName("구군 리스트 불러오기 테스트")
	void testGetGugunList() {
		try {
			attractionService.getGugunList("1");
		} catch (Exception e) {
			fail("구군 리스트 불러오기 실패");
		}	
	}

	@Test
	@DisplayName("관광지 리스트 전체 불러오기 테스트")
	void testGetAttractionList() {
		try {
			Map<String, Object> map = new HashMap<>();
			attractionService.getAttractionList(map);
		} catch (Exception e) {
			fail("관광지 전체 리스트 불러오기 실패");
		}		
	}
	
	@Test
	@DisplayName("관광지 시도별 리스트 불러오기 테스트")
	void testGetAttractionListSido() {
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("sidoCode", 1);
			attractionService.getAttractionList(map);
		} catch (Exception e) {
			fail("관광지 시도별 리스트 불러오기 실패");
		}		
	}
	
	@Test
	@DisplayName("관광지 구군별 리스트 불러오기 테스트")
	void testGetAttractionListGugun() {
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("sidoCode", 1);
			map.put("gugunCode", 2);
			attractionService.getAttractionList(map);
		} catch (Exception e) {
			fail("관광지 구군별 리스트 불러오기 실패");
		}		
	}
	
	@Test
	@DisplayName("관광지 검색어 조회 테스트")
	void testGetAttractionListKeyword() {
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("keyword", "계곡");
			attractionService.getAttractionList(map);
		} catch (Exception e) {
			fail("관광지 검색어 조회 실패");
		}		
	}

	@Test
	@DisplayName("핫플레이스 기본 조회 테스트")
	void testGetHotplaceList() {
		try {
			Map<String, Object> map = new HashMap<>();
			attractionService.getHotplaceList(map);
		} catch (Exception e) {
			fail("핫플 기본 조회 실패");
		}	
	}
	
	@Test
	@DisplayName("핫플레이스 시도 조회 테스트")
	void testGetHotplaceListSido() {
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("sidoCode", 1);
			attractionService.getHotplaceList(map);
		} catch (Exception e) {
			fail("핫플 시도 조회 실패");
		}	
	}
	
	@Test
	@DisplayName("핫플레이스 구군 조회 테스트")
	void testGetHotplaceListGugun() {
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("sidoCode", 1);
			map.put("gugunCode", 1);
			attractionService.getHotplaceList(map);
		} catch (Exception e) {
			fail("핫플 구군 조회 실패");
		}	
	}
	
	@Test
	@DisplayName("핫플레이스 키워드 조회 테스트")
	void testGetHotplaceListKeyword() {
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("keyword", "계곡");	
			attractionService.getHotplaceList(map);
		} catch (Exception e) {
			fail("핫플 키워드 조회 실패");
		}	
	}

}
