package com.coe.andaman.rs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@GetMapping("/appname")
	public String getAppName()
	{
		return "RS App....";
	}
	@GetMapping("/login")
	public String getLogin()
	{
		return "RS App Login....";
	}
}
