package bg.smg.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import bg.smg.university.model.Roles;
import bg.smg.university.model.SubjectRegisterModel;
import bg.smg.university.model.User;
import bg.smg.university.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	@GetMapping("/add-subject")
	public String addSubjectGet(Model model) {
		User loggedInUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (loggedInUser == null || loggedInUser.getAuthority() != Roles.ADMIN)
			throw new AccessDeniedException("Not authorized");
		
		model.addAttribute("user_first_name", loggedInUser.getFirstName());
		return "add-subject";
	}
	
	@PostMapping("/add-subject")
	public String addSubjectPost(SubjectRegisterModel subject) {
		adminService.addNewSubject(subject);
		return "redirect:/?subjectAddSuccess";
	}
}
