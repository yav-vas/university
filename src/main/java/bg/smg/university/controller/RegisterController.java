package bg.smg.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import bg.smg.university.model.StudentRegisterModel;
import bg.smg.university.service.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	UserService userService;

	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/register")
	public String register(StudentRegisterModel student, BindingResult bindingResult) {
		// TODO: Differentiate between error types
		if (bindingResult.hasErrors()) {
			return "register";
		}
		
		
		userService.registerStudent(student);
		return "redirect:/?successfulRegistration";
	}
}
