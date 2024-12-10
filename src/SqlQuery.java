import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlQuery {

    String login(String pUser, String pPass){
        try {
            String sqlLoginPasswordQuery = "SELECT stat FROM user WHERE name = '" + pUser + "' AND user_password = '" + pPass + "';";
            Statement stmt = SqlCon.getCon().createStatement();
            ResultSet rs=stmt.executeQuery(sqlLoginPasswordQuery);

            if(rs.next()){
                return rs.getString(1);
            }
            else {
                return "false";
            }
        } catch (SQLException e) {
            System.out.println(e);
            return "false";
        }
    }

    boolean register(String pUser, String pPass){
        try {
            Statement stmt = SqlCon.getCon().createStatement();
            String sqlLoginQuery = "SELECT * FROM user WHERE login = '"+ pUser + "';";
            ResultSet rs=stmt.executeQuery(sqlLoginQuery);
            if(rs.next()){
                return false;
            }
            String sqlIns = "INSERT INTO user(login,password) VALUES ('" + pUser + "','" + pPass + "')";
            stmt.executeUpdate(sqlIns);
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

}
