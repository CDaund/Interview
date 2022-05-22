
Create Database Test;

CREATE table StudentRegistration (
	ID int NOT NULL AUTO_INCREMENT,
	FirstName Varchar(750),
    LastName varchar(750),
    MobileNo int,
    ResponseAnswer varchar(255),
    LogInDateTime date,
    OTP int DEFAULT 000000,
    PRIMARY KEY (StudentID)
);

CREATE table SelectSubject (
	ID int NOT NULL AUTO_INCREMENT,
    SubjectName varchar(500),
    PRIMARY KEY (ID)
);

Create table final(
	ID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    StudentID int NOT NULL,
	SubjectID int NOT NULL,
	ResponseAnswer varchar(250),
    CorrectAnswer varchar(250)
);



