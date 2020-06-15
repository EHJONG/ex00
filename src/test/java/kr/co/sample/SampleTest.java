package kr.co.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

// 테스트 코드는 현재 테스트 코드가 스프링을 실행하는 역할을 할 것이라는 것을 @RunWith 어노테이션으로 표시한다.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTest {
	@Setter(onMethod_ = @Autowired)
	private Restaurant res;
	
	@Test
	public void testExist() {
		assertNotNull(res);
		log.info(res);
		log.info("-0---");
		log.info(res.getChef());
		
	}
}
