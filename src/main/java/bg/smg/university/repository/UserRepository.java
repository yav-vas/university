package bg.smg.university.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import bg.smg.university.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, String> {
	
	User findByUsername(String username);
}
