package kr.co.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
/* @WebAppConfiguration은 Servlet의 ServletContext를 이요하기 위해서인데,
 * 스프링에서는 WebApplicationContext라는 존재를 이용하기 위해서이다.
 */
@WebAppConfiguration
public class BoardControllerTest {
	
	@Setter(onMethod_ = @Autowired)
	private WebApplicationContext ctx;
	
//	MockMvc는 말 그대로 "가짜 MVC"이다.
	private MockMvc mvc;

	@org.junit.Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		log.info("before");
	}
	
//	@Test
	public void testList() throws Exception {
//		MockMvcRequestBuilders라는 존재를 이용해서 GET방식의 호출을 한다.
		System.out.println(mvc.perform(MockMvcRequestBuilders.get("/board/list"))
				.andReturn().getModelAndView().getModelMap());
	}
	
//	@Test
	public void testRegister() throws Exception {
		String resultPage = mvc.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title", "테스트 새글").param("content", "테스트 내용").param("writer", "테스트 작성자")).andReturn()
				.getModelAndView().getViewName();
				log.info("resultPage : "+resultPage);
	}
	
	@Test
	public void testGet() throws Exception {
		log.info(mvc.perform(MockMvcRequestBuilders.get("/board/get")
				.param("bno", "4"))
				.andReturn().getModelAndView().getModelMap());
		log.info("된거야?");
	}
	
}
