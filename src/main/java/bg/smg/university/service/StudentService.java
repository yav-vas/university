package bg.smg.university.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import bg.smg.university.model.SubjectTableViewModel;

@Service
public class StudentService {

	public static List<SubjectTableViewModel> getSubjectsList(String username) {
		List<SubjectTableViewModel> subjects = new LinkedList<SubjectTableViewModel>();
				
		subjects.add(new SubjectTableViewModel("Linear algebra"));
		subjects.add(new SubjectTableViewModel("Mechanics Part 1"));
		
		return subjects;
	}
}
