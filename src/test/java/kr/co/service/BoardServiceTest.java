package kr.co.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.domain.BoardVO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceTest {

	@Autowired
	private BoardService service;

//	@Test
	public void testExist() {
		assertNotNull(service);
		log.info("service : " + service);
	}

//	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		service.register(board);
		log.info("success : " + board.getBno());
	}

//	@Test
	public void testGetList() {
//		service.getList().forEach(i->log.info(i)); 는 코드 그대로 모든 리스트를 가져온다. 
		service.getList().forEach(i -> log.info(i));
		log.info("success");
	}

//	@Test
	public void testGet() {
		if (service.get(3)==null) {
			log.info("null 사랑하지 않아..,");
		} else {
			log.info(service.get(3));
			System.out.println("3 : " + service.get(3));
		}
	}
	
//	@Test
	public void testUpdate() {
		BoardVO board = service.get(3);
		if(board==null) {
			log.info("null");
			return;
		}
		board.setTitle("바뀐 타이틀");
		board.setContent("바뀐 내용");
		service.modify(board);
		log.info(board);
	}
	
	@Test
	public void testDelete() {
		service.remove(3);
		log.info("success");
	}
}
