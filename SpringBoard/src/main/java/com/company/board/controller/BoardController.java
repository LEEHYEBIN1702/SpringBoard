package com.company.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.board.service.BoardVO;
import com.company.board.service.ReplyVO;
import com.company.board.service.impl.BoardMapper;

@Controller
public class BoardController {

	@Autowired
	BoardMapper boardMapper;

	// 전체조회
	@RequestMapping("/getBoardList")
	public String getBoardList(Model model) {
		model.addAttribute("list", boardMapper.getBoardList());
		return "board/getBoardList";

	}

	// 단건조회
	@RequestMapping("/getBoard")
	public String getBoard(Model model, BoardVO vo) {
		model.addAttribute("board", boardMapper.getBoard(vo));
		return "board/getBoard";

	}
	
	//댓글조회
	@RequestMapping("/getReplyList")
	@ResponseBody
	public List<ReplyVO> getReplyList(ReplyVO vo) {
		return boardMapper.getReplyList(vo);
	}
	

	//댓글등록
	@RequestMapping("/insertReply")
	@ResponseBody
	public ReplyVO insertReply(ReplyVO vo) {
		boardMapper.insertReply(vo);
		return vo;
	}

}
