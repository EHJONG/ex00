package kr.co.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TimeMapper {

	@Select("SELECT now()")
	public String getTime();
	
	public String getTime2();
}
