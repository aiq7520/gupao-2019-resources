import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/3/26 11:11
 */
public class MenuDao extends JdbcTemplate<Menu>{

    public List<Menu> queryByNames(String[] names) throws SQLException {
        StringBuffer sql =new StringBuffer("select * from mms_menu where name in (");
        for (int i=0;i<names.length;i++) {
            sql.append("?");
            if(i==names.length-1) sql.append(")");
            else sql.append(",");
        }
        System.out.println(sql.toString());
       return  super.executeQuery(new IRowMapper<Menu>() {
            public Menu parseEntity(ResultSet resultSet) throws  SQLException{
                Menu menu = new Menu();
                menu.setCreatedTime(resultSet.getDate("created_time"));
                menu.setId(resultSet.getInt("id"));
                menu.setName(resultSet.getString("name"));
                menu.setUrl(resultSet.getString("url"));
                return menu;
            }
        },sql.toString(),names);
    }
}
