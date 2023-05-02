package com.ssafy.enjoytrip.attraction.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
	

}
