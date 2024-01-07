package bg.smg.university.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("test_attribute", "A welcome message!");
		model.addAttribute("authenticated_name", SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		return "home";
	}
	
}
