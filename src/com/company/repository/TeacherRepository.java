package com.company.repository;

import com.company.config.DatabaseConfiguration;

import java.sql.*;

public class TeacherRepository {

    public void createTable(){
        String createTableSql = "CREATE TABLE IF NOT EXISTS teachers"
                + "(id int PRIMARY KEY AUTO_INCREMENT, name varchar(30), department varchar(30), salary int)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // op. de tip create
    public void addTeacher(String name, String department, int salary) {
        String insertTeacherSql = "INSERT INTO teachers(name, department, salary) VALUES(?, ?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertTeacherSql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, department);
            preparedStatement.setInt(3, salary);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // op. de tip read
    public void displayTeachers() {
        String selectTeachersSql = "SELECT * FROM teachers";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectTeachersSql);
            System.out.println("Teachers: ");
            while (resultSet.next()) {
                System.out.println("\tId: " + resultSet.getInt(1));
                System.out.println("\tName: " + resultSet.getString(2));
                System.out.println("\tDepartment: " + resultSet.getString(3));
                System.out.println("\tSalary: " + resultSet.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // op. de tip UPDATE
    public void updateTeacherSalary(String name, int salary) {
        String updateTeacherSalarySql = "UPDATE teachers SET salary=? WHERE name=?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateTeacherSalarySql);
            preparedStatement.setInt(1, salary);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // op. de tip UPDATE
    public void updateTeacherName(String oldName, String newName) {
        String updateTeacherNameSql = "UPDATE teachers SET name=? WHERE name=?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateTeacherNameSql);
            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, oldName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // op. de tip UPDATE
    public void updateTeacherDepartment(String name, String newDep) {
        String updateTeacherDepartmentSql = "UPDATE teachers SET department=? WHERE name=?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateTeacherDepartmentSql);
            preparedStatement.setString(1, newDep);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // op. de tip DELETE
    public void deleteTeacher(String name) {
        String deleteTeacherSql = "DELETE FROM teachers WHERE name=?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteTeacherSql);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
