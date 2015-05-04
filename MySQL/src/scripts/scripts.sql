CREATE TABLE LOCATIONS (
  LOCATION_ID INT(8) AUTO_INCREMENT PRIMARY KEY,
  STREET_ADDRESS VARCHAR(12),
  POSTAL_CODE VARCHAR(12),
  CITY VARCHAR(30) NOT NULL ,
  STATE_PROVINCE VARCHAR(25)
);

CREATE TABLE DEPARTMENTS(
  DEPARTMENT_ID INT(8) AUTO_INCREMENT PRIMARY KEY ,
  DEPARTMENT_NAME VARCHAR(30) NOT NULL ,
  LOCATION_ID INT(8)
);


CREATE TABLE JOBS(
  JOB_ID INT(8) AUTO_INCREMENT PRIMARY KEY ,
  JOB_TITLE VARCHAR(35) NOT NULL ,
  MIN_SALARY INT(6),
  MAX_SALARY INT(6)
);


CREATE TABLE EMPLOYEES(
  EMPLOYEE_ID INT(8) AUTO_INCREMENT PRIMARY KEY ,
  FIRST_NAME VARCHAR(20),
  LAST_NAME VARCHAR(25) NOT NULL ,
  EMAIL VARCHAR(25) NOT NULL ,
  PHONE_NUMBER VARCHAR(20),
  HIRE_DATE DATE,
  JOB_ID INT(10),
  SALARY DECIMAL(8,2),
  COMISSION_PCT DECIMAL(2,2),
  MANAGER_ID INT(8),
  DEPARTMENT_ID INT(8)
);




ALTER TABLE  employees add FOREIGN KEY (MANAGER_ID)
  REFERENCES  employees(EMPLOYEE_ID);

ALTER TABLE employees ADD FOREIGN KEY(JOB_ID)
  REFERENCES jobs(JOB_ID);

ALTER TABLE employees ADD FOREIGN KEY (DEPARTMENT_ID)
  REFERENCES departments(DEPARTMENT_ID);

ALTER TABLE departments ADD FOREIGN KEY (LOCATION_ID)
  REFERENCES locations(LOCATION_ID);




INSERT INTO departments VALUES (
  1,
  'Administration',
  1700
);

INSERT INTO locations VALUES (
  1700,
  'STRADA',
  1234,
  'BUCURESTI',
  'SECTOR1'
);

INSERT INTO jobs VALUES (
  1,
  'President',
  20000,
  40000
);

INSERT INTO employees VALUES (
  1,
  'Steven',
  'King',
  'SKING',
  '515.123.4567',
  NOW(),
  '1',
  24000,
  NULL,
  NULL,
  1
);
