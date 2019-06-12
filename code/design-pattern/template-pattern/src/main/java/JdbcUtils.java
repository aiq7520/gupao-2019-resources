import java.sql.*;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/3/26 10:30
 */
public class JdbcUtils {

    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (Exception e){
            System.out.println("找不到驱动类");
        }
    }
    private JdbcUtils (){}

    private static Connection conn;
    private static PreparedStatement prepareStatement;

    //这些参数我们后期往往通过配置文件来配置
    private final static String DRIVER_NAME="com.mysql.jdbc.Driver";
    private final static String URL="jdbc:mysql://192.168.1.152:3306/demo";
    private final static String USER_NAME="root";
    private final static String PASS_WORD="";

    //获取连接
    public static Connection getConnection() throws SQLException {
        conn =   DriverManager.getConnection("jdbc:mysql://192.168.1.152:3306/demo","root","");
        return conn;
    }


    public static void close(ResultSet rs ,PreparedStatement ps ,Connection conn) throws SQLException{
            rs.close();
            ps.close();
            conn.close();
    }
}
