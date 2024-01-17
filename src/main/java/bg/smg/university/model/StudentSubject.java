package bg.smg.university.model;

import org.springframework.data.relational.core.mapping.Table;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("student_subject")
public class StudentSubject {

	private int studentId;
	private int subjectId;
	
}
