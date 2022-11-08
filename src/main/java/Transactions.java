import java.sql.*;

public class Transactions {

    public void showTransaction() throws SQLException, ClassNotFoundException {

        String url = "jdbc:postgresql://localhost:5432/banking_system";
        String uname = "postgres";
        String password = "admin123";
        String query = "UPDATE banking_system.accounts.users SET balance = " + Account.newBalanceOfRecipient + " WHERE user_id = " + Account.id;

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url, uname, password);
        Statement statement = connection.createStatement();
        int count = statement.executeUpdate(query);

        System.out.println("Transaction completed");

        statement.close();
        connection.close();
    }
}
