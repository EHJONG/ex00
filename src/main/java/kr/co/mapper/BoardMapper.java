package kr.co.mapper;

import java.util.List;

import kr.co.domain.BoardVO;

public interface BoardMapper {
	
//	@Select("SELECT * FROM tbl_board WHERE bno > 0")
	public List<BoardVO> getList();
	
//	게시글 삽입
	public void insert(BoardVO board);
	
//	얘는 도대체 뭘까....selectKey
	public void insertSelectKey(BoardVO board);
	
//	하나의 게시글 read 역할 
	public BoardVO read(int bno);
	
//	하나의 게시글 delete 역할
	public boolean delete(int bno);
	
//	update
	public boolean update(BoardVO board);

}
