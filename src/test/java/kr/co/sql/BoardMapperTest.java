package kr.co.sql;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.domain.BoardVO;
import kr.co.mapper.BoardMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTest {
	
//	@Setter(onMethod_ = @Autowired)
	@Autowired
	private BoardMapper mapper;
	
//	@Test
	public void testGetList() {
		log.info("됐쮸");
	}
	
//	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		mapper.insert(board);
		log.info(board);
	}
	
//	@Test
	public void testRead() {
		log.info("1");
		BoardVO board = mapper.read(2);
		log.info(board);
	}
	
	
//	@Test
	public void testDelete() {
		mapper.delete(2);
		log.info("successz");
	}
	
	
//	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(3);
		board.setTitle("수정된 타이틀2");
		board.setContent("수정된 내용2");
		board.setWriter("수정된 작성자2");
		mapper.update(board);
		log.info("수정됨");
	}
	
}
