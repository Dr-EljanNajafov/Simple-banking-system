
import java.sql.*;
/*
* 1. import
* 2. load and register the driver
* 3. create connection
* 4. create a statement
* 5. execute the query
* 6. process result
* 7. close
*/
public class ShowingInformation {
    public void showInformation() throws SQLException, ClassNotFoundException {

        String url = "jdbc:postgresql://localhost:5432/banking_system";
        String uname = "postgres";
        String password = "admin123";
        String query = "SELECT * FROM banking_system.accounts.users WHERE password = " + Account.password;

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url, uname, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            System.out.println("================================================================");
            System.out.println("Id   |   Name   |   Surname   |   Balance");
            System.out.println();
            System.out.println();
            String r = resultSet.getInt("user_id") + " | "
                    + resultSet.getString("user_name") + " | "
                    + resultSet.getString("user_surname") + " | "
                    + resultSet.getInt("balance");
            System.out.println(r);
            System.out.println("================================================================");

        }

        statement.close();
        connection.close();
    }
}
