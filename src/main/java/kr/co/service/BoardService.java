package kr.co.service;

import java.util.List;

import kr.co.domain.BoardVO;

public interface BoardService {

	public void register(BoardVO board);
	
	public BoardVO get(int bno);
	
	public List<BoardVO> getList();
	
	public boolean modify(BoardVO board);
	
	public boolean remove(int bno);
	
}
