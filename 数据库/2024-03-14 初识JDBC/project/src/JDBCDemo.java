import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDemo {
    public static void main(String[] args) throws SQLException{
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/xutao?" +
                "characterEncoding=utf8&userSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("3345576297ltLT");

        Connection connection = dataSource.getConnection();

        String sql = "insert into exam_result values (12, '陈立', 98.0, 89.0, 97.0)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //execute--翻译为 执行
        int n = preparedStatement.executeUpdate();
        System.out.println("n= "+n);

        //释放语句对象和连接对象 datasourse无需释放
        //注意这里的释放顺序 需要先创建的 后释放
        // 后创建的 先释放
        preparedStatement.close();
        connection.close();
    }
    public static void main1(String[] args) throws SQLException {
        //创建数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/xutao?characterEncoding=utf8" +
                "&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("3345576297ltLT");

        //建立连接
        Connection connection = dataSource.getConnection();

        //构造sql语句
        String sql = "insert into exam_result values (10, '吴明聪', 78.0, 88.0, 89.6)";
        //执行sql语句
        PreparedStatement preparedStatement = connection.prepareStatement(sql);


        //返回值是一个int类型 表示这个操作影响了几行数据
        int n = preparedStatement.executeUpdate();


    }
}
