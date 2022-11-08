import java.sql.*;

public class CheckingBalanceOfRecipient {

    static int r;
    public static int checkingBalanceOfRecipient() throws SQLException, ClassNotFoundException {

        String url = "jdbc:postgresql://localhost:5432/banking_system";
        String uname = "postgres";
        String password = "admin123";

        String query = "SELECT * FROM banking_system.accounts.users WHERE user_id = " + Account.id;

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
