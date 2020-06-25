package kr.co.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.dto.DTO;
import kr.co.dto.SampleDTO;
import lombok.extern.log4j.Log4j;

@RequestMapping("/sample/*")
@Controller
@Log4j
public class SampleController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat formate= new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(formate, false));
	}
	
	@GetMapping("ex00")
	public String ex00(SampleDTO dto, Model model) {
		System.out.println("dto : "+dto);
		model.addAttribute("time", new java.util.Date());
		return "ex00";
	}
	
	@GetMapping("/ex04")
	public String ex04(@ModelAttribute DTO dto, @ModelAttribute("page")int page, RedirectAttributes redirect, @ModelAttribute("re")int re) {
		redirect.addAttribute("re",re);
		System.out.println("dto : "+dto);
		System.out.println("page : "+page);
		return "/sample/ex04";
	}
	
	@GetMapping("ex06")
	public @ResponseBody DTO ex06() {
		log.info("------");
		DTO dto = new DTO();
		dto.setAge(20);
		dto.setName("tj");
		dto.setPage(10);
		return dto;
	}
	
	@GetMapping("exUpload")
	public void exUpload() {
		System.out.println("exload");
		log.info("exload");
	}
	
	@GetMapping("ex07")
	public ResponseEntity<String> ex07(){
		String msg = "{\"name\" : \"홍길동\"}";
		HttpHeaders header = new HttpHeaders();
		System.out.println("header : "+header);
		header.add("content-type", "application/json;charset=UTF-8");
		return new ResponseEntity<>(msg, header,HttpStatus.OK);
	}
	
	@PostMapping("exUploadPost")
	public ModelAndView exUploadPost(ArrayList<MultipartFile> files) {
		System.out.println("sample/exuploadpost");
		ModelAndView mv = new ModelAndView("/sample/exUploadPost");
		files.forEach(file->{
			log.info("--0--");
			log.info("name : "+file.getOriginalFilename());
			log.info("size : "+file.getSize());
			
			System.out.println("-=-");
			System.out.println("name : "+file.getOriginalFilename());
			System.out.println("size : "+file.getSize());
		});
		return mv;
	}
}
