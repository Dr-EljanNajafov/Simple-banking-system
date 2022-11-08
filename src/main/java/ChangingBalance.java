import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ChangingBalance {
    public static void changeBalance() throws SQLException, ClassNotFoundException {

        String url = "jdbc:postgresql://localhost:5432/banking_system";
        String uname = "postgres";
        String password = "admin123";
        String query = "UPDATE banking_system.accounts.users SET balance = " + Account.newBalanceOfSender + " WHERE password = " + Account.password;

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url, uname, password);
        Statement statement = connection.createStatement();
        int count = statement.executeUpdate(query);

        statement.close();
        connection.close();
    }
}
