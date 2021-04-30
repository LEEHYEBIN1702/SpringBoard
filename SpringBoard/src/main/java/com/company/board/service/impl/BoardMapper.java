package com.company.board.service.impl;

import java.util.List;


import com.company.board.service.BoardVO;
import com.company.board.service.ReplyVO;

public interface BoardMapper { // board_Mapper과 짝으로 비교해서 적기
	//게시글
	public List<BoardVO> getBoardList(); // 얘는 파라미터 타입이 없기 때문에 안 적어줘도 됨. 그리고 결과가 여러건이기 때문에 List로 묶어줘야 함
	public BoardVO getBoard(BoardVO vo); // 파라미터 타입이 있기 때문에 적어줘야 함.
	
	//댓글
	public List<ReplyVO> getReplyList(ReplyVO vo);
	public int insertReply(ReplyVO vo);

}
