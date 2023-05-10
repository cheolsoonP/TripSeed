package com.ssafy.enjoytrip.attraction.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.attraction.dto.AttractionDto;
import com.ssafy.enjoytrip.attraction.dto.GugunDto;
import com.ssafy.enjoytrip.attraction.dto.SidoDto;

@Mapper
public interface AttractionMapper {

	List<SidoDto> getSidoList() throws SQLException;
	List<GugunDto> getGugunList(String sidoCode) throws SQLException;
	List<AttractionDto> getAttractionList(Map<String, Object> map) throws SQLException;
	List<AttractionDto> getHotplaceList(Map<String, Object> map) throws SQLException;
}
