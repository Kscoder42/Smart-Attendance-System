package dao;

import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    // Add student
    public void addStudent(String name, String roll) {
        String sql = "INSERT INTO students(name, roll_number) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, roll);
            ps.executeUpdate();

            System.out.println("✅ Student added successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View students
    public void viewStudents() {
        String sql = "SELECT * FROM students";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\nID | Name | Roll Number");
            System.out.println("-----------------------");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("roll_number")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Mark attendance
    public void markAttendance(int studentId, String status) {
        String sql =
                "INSERT INTO attendance(student_id, date, status) VALUES (?, CURDATE(), ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ps.setString(2, status);
            ps.executeUpdate();

            System.out.println("✅ Attendance marked successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
