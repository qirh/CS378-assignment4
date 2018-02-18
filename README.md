# CS378 Modern Web Apps. Assignment 4 (REST API) [![MIT license](https://img.shields.io/badge/license-MIT-lightgrey.svg)](https://https://raw.githubusercontent.com/qirh/CS378-assignment4/master/LICENSE)

## Description
Modern Web Applications Assignment#4. Done for CS 378, taught by Dr. Devdatta Kulkarni in the fall of 2016. 

* [Assignment details](https://github.com/qirh/CS378-assignment4/blob/master/assignment4.pdf)

* [Course Syllabus](https://github.com/qirh/CS378-assignment4/blob/master/syllabus.pdf)

## Instructions
Curl Commands

    --host=fall-2016.cs.utexas.edu -u almto3 -pPxWHQV5wg5
    curl -i --data "<project><name>curl</name><description>testing post on curl</description></project>" -H "Content-Type: application/xml" -X POST http://localhost:8080/assignment4/myeavesdrop/projects/
    curl -i --data "<project><name>curl</name><description>testing poswewerwerwert on curl</description></project>" -H "Content-Type: application/xml" -X PUT http://localhost:8080/assignment4/myeavesdrop/projects/5
    curl -i -X GET http://localhost:8080/assignment4/myeavesdrop/projects/7
    curl -i -X GET http://localhost:8080/assignment4/myeavesdrop/projects/7
    
    
    
## MySQL Server Installation

    MySQL Community Server
    http://dev.mysql.com/downloads/

    On Mac, download the .dmg file

    Starting MySQL Server (on Mac)
    - In Spotlight search for MySQL
    - MySQL window should open up with “Start MySQL Server” button on it
    - MySQL Server Instance should be in “stopped” status
    - Hit the “Start MySQL Server” button; you may be prompted for a password
    - Enter the password; MySQL server should be up

    MySQL Clients
    - Command line
      - /usr/local/mysql/bin/mysql – if you install the .dmg from above link
    - MySQL Workbench
      - SQuirrel SQL
      - http://squirrel-sql.sourceforge.net/

    Local MySQL Server
    127.0.0.1
    Port number 3306
    Usename: root

    Setting up database:

    1) Run mysql client
       - /usr/local/mysql/bin/mysql -u root

    2) Create Database
       - create database student_courses;

    3) Create User
       - Example: create user 'devdatta'@'localhost’;

    4) Grant Privileges
       GRANT ALL ON student_courses.* TO ‘devdatta’@’localhost’;

    5) Logout 
       - On mysql prompt: “quit”

    6) Login as user;
       - /usr/local/mysql/bin/mysql –u devdatta –h localhost

    7) Create Table
       - use student_courses;
       - create table courses(name varchar(255) NOT NULL, course_num varchar(20) NOT NULL, course_id int NOT NULL AUTO_INCREMENT, PRIMARY KEY(course_id));

    user = almto3
    database = cs378_almto3
    password = PxWHQV5wg5