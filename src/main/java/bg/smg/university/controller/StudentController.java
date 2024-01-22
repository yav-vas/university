package bg.smg.university.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bg.smg.university.model.Subject;
import bg.smg.university.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/subjects")
	public String subjects(Model model, Principal principal) {
		String usernameLoggedIn = principal.getName();
		model.addAttribute("subjects", studentService.getSubjectsList(usernameLoggedIn));
		return "subjects";
	}
	
	@GetMapping("/subject-sign-up")
	public String signUpForSubjectsGet(Model model, Principal principal) {
		String usernameLoggedIn = principal.getName();
		List<Subject> subjects_not_signed_up_for = studentService.getSubjectsNotSignedUpFor(usernameLoggedIn);
		model.addAttribute("subjects_not_signed_up_for", subjects_not_signed_up_for);
		return "subject-sign-up";
	}
	
	@PostMapping("/subject-sign-up")
	public String signUpForSubjectsPost(@RequestParam("subject-id") Integer subject_id, Principal principal) {
		String usernameLoggedIn = principal.getName();
		studentService.signUpStudentForASubject(usernameLoggedIn, subject_id);
		return "redirect:/?successfulSignUpForSubject";
	}
}
