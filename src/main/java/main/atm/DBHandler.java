package main.atm;

import java.sql.*;

public class DBHandler {

    public static Connection getDbConnection() throws SQLException, ClassNotFoundException {
        String connectionString = "jdbc:mysql://" + "127.0.0.1" +":" + "3306" + "/" + "ATM";
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection dbConnection = DriverManager.getConnection(connectionString, "root", "0258025v");
        return dbConnection;
    }


    public void signUpUser(User user) {
        String insert ="INSERT INTO" + " atm.users" + "(cardNumber" + ",CVV" + ",balance)" + " VALUES(?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getCardNumber());
            prSt.setString(2, user.getCVV());
            prSt.setInt(3, user.getBalance());
            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public ResultSet getUser(User user) {
        ResultSet resSet = null;
        String select = "SELECT * FROM atm.users WHERE cardNumber =? AND CVV =?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getCardNumber());
            prSt.setString(2, user.getCVV());

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return resSet;
    }
}
