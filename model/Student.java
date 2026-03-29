/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
 
public class Student {
    private int    studentId;
    private String firstName;
    private String lastName;
    private int    age;
    private String email;
 
    // Constructor
    public Student(int studentId, String firstName, String lastName, int age, String email) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName  = lastName;
        this.age       = age;
        this.email     = email;
    }
 
    // Getters
    public int    getStudentId() { return studentId; }
    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName;  }
    public int    getAge()       { return age;       }
    public String getEmail()     { return email;     }
 
    // Setters
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public void setFirstName(String fn)     { this.firstName = fn;        }
    public void setLastName(String ln)      { this.lastName  = ln;        }
    public void setAge(int age)             { this.age       = age;       }
    public void setEmail(String email)      { this.email     = email;     }
}
 