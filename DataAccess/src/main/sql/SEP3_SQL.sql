-- noinspection SqlNoDataSourceInspectionForFile

-- noinspection SqlDialectInspectionForFile

DROP SCHEMA IF EXISTS sep3;
CREATE SCHEMA sep3;

USE sep3;

-- -- -- User Table -- -- --

DROP TABLE IF EXISTS Users CASCADE;
CREATE TABLE Users (

                       users_ID SERIAL,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       firstName VARCHAR(255),
                       lastName VARCHAR(255),
                       email VARCHAR(255),
                       status VARCHAR(30),
                       accessLevel VARCHAR(255),
                       dayEmployment int,
                       monthEmployment int,
                       yearEmployment int,
                       PRIMARY KEY (Users_ID)
);

-- Test purposes, can be deleted at anytime

INSERT INTO Users (username, password, firstName, lastName, email, status, accessLevel, dayEmployment, monthEmployment, yearEmployment)
    VALUE('admin', 'admin', 'admin', 'admin', 'admin@admin.admin', 'ACTIVE', 'MANAGER', 16, 03, 2020  );

INSERT INTO Users (username, password, firstName, lastName, email, status, accessLevel, dayEmployment, monthEmployment, yearEmployment)
    VALUE('Anders', '1234', 'Anders', 'Sønderby', '264247@via.dk', 'ACTIVE', 'EMPLOYEE', 16, 03, 2020  );

INSERT INTO Users (username, password, firstName, lastName, email, status, accessLevel, dayEmployment, monthEmployment, yearEmployment)
    VALUE('David', '3556498', 'David', 'Nguyen', '251771@via.dk', 'INACTIVE', 'MANAGER', 16, 03, 2020  );

INSERT INTO Users (username, password, firstName, lastName, email, status, accessLevel, dayEmployment, monthEmployment, yearEmployment)
    VALUE('Niklas', '549190650', 'Niklas', 'Krogh', '281335@via.dk', 'ACTIVE', 'MANAGER', 16, 03, 2020  );

INSERT INTO Users (username, password, firstName, lastName, email, status, accessLevel, dayEmployment, monthEmployment, yearEmployment)
    VALUE('Rokas', '92668751', 'Rokas', 'Barasa', '285047@via.dk', 'ACTIVE', 'EMPLOYEE', 16, 03, 2020  );

INSERT INTO Users (username, password, firstName, lastName, email, status, accessLevel, dayEmployment, monthEmployment, yearEmployment)
    VALUE('Human1', 'admin1', 'Nedas', 'Annoying', '281335@via.dk', 'ACTIVE', 'EMPLOYEE', 16, 03, 2020  );

INSERT INTO Users (username, password, firstName, lastName, email, status, accessLevel, dayEmployment, monthEmployment, yearEmployment)
    VALUE('Human2', 'admin2', 'Bragi', 'Weed', '285047@via.dk', 'ACTIVE', 'EMPLOYEE', 16, 03, 2020  );

INSERT INTO Users (username, password, firstName, lastName, email, status, accessLevel, dayEmployment, monthEmployment, yearEmployment)
    VALUE('Human3', 'admin3', 'Luhan', 'Dady', '281335@via.dk', 'ACTIVE', 'EMPLOYEE', 16, 03, 2020  );

INSERT INTO Users (username, password, firstName, lastName, email, status, accessLevel, dayEmployment, monthEmployment, yearEmployment)
    VALUE('Human4', 'admin4', 'Toma&', 'Slovakian?', '285047@via.dk', 'ACTIVE', 'EMPLOYEE', 16, 03, 2020  );

SELECT * FROM Users;



-- Test end here...

SELECT Users_ID, username FROM Users WHERE username = 'Niklas';

SELECT username, password, accessLevel FROM Users
WHERE accessLevel = 'employee';

-- -- -- Shift Table -- -- --

DROP TABLE IF EXISTS Shift CASCADE;
CREATE TABLE Shift (
                        Shift_ID SERIAL,
                        Users_ID INTEGER REFERENCES Users(Users_ID),
                        Manager_ID INTEGER REFERENCES Users(Users_ID),
                        description VARCHAR(10000),
                        day int,
                        month int,
                        year int,
                        PRIMARY KEY(Shift_ID)

);

-- Test purposes, can be deleted at anytime

INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (5, 3, 'This is a test of the shift',   04, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (2, 3,'This is a test of the shift',   05, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (6, 3, 'This is a test of the ',   06, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (5, 3,'This is a test  the shift',   07, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (9, 3, 'This is a test of the shift',   08, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (6, 3,'This  test of the shift',   11, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (7, 3, 'This is a  of the shift',   12, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (8, 3,'f the shift',   14, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (8, 3, 'This is a test of the shift',   13, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (5, 3,'This is a test of the shift',   29, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (2, 3,'This is a test of the shift',   06, 05, 2020);
SELECT * FROM Shift;