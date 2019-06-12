import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/3/26 10:42
 */
public abstract class JdbcTemplate<T> {
    /**
     * 查询
     * @param mapper 要映射结果集实体的实现类
     * @param sql sql查询语句
     * @param params sql查询参数
     * @return sql查询返回的集合
     * @throws SQLException
     */
    public List<T> executeQuery(IRowMapper<T> mapper,String sql ,Object...params)throws SQLException {
        Connection conn =JdbcUtils.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        if(params!=null)
        for (int i=0;i<params.length;i++)
            ps.setObject(i+1,params[i]);
        ResultSet resultSet = ps.executeQuery();
        List<T> queryList = new ArrayList<T>();
        while (resultSet.next()){
            //此处的逻辑是根据不同的实体集来实现的不同业务逻辑，是可变的，我们将其抽象出来。
            //等待子类去完成此业务
            T entity = mapper.parseEntity(resultSet);
            queryList.add(entity);
        }
        JdbcUtils.close(resultSet,ps,conn);
        return queryList;
    }

}
