package com.ssafy.enjoytrip.attraction.service;

import java.util.List;

import com.ssafy.enjoytrip.attraction.dto.GugunDto;
import com.ssafy.enjoytrip.attraction.dto.SidoDto;


public interface AttractionService {

	List<SidoDto> getSidoList() throws Exception;

	List<GugunDto> getGugunList() throws Exception;

}
