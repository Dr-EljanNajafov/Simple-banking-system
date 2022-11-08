import java.sql.*;

public class CheckingBalanceOfSender {

    static int r;
    public static int checkingBalanceOfSender() throws SQLException, ClassNotFoundException {

        String url = "jdbc:postgresql://localhost:5432/banking_system";
        String uname = "postgres";
        String password = "admin123";

        String query = "SELECT * FROM banking_system.accounts.users WHERE password = " + Account.password;

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url, uname, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        resultSet.next();
        r = resultSet.getInt("balance");

        statement.close();
        connection.close();

        return r;
    }
}
