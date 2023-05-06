package com.ssafy.enjoytrip.board.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.board.dto.BoardDto;

@Mapper
public interface BoardMapper {

	void writePost(BoardDto boardDto) throws SQLException;

	List<BoardDto> getPostList(Map<String, Object> map) throws SQLException;

}
