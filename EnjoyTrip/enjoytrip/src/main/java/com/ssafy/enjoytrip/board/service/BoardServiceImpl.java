package com.ssafy.enjoytrip.board.service;

import java.util.List;
import java.util.Map;

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


	@Override
	public List<BoardDto> getPostList(Map<String, Object> map) throws Exception {
		return boardMapper.getPostList(map);
	}


	@Override
	public BoardDto getPost(String postId) throws Exception {
		return boardMapper.getPost(postId);
	}


	@Override
	public void updatePost(BoardDto boardDto) throws Exception {
		boardMapper.updatePost(boardDto);
	}
	

}
