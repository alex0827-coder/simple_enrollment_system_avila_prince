/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
 
import database.DatabaseConnection;
import model.Course;
 
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
 
public class CourseDAO {
 
    // ADD Course
    public boolean addCourse(Course c) {
        String sql = "INSERT INTO Course (course_name, course_description, credits) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
 
            ps.setString(1, c.getCourseName());
            ps.setString(2, c.getCourseDescription());
            ps.setInt   (3, c.getCredits());
            ps.executeUpdate();
            return true;
 
        } catch (SQLException e) {
            System.out.println("Add Course Error: " + e.getMessage());
            return false;
        }
    }
 
    // VIEW All Courses
    public List<Course> getAllCourses() {
    List<Course> list = new ArrayList<>();
    String sql = "SELECT * FROM Course"; // Ensure table name matches exactly
    try (Connection conn = DatabaseConnection.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {

        while (rs.next()) {
            list.add(new Course(
                rs.getInt(1),      // Use index 1 for the ID
                rs.getString(2),   // Name
                rs.getString(3),   // Description
                rs.getInt(4)       // Credits
            ));
        }
    } catch (SQLException e) {
        System.out.println("View Courses Error: " + e.getMessage());
    }
    return list;
}
 

    public boolean updateCourse(Course c) {
        String sql = "UPDATE Course SET course_name=?, course_description=?, credits=? WHERE course_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
 
            ps.setString(1, c.getCourseName());
            ps.setString(2, c.getCourseDescription());
            ps.setInt   (3, c.getCredits());
            ps.setInt   (4, c.getCourseId());
            ps.executeUpdate();
            return true;
 
        } catch (SQLException e) {
            System.out.println("Update Course Error: " + e.getMessage());
            return false;
        }
    }
 
    // DELETE Course
    public boolean deleteCourse(int courseId) {
        String sql = "DELETE FROM course WHERE course_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
 
            ps.setInt(1, courseId);
            ps.executeUpdate();
            return true;
 
        } catch (SQLException e) {
            System.out.println("Delete Course Error: " + e.getMessage());
            return false;
        }
    }
}