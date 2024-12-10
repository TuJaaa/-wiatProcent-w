import java.sql.*;

class SqlCon {

    static Connection con;

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/swiat_alkoholi", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getCon() {
        return con;
    }

}