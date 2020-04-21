package com.example.cucumberhello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping(value = "/hello")
    public String hello() {
        return "coronavirus sucks";
    }
	
	 @GetMapping(value = "/hello1")
	 public ResponseEntity<String> getDirectDebit() {
	     return new ResponseEntity("hello", HttpStatus.OK);
	     
	 }
}
