package bg.smg.university.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.smg.university.model.Subject;
import bg.smg.university.repository.SubjectRepository;
import bg.smg.university.repository.UserRepository;

@Service
public class StudentService {
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private UserRepository userRepository;

	public List<Subject> getSubjectsList(String username) {
		List<Subject> subjects = subjectRepository.getSubjectsByUsername(username);
				
		/*
		 * subjects.add(new SubjectTableViewModel("Linear algebra")); subjects.add(new
		 * SubjectTableViewModel("Mechanics Part 1"));
		 */
		
		return subjects;
	}
	
	public List<Subject> getSubjectsNotSignedUpFor(String username) {
		List<Subject> subjects = subjectRepository.getSubjectsAUsernameIsNotSignedFor(username);
		return subjects;
	}

	public void signUpStudentForASubject(String username, int subject_id) {
		subjectRepository.addSubjectForAStudent(userRepository.findByUsername(username).getId(), subject_id);
		
	}
}
