import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/3/26 11:23
 */
public class MenuDaoTest {

    @Test
    public void queryByNames() throws SQLException {
        String[] names = {"${pageGenerate}","短信平台","接口管理"};
        MenuDao menuDao = new MenuDao();
       List<Menu> menus =  menuDao.queryByNames(names);
        for (Menu menu:menus) {
            System.out.println(menu);
        }
    }
}