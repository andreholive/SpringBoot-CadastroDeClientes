package com.betha.system.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	@RequestMapping(method = RequestMethod.GET, value = {"/index"} )
	public String index(){
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = {"/client/detail/**", "/client/create"} )
	public String main(){
		return "index";
	}
}
