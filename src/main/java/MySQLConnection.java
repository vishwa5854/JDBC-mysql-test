import java.sql.*;

public class MySQLConnection {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crueger", "root", "password");
        Statement statement = connection.createStatement();
        String query = "select * from lol";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
        }
        connection.close();
    }
}
