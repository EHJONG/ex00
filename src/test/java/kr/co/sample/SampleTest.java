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

// @ContextConfiguration은 지정된 클래스나 문자열을 이용해서 필요한 객체들을 스프링 내에 객체로 등록하게 된다. ( 쉽게 말해, 스프링의 빈으로 등록 된다고 표현 한다 )
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

@Log4j
public class SampleTest {
	@Setter(onMethod_ = @Autowired)
	private Restaurant res;

	@Test
	public void testExist() {
//		assertNotNull()은 파라미터 안에 있는 변수가 null이 아니어야만 테스트가 성공한다는 것을 의미한다.
		assertNotNull(res);
		log.info(res);
		log.info("-0---");
		log.info(res.getChef());
	}

}
