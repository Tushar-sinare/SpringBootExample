package com.app.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/admin")
public class RestController {
@GetMapping("/show")
public String helloMSGGet() {
	return "Hello Msg Get";	
}
@PostMapping("/view")
public String helloMSGPost() {
	return "Hello Msg Post";
}
@PutMapping("/puts")
public String helloMSGPut() {
	return "Hello Msg Put";
}
@DeleteMapping("/delete")
public String helloMSGDelete() {
	return "Hello Msg Delete";
}
@PatchMapping("/patchs")
public String helloMSGPatch() {
	return "Hello Msg PATCH";
}

}
