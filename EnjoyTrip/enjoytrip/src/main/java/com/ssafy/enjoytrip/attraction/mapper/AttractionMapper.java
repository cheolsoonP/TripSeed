package com.ssafy.enjoytrip.attraction.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.attraction.dto.GugunDto;
import com.ssafy.enjoytrip.attraction.dto.SidoDto;

@Mapper
public interface AttractionMapper {

	List<SidoDto> getSidoList() throws SQLException;
	List<GugunDto> getGugunList() throws SQLException;
}
