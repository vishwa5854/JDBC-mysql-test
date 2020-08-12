import java.sql.*;

public class MySQLConnection {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crueger", "root", "password");
        String name = "Srinivas";
        String query = "INSERT INTO lol (name) values ( ? )";
        insert(query, name, connection);
        retrieve("select *from lol", connection);
        connection.close();
    }


    private static void insert(String query, String params, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, params);
        preparedStatement.execute();
    }

    private static void retrieve(String query, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
        }
    }

}
