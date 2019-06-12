import java.sql.*;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/3/26 9:59
 */
public class JdbcDemo {
    public static void main(String[] args) {
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.1.152:3306/demo","root","");
            //获取预处理命令
            PreparedStatement ps = conn.prepareStatement("select * from mms_menu");
            //获取结果集
            ResultSet resultSet = ps.executeQuery();

            //解析结果集
            while (resultSet.next()){
               Menu menu = new Menu();
               menu.setCreatedTime(resultSet.getDate("created_time"));
               menu.setId(resultSet.getInt("id"));
               menu.setName(resultSet.getString("name"));
               menu.setUrl(resultSet.getString("url"));
                System.out.println(menu);
            }
            //关闭连接
            resultSet.close();
            ps.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
