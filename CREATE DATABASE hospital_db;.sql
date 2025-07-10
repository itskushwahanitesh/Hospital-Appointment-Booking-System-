CREATE DATABASE hospital_db;

USE hospital_db;

CREATE TABLE appointments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    appointment_date DATE,
    department VARCHAR(50)
);