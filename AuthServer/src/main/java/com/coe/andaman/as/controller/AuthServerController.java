package com.coe.andaman.as.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class AuthServerController {

@GetMapping("/user")
public Principal getUser(Principal ps)
 {
	 return ps;
 }
	
}
