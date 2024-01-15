package bg.smg.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import bg.smg.university.model.StudentRegisterModel;

@Controller
public class RegisterController {

	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/register")
	public String register(StudentRegisterModel student) {
		System.out.println(student.toString());
		return "redirect:/?successfulRegistration";
	}
}
