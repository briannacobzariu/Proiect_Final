package com.company.repository;

import com.company.config.DatabaseConfiguration;

import java.sql.*;

public class CourseRepository {

    public void createTable(){
        String createTableSql = "CREATE TABLE IF NOT EXISTS courses"
                + "(id int PRIMARY KEY AUTO_INCREMENT, name varchar(30), nivel varchar(30))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // op. de tip create
    public void addCourse(String name, String nivel) {
        String insertCourseSql = "INSERT INTO courses(name, nivel) VALUES(?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertCourseSql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, nivel);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // op. de tip read
    public void displayCourses() {
        String selectCoursesSql = "SELECT * FROM courses";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectCoursesSql);
            System.out.println("Courses: ");
            while (resultSet.next()) {
                System.out.println("\tId: " + resultSet.getInt(1));
                System.out.println("\tName: " + resultSet.getString(2));
                System.out.println("\tNivel: " + resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // op. de tip UPDATE
    public void updateCourseLevel(int id, String nivel) {
        String updateCourseLevelSql = "UPDATE courses SET nivel=? WHERE id=?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateCourseLevelSql);
            preparedStatement.setString(1, nivel);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // op. de tip DELETE
    public void deleteCourse(String name, String nivel) {
        String deleteCourseSql = "DELETE FROM courses WHERE name=? and nivel=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteCourseSql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, nivel);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
