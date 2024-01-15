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
	name VARCHAR(255)
);