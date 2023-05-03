package com.ssafy.enjoytrip.attraction.service;

import java.util.List;
import java.util.Map;

import com.ssafy.enjoytrip.attraction.dto.AttractionDto;
import com.ssafy.enjoytrip.attraction.dto.GugunDto;
import com.ssafy.enjoytrip.attraction.dto.SidoDto;


public interface AttractionService {

	List<SidoDto> getSidoList() throws Exception;

	List<GugunDto> getGugunList() throws Exception;

	List<AttractionDto> getAttractionList(Map<String, Object> map) throws Exception;

	List<AttractionDto> getHotplaceList(Map<String, Object> map) throws Exception;

}
