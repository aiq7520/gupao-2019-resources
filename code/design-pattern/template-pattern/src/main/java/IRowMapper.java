import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/3/26 10:46
 */
public interface IRowMapper<T> {
    T parseEntity(ResultSet rs)throws SQLException;
}
