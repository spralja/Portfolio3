DROP TABLE IF EXISTS Students;

CREATE TABLE IF NOT EXISTS Students (
                                        Name TEXT,
                                        Address TEXT,
                                        StudentNumber INTEGER,
                                        PRIMARY KEY (StudentNumber)
    );

DROP TABLE IF EXISTS Courses;

CREATE TABLE IF NOT EXISTS Courses (
                                       Name TEXT,
                                       Year INTEGER,
                                       Semester TEXT,
                                       Teacher TEXT,
                                       PRIMARY KEY (Name, Year, Semester)
    );

DROP TABLE IF EXISTS Registrations;

CREATE TABLE IF NOT EXISTS Registrations (
                                             StudentStudentNumber INTEGER,
                                             CourseName TEXT,
                                             CourseYear INTEGER,
                                             CourseSemester TEXT,
                                             Grade INTEGER,
                                             FOREIGN KEY (StudentStudentNumber) REFERENCES Students (StudentNumber)
    ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (CourseName, CourseYear, CourseSemester)
    REFERENCES Courses (Name, Year, Semester)
    ON UPDATE CASCADE ON DELETE RESTRICT
    );

/*
INSERT INTO Courses (Name, Year, Semester, Teacher)
VALUES ('SD', 2019, 'autumn', 'Line');

INSERT INTO Courses (Name, Year, Semester, Teacher)
VALUES ('SD', 2020, 'spring', 'Line');

INSERT INTO Courses (Name, Year, Semester, Teacher)
VALUES ('ES1', 2019, 'autumn', 'Ebbe');

INSERT INTO Students (Name, Address, StudentNumber)
VALUES ('Lukas Rasocha', 'Universitetsparken 1D 4000 Roskilde Denmark', 0);

INSERT INTO Students (Name, Address, StudentNumber)
VALUES ('Vincent Elis', 'Universitetsparken 1C 4000 Roskilde Denmark', 1);

INSERT INTO Registrations
(StudentStudentNumber, CourseName, CourseYear, CourseSemester, Grade)
VALUES (0, 'SD', 2019, 'autumn', 10);

INSERT INTO Registrations
(StudentStudentNumber, CourseName, CourseYear, CourseSemester, Grade)
VALUES (0, 'ES1', 2019, 'autumn', 10);

INSERT INTO Registrations
(StudentStudentNumber, CourseName, CourseYear, CourseSemester, Grade)
VALUES (1, 'SD', 2020, 'spring', 12);

 */