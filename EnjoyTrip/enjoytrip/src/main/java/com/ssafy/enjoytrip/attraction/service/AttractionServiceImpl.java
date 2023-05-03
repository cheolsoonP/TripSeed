package com.ssafy.enjoytrip.attraction.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.attraction.dto.AttractionDto;
import com.ssafy.enjoytrip.attraction.dto.GugunDto;
import com.ssafy.enjoytrip.attraction.dto.SidoDto;
import com.ssafy.enjoytrip.attraction.mapper.AttractionMapper;

@Service
public class AttractionServiceImpl implements AttractionService {

	private AttractionMapper attractionMapper;
	
	public AttractionServiceImpl(AttractionMapper attractionMapper) {
		this.attractionMapper = attractionMapper;
	}

	@Override
	public List<SidoDto> getSidoList() throws Exception {
		return attractionMapper.getSidoList();
	}

	@Override
	public List<GugunDto> getGugunList() throws Exception {
		return attractionMapper.getGugunList();
	}

	@Override
	public List<AttractionDto> getAttractionList(Map<String, Object> map) throws Exception {
		return attractionMapper.getAttractionList(map);
	}

	@Override
	public List<AttractionDto> getHotplaceList(Map<String, Object> map) throws Exception {
		return attractionMapper.getHotplaceList(map);
	}
	

}
