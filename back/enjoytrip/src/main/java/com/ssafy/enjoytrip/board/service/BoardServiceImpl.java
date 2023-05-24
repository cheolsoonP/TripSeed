package com.ssafy.enjoytrip.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.board.dto.BoardDto;
import com.ssafy.enjoytrip.board.dto.ReplyDto;
import com.ssafy.enjoytrip.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper boardMapper;
	
	@Autowired
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


	@Override
	public void deletePost(String postId) throws Exception {
		boardMapper.deletePost(postId);
	}


	@Override
	public List<BoardDto> getUserPostList(String userId) throws Exception {
		return boardMapper.getUserPostList(userId);
	}


	@Override
	public void writeReply(ReplyDto replyDto) throws Exception {
		boardMapper.writeReply(replyDto);
	}


	@Override
	public void deleteReply(String replyId) throws Exception {
		boardMapper.deleteReply(replyId);
	}


	@Override
	public void updateReply(ReplyDto replyDto) throws Exception {
		boardMapper.updateReply(replyDto);
	}


	@Override
	public List<ReplyDto> getReplyList(String postId) throws Exception {
		return 	boardMapper.getReplyList(postId);
	}
	

}
