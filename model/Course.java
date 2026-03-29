/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
 
public class Course {
    private int    courseId;
    private String courseName;
    private String courseDescription;
    private int    credits;
 
    public Course(int courseId, String courseName, String courseDescription, int credits) {
        this.courseId          = courseId;
        this.courseName        = courseName;
        this.courseDescription = courseDescription;
        this.credits           = credits;
    }
 
    // Getters
    public int    getCourseId()          { return courseId;          }
    public String getCourseName()        { return courseName;        }
    public String getCourseDescription() { return courseDescription; }
    public int    getCredits()           { return credits;           }
 
    // Setters
    public void setCourseId(int id)              { this.courseId          = id;   }
    public void setCourseName(String name)       { this.courseName        = name; }
    public void setCourseDescription(String desc){ this.courseDescription = desc; }
    public void setCredits(int credits)          { this.credits           = credits; }
}