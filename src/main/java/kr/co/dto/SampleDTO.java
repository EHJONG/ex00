package kr.co.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SampleDTO {
	
	private String title;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dueDate;
	
}
