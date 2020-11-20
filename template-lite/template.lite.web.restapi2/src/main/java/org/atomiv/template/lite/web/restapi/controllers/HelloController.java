package org.atomiv.template.lite.web.restapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Hello to this app!";
	}
}