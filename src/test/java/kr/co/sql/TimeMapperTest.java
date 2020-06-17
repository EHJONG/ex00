package kr.co.sql;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.mapper.TimeMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
public class TimeMapperTest {
	
	@Setter(onMethod_ = @Autowired)
	private TimeMapper mapper;
	
//	@Test
	public void testGetTime() {		
		log.info("0-0000");
		log.info(mapper.getClass().getName());		
		log.info(mapper.getTime());
		log.info("12313");
	}
	
	@Test
	public void testGetTime2() {
		log.info("success!");
		log.info(mapper.getClass().getName());
		log.info(mapper.getTime2());
		log.info("0-000--");
	}
}
