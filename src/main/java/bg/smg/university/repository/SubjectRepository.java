package bg.smg.university.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import bg.smg.university.model.Subject;

@Repository
public interface SubjectRepository extends PagingAndSortingRepository<Subject, Integer>, CrudRepository<Subject, Integer> {

	@Query("SELECT * FROM subject")
	List<Subject> getAll();
	
	@Query("SELECT s.id, s.name FROM user AS u, student_subject AS ss, subject AS s "
			+ "WHERE u.id = ss.student_id AND s.id = ss.subject_id AND u.username = :username")
	List<Subject> getSubjectsByUsername(String username);
	
	@Query("SELECT subject.id, subject.name FROM subject WHERE subject.id NOT IN "
			+ "(SELECT ss.subject_id FROM student_subject AS ss, user AS u "
			+ "WHERE u.id = ss.student_id AND u.username = :username)")
	List<Subject> getSubjectsAUsernameIsNotSignedFor(String username);
	
	Subject save(Subject subject);

	@Query("INSERT INTO student_subject VALUES (:user_id, :subject_id)")
	void addSubjectForAStudent(int user_id, int subject_id);

}
