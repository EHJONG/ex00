package kr.co.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.dto.SampleDTOList;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody String home(@RequestParam(value = "name", required= false)String name,
			@RequestParam(value = "age", required=false)int age) {
		return "home";
	}
	
	@RequestMapping(value = "home", method = RequestMethod.GET)
	@ResponseBody
	public String home2(@RequestParam(value = "idx", required= false)String[] idx) {
		System.out.println("idx.length : "+idx.length);
		for(int i =0; i<idx.length; i++) {
			System.out.println(idx[i]);
		}
		return "home2";
	}
	
	@GetMapping("array")
	@ResponseBody
	public String array(@RequestParam(value = "ids", required = false)ArrayList<String> ids) {
		System.out.println("ids.size() : "+ids.size());
		for(int i =0; i<ids.size(); i++) {
			System.out.println(ids.get(i));
		}
		return ids.get(0);
//		return "array";
	}
	
	@GetMapping("dto")
	@ResponseBody
	public String dto(@RequestBody(required = false)SampleDTOList list) {
		System.out.println("called");
		System.out.println("list : "+list);
		return "dto";
	}
	
	
}
