package com.company.repository;

import com.company.config.DatabaseConfiguration;

import java.sql.*;

public class StudentRepository {

    public void createTable(){
        String createTableSql = "CREATE TABLE IF NOT EXISTS students"
                + "(id int PRIMARY KEY AUTO_INCREMENT, CNP varchar(14), name varchar(30), grade int)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // op. de tip create
    public void addStudent(String CNP, String name, int grade) {
        String insertStudentSql = "INSERT INTO students(CNP, name, grade) VALUES(?, ?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertStudentSql);
            preparedStatement.setString(1, CNP);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, grade);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // op. de tip read
    public void displayStudents() {
        String selectStudentsSql = "SELECT * FROM students";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectStudentsSql);
            System.out.println("Students: ");
            while (resultSet.next()) {
                System.out.println("\tId: " + resultSet.getInt(1));
                System.out.println("\tCNP: " + resultSet.getString(2));
                System.out.println("\tName: " + resultSet.getString(3));
                System.out.println("\tGrade: " + resultSet.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // op. de tip UPDATE
    public void updateStudentGrade(String CNP, int grade) {
        String updateStudentGradeSql = "UPDATE students SET grade=? WHERE CNP=?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateStudentGradeSql);
            preparedStatement.setInt(1, grade);
            preparedStatement.setString(2, CNP);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // op. de tip DELETE
    public void deleteStudent(String CNP) {
        String deleteStudentSql = "DELETE FROM students WHERE CNP=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteStudentSql);
            preparedStatement.setString(1, CNP);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
