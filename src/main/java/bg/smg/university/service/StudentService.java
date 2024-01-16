package bg.smg.university.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.smg.university.model.Subject;
import bg.smg.university.repository.SubjectRepository;

@Service
public class StudentService {
	
	@Autowired
	private SubjectRepository subjectRepository;

	public List<Subject> getSubjectsList(String username) {
		List<Subject> subjects = subjectRepository.getAll();
				
		/*
		 * subjects.add(new SubjectTableViewModel("Linear algebra")); subjects.add(new
		 * SubjectTableViewModel("Mechanics Part 1"));
		 */
		
		return subjects;
	}
}
