package bg.smg.university.controller;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import bg.smg.university.model.User;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
		if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ANONYMOUS"))) {
			model.addAttribute("test_attribute", "A welcome message!");
			model.addAttribute("not_logged_in", "Log in");
			return "home";
		}
		User loggedInUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("test_attribute", "Welcome, " + loggedInUser.getFirstName() + " " + loggedInUser.getLastName());
		if (loggedInUser != null) {
			switch (loggedInUser.getAuthority()) {
			case ADMIN:
				model.addAttribute("link_add_subject", "Add a new subject");
				break;
			case STUDENT:
				model.addAttribute("see_my_subjects", "See my subjects");
				model.addAttribute("sign_up_for_a_subject", "Sign up for a subject");
				break;
			default:
				break;
			}
		}
		return "home";
	}
	
}
