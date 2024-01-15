package bg.smg.university.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import bg.smg.university.model.Subject;

public interface SubjectRepository extends PagingAndSortingRepository<Subject, Integer> {

	@Query("SELECT * FROM subject")
	List<Subject> getAll();

}
