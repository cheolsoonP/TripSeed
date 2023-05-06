package com.ssafy.enjoytrip.board.service;

import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.board.dto.BoardDto;
import com.ssafy.enjoytrip.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	private BoardMapper boardMapper;
	
	
	public BoardServiceImpl(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}


	@Override
	public void writePost(BoardDto boardDto) throws Exception {
		boardMapper.writePost(boardDto);
	}
	

}
