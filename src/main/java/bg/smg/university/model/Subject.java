package bg.smg.university.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("subject")
public class Subject {

	private @Id int id;
	private String name;
	
	public Subject(SubjectRegisterModel subject) {
		setName(subject.getName());
	}
}
