package com.ssafy.enjoytrip.board.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.board.dto.BoardDto;

@Mapper
public interface BoardMapper {

	void writePost(BoardDto boardDto) throws SQLException;

}
