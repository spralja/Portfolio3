DROP TABLE IF EXISTS Students;
CREATE TABLE IF NOT EXISTS Students (
    PIN INTEGER NOT NULL,
    Name TEXT NOT NULL,
    Address TEXT NOT NULL,
    PRIMARY KEY (PIN)
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
    PIN INTEGER NOT NULL,
    CourseName TEXT NOT NULL,
    CourseYear INTEGER NOT NULL,
    CourseSemester TEXT NOT NULL,
    Grade FLOAT,
    FOREIGN KEY (PIN)
        REFERENCES Students (PIN)
        ON UPDATE CASCADE ON DELETE CASCADE,

    FOREIGN KEY (CourseName, CourseYear, CourseSemester)
        REFERENCES Courses (Name, Year, Semester)
        ON UPDATE CASCADE ON DELETE RESTRICT,

    PRIMARY KEY (PIN, CourseName, CourseYear, CourseSemester)
);


INSERT INTO Courses (Name, Year, Semester, Teacher)
VALUES ('SD', 2019, 'autumn', 'Line');

INSERT INTO Courses (Name, Year, Semester, Teacher)
VALUES ('SD', 2020, 'spring', 'Line');

INSERT INTO Courses (Name, Year, Semester, Teacher)
VALUES ('ES1', 2019, 'autumn', 'Ebbe');


/* Aisha Lincoln */
INSERT INTO Students (Name, Address, PIN)
VALUES ('Aisha Lincoln', '4800 Nykøbing F Denmark', 0);

INSERT INTO Registrations (PIN, CourseName, CourseYear, CourseSemester,
                            Grade)
VALUES (0, 'SD', 2019, 'autumn', 12);

INSERT INTO Registrations (PIN, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES (0, 'ES1', 2019, 'autumn', 10);

/* Anya Neilsen */
INSERT INTO Students (Name, Address, PIN)
VALUES ('Anya Neilsen', '4800 Nykøbing F Denmark', 1);

INSERT INTO Registrations (PIN, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES (1, 'SD', 2020, 'spring', NULL);

INSERT INTO Registrations (PIN, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES (1, 'ES1', 2019, 'autumn', 12);

/* Alfred Jensen */
INSERT INTO Students (Name, Address, PIN)
VALUES ('Alfred Jensen', 'Karlskrona Sweden', 2);

INSERT INTO Registrations (PIN, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES (2, 'SD', 2019, 'autumn', 7);

INSERT INTO Registrations (PIN, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES (2, 'ES1', 2019, 'autumn', 10);

/* Berta Bertelsen */
INSERT INTO Students (Name, Address, PIN)
VALUES ('Berta Bertelsen', '7190 Bilund Denmark', 3);

INSERT INTO Registrations (PIN, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES (3, 'SD', 2020, 'spring', NULL);

INSERT INTO Registrations (PIN, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES (3, 'ES1', 2019, 'autumn', 2);

/* Albert Antonsen */
INSERT INTO Students (Name, Address, PIN)
VALUES ('Albert Antonsen', '4180 Sorø Denmark', 4);

INSERT INTO Registrations (PIN, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES (4, 'SD', 2019, 'autumn', 10);

INSERT INTO Registrations (PIN, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES (4, 'ES1', 2019, 'autumn', 7);

/* Eske Eriksen */
INSERT INTO Students (Name, Address, PIN)
VALUES ('Eske Eriksen', '4863 Eskildstrup Denmark', 5);

INSERT INTO Registrations (PIN, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES (5, 'SD', 2020, 'spring', NULL);

INSERT INTO Registrations (PIN, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES (5, 'ES1', 2019, 'autumn', 10);

/* Olaf Olesen */
INSERT INTO Students (Name, Address, PIN)
VALUES ('Olaf Olesen', '5000 Odense Denmark', 6);

INSERT INTO Registrations (PIN, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES (6, 'SD', 2019, 'autumn', 4);

INSERT INTO Registrations (PIN, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES (6, 'ES1', 2019, 'autumn', 12);

/* Salma Simonsen */
INSERT INTO Students (Name, Address, PIN)
VALUES ('Salma Simonsen', 'Stockholm Sweden', 7);

INSERT INTO Registrations (PIN, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES (7, 'SD', 2020, 'spring', NULL);

INSERT INTO Registrations (PIN, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES (7, 'ES1', 2019, 'autumn', 12);

/* Theis Thomasen */
INSERT INTO Students (Name, Address, PIN)
VALUES ('Theis Thomasen', '4340 Tølløse Denmark', 8);

INSERT INTO Registrations (PIN, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES (8, 'SD', 2019, 'autumn', 12);

INSERT INTO Registrations (PIN, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES (8, 'ES1', 2019, 'autumn', 12);

/* Janet Jensen */
INSERT INTO Students (Name, Address, PIN)
VALUES ('Janet Jensen', '4040 Jyllinge Denmark', 9);

INSERT INTO Registrations (PIN, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES (9, 'SD', 2020, 'spring', NULL);

INSERT INTO Registrations (PIN, CourseName, CourseYear, CourseSemester,
                           Grade)
VALUES (9, 'ES1', 2019, 'autumn', 7);