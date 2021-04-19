DROP TABLE IF EXISTS Students;
CREATE TABLE IF NOT EXISTS Students (
    Name TEXT NOT NULL,
    Address TEXT NOT NULL,
    ID INTEGER NOT NULL,
    PRIMARY KEY (ID)
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
    StudentID INTEGER NOT NULL,
    CourseName TEXT NOT NULL,
    CourseYear INTEGER NOT NULL,
    CourseSemester TEXT NOT NULL,
    Grade INTEGER,
    FOREIGN KEY (StudentID)
        REFERENCES Students (ID)
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
