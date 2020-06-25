package kr.co.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.domain.BoardVO;
import kr.co.mapper.BoardMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

// @Service는 계층 구조상 주로 비즈니스 영역을 담당하는 객체임을 표시하기 위해 사용한다.
//@Service
@Repository
@AllArgsConstructor
@Log4j
public class BoardServiceImpl implements BoardService {
	
//	@Autowired
	private BoardMapper mapper;

	@Override
	public BoardVO get(int bno) {
	log.info("bno...."+bno);
		return mapper.read(bno);
	}

	@Override
	public List<BoardVO> getList() {
		log.info("get list..");
		return mapper.getList(); 
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify : "+board);
		return mapper.update(board)==true;
	}

	@Override
	public void register(BoardVO board) {
		System.out.println("register called");
		mapper.insert(board);
	}

	@Override
	public boolean remove(int bno) {
		log.info("delete bno : "+bno);
		return mapper.delete(bno);
	}
	
}
