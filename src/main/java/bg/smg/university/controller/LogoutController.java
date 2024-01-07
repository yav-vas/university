package bg.smg.university.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import bg.smg.university.model.User;

@Controller
public class LogoutController {

	@GetMapping("/logout")
	public String home(Model model) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("firstName", user.getFirstName());
		model.addAttribute("lastName", user.getLastName());
		model.addAttribute("username", user.getUsername());
		return "logout";
	}
	
}
