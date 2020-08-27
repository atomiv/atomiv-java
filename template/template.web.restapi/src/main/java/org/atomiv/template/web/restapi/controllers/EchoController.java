package org.atomiv.template.web.restapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EchoController {

	@GetMapping("/echo")
	public ResponseEntity<?> echo() {
		return ResponseEntity.ok().build();
	}
}