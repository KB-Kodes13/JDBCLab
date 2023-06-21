import java.sql.*;

public class DatabaseConnector {
    public Connection connect() {
        Connection connection = null;
        try {
            String url = "jdbc:sqlite:C:\\Users\\admin\\Desktop\\CTAC104\\SQLite\\Bookstore.db";
            String username = "Kelan";
            String password = "KB2013$";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Successfully connected to the database!");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database.");
            e.printStackTrace();
        }
        return connection;
    }

//    public void selectAllBooks() {
//        String sql = "SELECT * FROM books";
//        try (Connection connection = this.connect();
//             Statement stmt  = connection.createStatement();
//             ResultSet rs    = stmt.executeQuery(sql)) {
//
//            while (rs.next()) {
//                System.out.println(rs.getString("title") + "\t" +
//                        rs.getString("author") + "\t" +
//                        rs.getDouble("price"));
//            }
//        } catch (SQLException e) {
//            System.out.println("Error executing SELECT statement");
//            e.printStackTrace();
//        }
//    }
public void selectAllBooks() {
    Connection connection = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
        connection = this.connect();
        String sql = "SELECT * FROM books";
        stmt = connection.createStatement();
        rs = stmt.executeQuery(sql);

        while (rs.next()) {
            System.out.println(rs.getString("title") + "\t" +
                    rs.getString("author") + "\t" +
                    rs.getDouble("price"));
        }
    } catch (SQLException e) {
        System.out.println("Error executing SELECT statement");
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
            System.out.println("The connection is closed");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error in system!");
        }
    }
    }
}
