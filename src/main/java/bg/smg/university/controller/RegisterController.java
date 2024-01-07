package bg.smg.university.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

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
