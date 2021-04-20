DROP TABLE IF EXISTS Students;
CREATE TABLE IF NOT EXISTS Students (
    Name TEXT NOT NULL,
    Address TEXT NOT NULL,
    PRIMARY KEY (Name, Address)
);

DROP TABLE IF EXISTS Courses;
CREATE TABLE IF NOT EXISTS Courses (
    Name TEXT NOT NULL,
    Year INTEGER NOT NULL,
    Semester TEXT NOT NULL,
    Teacher TEXT NOT NULL,
    PRIMARY KEY (Name, Year, Semester)
);

DROP TABLE IF EXISTS Registrations;
CREATE TABLE IF NOT EXISTS Registrations (
    StudentName TEXT NOT NULL,
    StudentAddress TEXT NOT NULL,
    CourseName TEXT NOT NULL,
    CourseYear INTEGER NOT NULL,
    CourseSemester TEXT NOT NULL,
    Grade FLOAT,
    FOREIGN KEY (StudentName, StudentAddress)
        REFERENCES Students (Name, Address)
        ON UPDATE CASCADE ON DELETE CASCADE,

    FOREIGN KEY (CourseName, CourseYear, CourseSemester)
        REFERENCES Courses (Name, Year, Semester)
        ON UPDATE CASCADE ON DELETE RESTRICT
);


INSERT INTO Courses (Name, Year, Semester, Teacher)
VALUES ('SD', 2019, 'autumn', 'Line');

INSERT INTO Courses (Name, Year, Semester, Teacher)
VALUES ('SD', 2020, 'spring', 'Line');

INSERT INTO Courses (Name, Year, Semester, Teacher)
VALUES ('ES1', 2019, 'autumn', 'Ebbe');


/* Aisha Lincoln */
INSERT INTO Students (Name, Address)
VALUES ('Aisha Lincoln', '4800 Nykøbing F Denmark');

INSERT INTO Registrations (StudentName, StudentAddress, CourseName, CourseYear, CourseSemester,
                            Grade)
VALUES ('Aisha Lincoln', '4800 Nykøbing F Denmark', 'SD', 2019, 'autumn', 12);

INSERT INTO Registrations (StudentName, StudentAddress, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES ('Aisha Lincoln', '4800 Nykøbing F Denmark', 'ES1', 2019, 'autumn', 10);

/* Anya Neilsen */
INSERT INTO Students (Name, Address)
VALUES ('Anya Neilsen', '4800 Nykøbing F Denmark');

INSERT INTO Registrations (StudentName, StudentAddress, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES ('Anya Neilsen', '4800 Nykøbing F Denmark', 'SD', 2020, 'spring', NULL);

INSERT INTO Registrations (StudentName, StudentAddress, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES ('Anya Neilsen', '4800 Nykøbing F Denmark', 'ES1', 2019, 'autumn', 12);

/* Alfred Jensen */
INSERT INTO Students (Name, Address)
VALUES ('Alfred Jensen', 'Karlskrona Sweden');

INSERT INTO Registrations (StudentName, StudentAddress, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES ('Alfred Jensen', 'Karlskrona Sweden', 'SD', 2019, 'autumn', 7);

INSERT INTO Registrations (StudentName, StudentAddress, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES ('Alfred Jensen', 'Karlskrona Sweden', 'ES1', 2019, 'autumn', 10);

/* Berta Bertelsen */
INSERT INTO Students (Name, Address)
VALUES ('Berta Bertelsen', '7190 Bilund Denmark');

INSERT INTO Registrations (StudentName, StudentAddress, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES ('Berta Bertelsen', '7190 Bilund Denmark', 'SD', 2020, 'spring', NULL);

INSERT INTO Registrations (StudentName, StudentAddress, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES ('Berta Bertelsen', '7190 Bilund Denmark', 'ES1', 2019, 'autumn', 2);

/* Albert Antonsen */
INSERT INTO Students (Name, Address)
VALUES ('Albert Antonsen', '4180 Sorø Denmark');

INSERT INTO Registrations (StudentName, StudentAddress, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES ('Albert Antonsen', '4180 Sorø Denmark', 'SD', 2019, 'autumn', 10);

INSERT INTO Registrations (StudentName, StudentAddress, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES ('Albert Antonsen', '4180 Sorø Denmark', 'ES1', 2019, 'autumn', 7);

/* Eske Eriksen */
INSERT INTO Students (Name, Address)
VALUES ('Eske Eriksen', '4863 Eskildstrup Denmark');

INSERT INTO Registrations (StudentName, StudentAddress, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES ('Eske Eriksen', '4863 Eskildstrup Denmark', 'SD', 2020, 'spring', NULL);

INSERT INTO Registrations (StudentName, StudentAddress, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES ('Eske Eriksen', '4863 Eskildstrup Denmark', 'ES1', 2019, 'autumn', 10);

/* Olaf Olesen */
INSERT INTO Students (Name, Address)
VALUES ('Olaf Olesen', '5000 Odense Denmark');

INSERT INTO Registrations (StudentName, StudentAddress, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES ('Olaf Olesen', '5000 Odense Denmark', 'SD', 2019, 'autumn', 4);

INSERT INTO Registrations (StudentName, StudentAddress, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES ('Olaf Olesen', '5000 Odense Denmark', 'ES1', 2019, 'autumn', 12);

/* Salma Simonsen */
INSERT INTO Students (Name, Address)
VALUES ('Salma Simonsen', 'Stockholm Sweden');

INSERT INTO Registrations (StudentName, StudentAddress, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES ('Salma Simonsen', 'Stockholm Sweden', 'SD', 2020, 'spring', NULL);

INSERT INTO Registrations (StudentName, StudentAddress, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES ('Salma Simonsen', 'Stockholm Sweden', 'ES1', 2019, 'autumn', 12);

/* Theis Thomasen */
INSERT INTO Students (Name, Address)
VALUES ('Theis Thomasen', '4340 Tølløse Denmark');

INSERT INTO Registrations (StudentName, StudentAddress, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES ('Theis Thomasen', '4340 Tølløse Denmark', 'SD', 2019, 'autumn', 12);

INSERT INTO Registrations (StudentName, StudentAddress, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES ('Theis Thomasen', '4340 Tølløse Denmark', 'ES1', 2019, 'autumn', 12);

/* Janet Jensen */
INSERT INTO Students (Name, Address)
VALUES ('Janet Jensen', '4040 Jyllinge Denmark');

INSERT INTO Registrations (StudentName, StudentAddress, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES ('Janet Jensen', '4040 Jyllinge Denmark', 'SD', 2020, 'spring', NULL);

INSERT INTO Registrations (StudentName, StudentAddress, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES ('Janet Jensen', '4040 Jyllinge Denmark', 'ES1', 2019, 'autumn', 7);