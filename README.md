simple enrollment system 
Implementations:
mysql schema with 3 tables connected to a non identifying 1 to many relationship
table 1 = student, columns(ID, firstname, lastname, age, email)
table 2 = courses, columns(course ID, course name, course description, credits)
table 3 = enrolled subject, columns(enrollment ID, student, ID, course ID, enrollment date)

netbeans with 1 java project consisting of 5 packages 

main package 
   //acts as a switch for the entire system
      -main

dao package
  //sql queries and CRUD logic
      - courseDAO
      - enrollmentDAO   
      - studentDAO

database
//connection from mysql to netbeans
 - DatabaseConnection.java
 
gui
//gui designs and functions
    - coursewindow
    - enrollmentwindow
    - mainmenu
    - studentwindow

model
//represent objects
   - course
   - enrollment
   - student

dependencies
MySQL Connector/J (JDBC Driver):
mysql-connector-j-8.x.x.jar).

how to run the app:
start mysql
clean and build StudentEnrollmentSystem project
go to main and run file (shortcut: shift + f6)

summary:
IDE - netbeans
language - java
database - MySQL 8.0+
gui - Java Swing
Design Pattern - DAO (Data Access Object)


