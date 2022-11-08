import java.sql.*;

public class AddingNewUser {

    public void addUser() throws SQLException, ClassNotFoundException {

        String url = "jdbc:postgresql://localhost:5432/banking_system";
        String uname = "postgres";
        String password = "admin123";

        String query = "INSERT INTO banking_system.accounts.users (user_name, user_surname, password) VALUES ( '" + Account.name + "' , '" + Account.surname + "' , '" + Account.password + "');";

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url, uname, password);
        Statement statement = connection.createStatement();
        int count = statement.executeUpdate(query);

        System.out.println("New user is added");


        statement.close();
        connection.close();
    }
}
