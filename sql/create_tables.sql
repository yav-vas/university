-- Create user table

CREATE TABLE user (
	id PRIMARY KEY INT NOT NULL AUTO_INCREMENT,
	email VARCHAR(255),
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	country VARCHAR(50),
	address VARCHAR(255),
	username VARCHAR(50),
	password VARCHAR(255),
	authority VARCHAR(15),
	enabled BOOL,
	expired BOOL,
	locked BOOL
);

-- Create subject table

CREATE TABLE subject (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255),
	teacher_id INT,
	FOREIGN KEY (teacher_id) REFERENCES user(id)
);

-- Create student_subject table

CREATE TABLE student_subject (
	student_id INT NOT NULL,
	subject_id INT NOT NULL,
	PRIMARY KEY (student_id, subject_id),
	FOREIGN KEY (student_id) REFERENCES user(id),
	FOREIGN KEY (subject_id) REFERENCES subject(id)
);