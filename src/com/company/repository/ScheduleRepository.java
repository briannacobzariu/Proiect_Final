package com.company.repository;

import com.company.config.DatabaseConfiguration;

import java.sql.*;

public class ScheduleRepository {

    public void createTable(){
        String createTableSql = "CREATE TABLE IF NOT EXISTS schedules"
                + "(id int PRIMARY KEY AUTO_INCREMENT, intervalul varchar(30), weekday varchar(30))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // op. de tip create
    public void addSchedule(String interval, String weekday) {
        String insertScheduleSql = "INSERT INTO schedules(intervalul, weekday) VALUES(?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertScheduleSql);
            preparedStatement.setString(1, interval);
            preparedStatement.setString(2, weekday);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // op. de tip read
    public void displaySchedules() {
        String selectSchedulesSql = "SELECT * FROM schedules";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSchedulesSql);
            System.out.println("Schedules: ");
            while (resultSet.next()) {
                System.out.println("\tId: " + resultSet.getInt(1));
                System.out.println("\tInterval: " + resultSet.getString(2));
                System.out.println("\tWeekday: " + resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // op. de tip update
    public void updateScheduleInterval(String weekday, String oldInterval, String newInterval) {
        String updateScheduleIntervalSql = "UPDATE schedules SET intervalul=? WHERE weekday=? and intervalul=?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateScheduleIntervalSql);
            preparedStatement.setString(1, newInterval);
            preparedStatement.setString(2, weekday);
            preparedStatement.setString(3, oldInterval);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // op. de tip delete
    public void deleteSchedule(int id) {
        String deleteScheduleSql = "DELETE FROM schedules WHERE id=?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteScheduleSql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
