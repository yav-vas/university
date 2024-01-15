package bg.smg.university.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import bg.smg.university.service.StudentService;

@Controller
public class StudentController {
	
	@GetMapping("/subjects")
	public String subjects(Model model) {
		model.addAttribute("subjects", StudentService.getSubjectsList(SecurityContextHolder.getContext().getAuthentication().getName()));
		return "subjects";
	}
}
