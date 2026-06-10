package com.JDBC;
import java.sql.*;

public class StudentDAO {

    private Connection connection;

    public StudentDAO(Connection connection) {
        this.connection = connection;
    }

    // INSERT
    public void insertStudent(Student student) throws SQLException {
        String sql = "INSERT INTO studentInfo (sname, sage, scity) VALUES (?, ?, ?)";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, student.getName());
        ps.setInt(2, student.getAge());
        ps.setString(3, student.getCity());

        ps.executeUpdate();
        ps.close();
    }

    // SELECT ALL
    public void getAllStudents() throws SQLException {
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM studentInfo");

        while (rs.next()) {
            System.out.println(
                    rs.getInt("id") + " " +
                            rs.getString("sname") + " " +
                            rs.getInt("sage") + " " +
                            rs.getString("scity")
            );
        }

        rs.close();
        st.close();
    }

    // UPDATE
    public void updateStudent(int id, String field, String value) throws SQLException {
        String sql = "UPDATE studentInfo SET " + field + " = ? WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, value);
        ps.setInt(2, id);

        ps.executeUpdate();
        ps.close();
    }
}