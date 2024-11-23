CREATE TABLE PERSONS
(
    id             INT AUTO_INCREMENT PRIMARY KEY,
    name           VARCHAR(50),
    surname        VARCHAR(50),
    age            INT,
    phone_number   VARCHAR(20),
    city_of_living VARCHAR(50)
);

INSERT INTO PERSONS (name, surname, age, phone_number, city_of_living)
VALUES ('Alexey', 'Ivanov', 30, '123456789', 'Moscow'),
       ('Maria', 'Petrova', 25, '987654321', 'Moscow'),
       ('John', 'Smith', 40, '111111111', 'New York'),
       ('Elena', 'Smirnova', 20, '222222222', 'Kazan');
