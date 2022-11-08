import java.sql.*;

public class ChangingPassword {
    public void changePassword() throws SQLException, ClassNotFoundException {

        String url = "jdbc:postgresql://localhost:5432/banking_system";
        String uname = "postgres";
        String password = "admin123";
        String query = "UPDATE banking_system.accounts.users SET password = " + Account.newPassword + " WHERE password = " + Account.password;

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url, uname, password);
        Statement statement = connection.createStatement();
        int count = statement.executeUpdate(query);

        System.out.println("Your password is changed");

        statement.close();
        connection.close();
    }
}
