package bg.smg.university.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.smg.university.model.StudentRegisterModel;
import bg.smg.university.model.User;
import bg.smg.university.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	// TODO: add return type to know whether it was successful
	public void registerStudent(StudentRegisterModel student) {
		User user = new User(student);
		userRepository.save(user);
	}
}
