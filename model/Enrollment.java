/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
 
import java.sql.Date;
 
public class Enrollment {
    private int    enrollmentId;
    private int    studentId;
    private int    courseId;
    private Date   enrollmentDate;
 
    public Enrollment(int enrollmentId, int studentId, int courseId, Date enrollmentDate) {
        this.enrollmentId   = enrollmentId;
        this.studentId      = studentId;
        this.courseId       = courseId;
        this.enrollmentDate = enrollmentDate;
    }
 
    // Getters
    public int  getEnrollmentId()   { return enrollmentId;   }
    public int  getStudentId()      { return studentId;      }
    public int  getCourseId()       { return courseId;       }
    public Date getEnrollmentDate() { return enrollmentDate; }
 
    // Setters
    public void setEnrollmentId(int id)         { this.enrollmentId   = id;   }
    public void setStudentId(int id)            { this.studentId      = id;   }
    public void setCourseId(int id)             { this.courseId       = id;   }
    public void setEnrollmentDate(Date date)    { this.enrollmentDate = date; }
}