package com.mcworkshop.example;

import com.mcworkshop.example.util.SecurityUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringSecurityDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDemoApplication.class, args);
	}
}

@RestController
@RequestMapping("/api")
class DemoRestController {
	@GetMapping("/hello")
	@PreAuthorize("hasRole('ADMIN')")
	public String greeting() {
		return "Hello " + SecurityUtils.getCurrentUser();
	}

	@GetMapping("/public/api")
	public String publicAPI() {
		return "this is public API";
	}
}