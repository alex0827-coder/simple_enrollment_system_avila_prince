/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
 
import database.DatabaseConnection;
import model.Enrollment;
 
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
 
public class EnrollmentDAO {
public boolean isAlreadyEnrolled(int studentId, int courseId) {
    String sql = "SELECT COUNT(*) FROM Enrolled_Subject WHERE student_id = ? AND course_id = ?";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, studentId);
        ps.setInt(2, courseId);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
    } catch (SQLException e) {
        System.out.println("Check Enrollment Error: " + e.getMessage());
    }
    return false;
}
    // ENROLL Student
    public boolean addEnrollment(Enrollment e) {
        String sql = "INSERT INTO Enrolled_Subject (student_id, course_id, enrollment_date) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
 
            ps.setInt (1, e.getStudentId());
            ps.setInt (2, e.getCourseId());
            ps.setDate(3, e.getEnrollmentDate());
            ps.executeUpdate();
            return true;
 
        } catch (SQLException ex) {
            System.out.println("Add Enrollment Error: " + ex.getMessage());
            return false;
        }
    }
 
    // VIEW All Enrollments (with names)
    public List<Object[]> getAllEnrollments() {
        List<Object[]> list = new ArrayList<>();
        String sql = """
            SELECT es.enrollment_id,
                   CONCAT(s.first_name, ' ', s.last_name) AS student_name,
                   c.course_name,
                   es.enrollment_date
            FROM Enrolled_Subject es
            JOIN Student s ON es.student_id = s.student_id
            JOIN Course  c ON es.course_id  = c.course_id
        """;
        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
 
            while (rs.next()) {
                list.add(new Object[]{
                    rs.getInt   ("enrollment_id"),
                    rs.getString("student_name"),
                    rs.getString("course_name"),
                    rs.getDate  ("enrollment_date")
                });
            }
        } catch (SQLException e) {
            System.out.println("View Enrollments Error: " + e.getMessage());
        }
        return list;
    }
 
    // DELETE Enrollment
    public boolean deleteEnrollment(int enrollmentId) {
        String sql = "DELETE FROM Enrolled_Subject WHERE enrollment_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
 
            ps.setInt(1, enrollmentId);
            ps.executeUpdate();
            return true;
 
        } catch (SQLException e) {
            System.out.println("Delete Enrollment Error: " + e.getMessage());
            return false;
        }
    }
}