package persistence.employee;

import exceptions.DataConnectionException;
import persistence.database.IDBConnection;
import shared.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class UserDAO implements IUserDAO {
    private final IDBConnection databaseConnection;

    public UserDAO(IDBConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }


    @Override
    public String addUser(User user, String operation) {
        if(operation.equals("Check")){
            try {
                String sql = "SELECT username, password, firstName, lastName, email, status, accessLevel, dayEmployment, monthEmployment, yearEmployment FROM "
                        + databaseConnection.getUserTable() + " WHERE username = '" + user.getUsername() + "' AND password = '" + user.getPassword() + "' AND accessLevel = '" + user.getAccessLevel() + "';";
                PreparedStatement preparedStatement = databaseConnection.createPreparedStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                System.out.println("Got the result");
                if(resultSet.next()){
                    databaseConnection.closeConnection();
                    return "NOT";
                } else {
                    databaseConnection.closeConnection();
                    return "OK";
                }

            } catch (DataConnectionException| SQLException e) {
                e.printStackTrace();
                System.out.println("Problem in database");
                databaseConnection.closeConnection();
                return "NOT";
            }

        } else {
            try {
                Calendar cal = Calendar.getInstance();
                String dateString = new SimpleDateFormat("dd-MM-yyyy").format(cal.getTime());
                String[] dateSplit = dateString.split("-");
                String sql = "INSERT INTO " + databaseConnection.getUserTable()
                        + "(username, password, firstName, lastName, email, status, accessLevel, dayEmployment, monthEmployment, yearEmployment) VALUES ('"
                        + user.getUsername() + "', '" + user.getPassword().hashCode() + "', '" + user.getFname() + "', '" + user.getLname() + "', '" + user.getEmail() + "', '" + user.getStatus() + "', '" + user.getAccessLevel() + "', '"+ dateSplit[0] +"', '" + dateSplit[1] +"', '"+ dateSplit[2] +"')";

                PreparedStatement preparedStatement = databaseConnection.createPreparedStatement(sql);
                preparedStatement.execute();
                databaseConnection.closeConnection();

                return "OK";
            } catch (DataConnectionException | SQLException e) {
                e.printStackTrace();
                System.out.println();
                databaseConnection.closeConnection();
                return "NOT";
            }
        }
    }

    @Override
    public User getUser(String userId) {
        User user = null;
        try{
            String sql = "SELECT * FROM " + databaseConnection.getUserTable() + " WHERE users_ID = " + Integer.parseInt(userId) + ";";
            PreparedStatement preparedStatement = databaseConnection.createPreparedStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while ( resultSet.next()) {
                int id = resultSet.getInt("users_ID");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String name = resultSet.getString("firstName");
                String lastname = resultSet.getString("lastName");
                String email = resultSet.getString("email");
                String status = resultSet.getString("status");
                int day = resultSet.getInt("dayEmployment");
                int month = resultSet.getInt("monthEmployment");
                int year = resultSet.getInt("yearEmployment");
                String accessLevel = resultSet.getString("accessLevel");


                String dateString = day + "-" + month + "-" + year;
                System.out.println(dateString);
                LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd-M-yyyy"));;
                user = new User(id,  username,  password,  name,  lastname,  email,  status,  date,  accessLevel);
            }
        } catch (DataConnectionException | SQLException e) {
            e.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return user;
    }
}