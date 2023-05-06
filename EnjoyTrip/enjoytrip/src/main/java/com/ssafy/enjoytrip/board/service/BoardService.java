package com.ssafy.enjoytrip.board.service;

import com.ssafy.enjoytrip.board.dto.BoardDto;

public interface BoardService {

	void writePost(BoardDto boardDto) throws Exception;

}
