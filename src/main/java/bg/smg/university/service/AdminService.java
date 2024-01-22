package bg.smg.university.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import bg.smg.university.model.Roles;
import bg.smg.university.model.Subject;
import bg.smg.university.model.SubjectRegisterModel;
import bg.smg.university.model.User;
import bg.smg.university.repository.SubjectRepository;

@Service
public class AdminService {

	@Autowired
	private SubjectRepository subjectRepository;
	
	public Subject addNewSubject(SubjectRegisterModel subjectModel) {
		User loggedInUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (loggedInUser == null || loggedInUser.getAuthority() != Roles.ADMIN) {
			throw new AccessDeniedException("Not authorized");
		}
		Subject subject = new Subject(subjectModel);
		return subjectRepository.save(subject);
	}
}
