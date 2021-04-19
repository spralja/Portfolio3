DROP TABLE IF EXISTS Students;
CREATE TABLE IF NOT EXISTS Students (
    Name TEXT,
    Address TEXT,
    ID INTEGER,
    PRIMARY KEY (ID)
);

DROP TABLE IF EXISTS Courses;
CREATE TABLE IF NOT EXISTS Courses (
    Name TEXT,
    Year INTEGER,
    Semester TEXT,
    Teacher TEXT,
    ID INTEGER,
    PRIMARY KEY (ID)
);

DROP TABLE IF EXISTS Registrations;
CREATE TABLE IF NOT EXISTS Registrations (
    StudentID INTEGER,
    CourseID INTEGER,
    CourseName TEXT,
    CourseYear INTEGER,
    CourseSemester TEXT,
    Grade INTEGER,
    FOREIGN KEY (StudentID)
        REFERENCES Students (ID)
        ON UPDATE CASCADE ON DELETE CASCADE,

    FOREIGN KEY (CourseID)
        REFERENCES Courses (ID)
        ON UPDATE CASCADE ON DELETE RESTRICT
);


INSERT INTO Courses (Name, Year, Semester, Teacher)
VALUES ('SD', 2019, 'autumn', 'Line');

INSERT INTO Courses (Name, Year, Semester, Teacher)
VALUES ('SD', 2020, 'spring', 'Line');

INSERT INTO Courses (Name, Year, Semester, Teacher)
VALUES ('ES1', 2019, 'autumn', 'Ebbe');
