package kr.co.sql;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
public class DataSourceTest {
	
	@Setter(onMethod_ = @Autowired)
	private DataSource data;
	
	@Setter(onMethod_ = @Autowired)
	private SqlSessionFactory sqlSessionFactory;
	
//	@Test
	public void testConnection() {
		try {
			Connection conn = data.getConnection();
			log.info("con : "+conn);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	@Test
	public void testMyBatis() {
		try {
			SqlSession session = sqlSessionFactory.openSession();
			Connection conn = session.getConnection();
			log.info("success!");
			log.info("session : "+session);
			log.info("con : "+conn);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
