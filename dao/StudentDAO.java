/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
 
import database.DatabaseConnection;
import model.Student;
 
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
 
public class StudentDAO {
   public boolean isEmailExists(String email) {
    String sql = "SELECT COUNT(*) FROM Student WHERE email = ?";
    try (Connection conn = database.DatabaseConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setString(1, email);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1) > 0; // Returns true if count > 0
            }
        }
    } catch (SQLException e) {
        System.out.println("Error checking email: " + e.getMessage());
    }
    return false;
}
    // ADD Student
    public boolean addStudent(Student s) {
        String sql = "INSERT INTO Student (first_name, last_name, age, email) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
 
            ps.setString(1, s.getFirstName());
            ps.setString(2, s.getLastName());
            ps.setInt   (3, s.getAge());
            ps.setString(4, s.getEmail());
            ps.executeUpdate();
            return true;
 
        } catch (SQLException e) {
            System.out.println("Add Student Error: " + e.getMessage());
            return false;
        }
    }
 
    // VIEW All Students
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM Student";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
 
            while (rs.next()) {
                list.add(new Student(
                    rs.getInt   ("student_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getInt   ("age"),
                    rs.getString("email")
                ));
            }
        } catch (SQLException e) {
            System.out.println("View Students Error: " + e.getMessage());
        }
        return list;
    }
 
    // UPDATE Student
    public boolean updateStudent(Student s) {
        String sql = "UPDATE Student SET first_name=?, last_name=?, age=?, email=? WHERE student_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
 
            ps.setString(1, s.getFirstName());
            ps.setString(2, s.getLastName());
            ps.setInt   (3, s.getAge());
            ps.setString(4, s.getEmail());
            ps.setInt   (5, s.getStudentId());
            ps.executeUpdate();
            return true;
 
        } catch (SQLException e) {
            System.out.println("Update Student Error: " + e.getMessage());
            return false;
        }
    }
 
    // DELETE Student
    public boolean deleteStudent(int studentId) {
        String sql = "DELETE FROM Student WHERE student_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
 
            ps.setInt(1, studentId);
            ps.executeUpdate();
            return true;
 
        } catch (SQLException e) {
            System.out.println("Delete Student Error: " + e.getMessage());
            return false;
        }
    }
}