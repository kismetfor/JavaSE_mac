import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCdemo1 {
    //查询 和增删改 略有区别
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/xutao?characterEncoding=" +
                "utf8&&userSSL=false");
        ((MysqlDataSource) dataSource).setPassword("3345576297ltLT");
        ((MysqlDataSource) dataSource).setUser("root");

        Connection connection = dataSource.getConnection();

        String sql = "select * from exam_result";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //执行 结果集
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int chinese = resultSet.getInt("chinese");
            int math = resultSet.getInt("math");
            int english = resultSet.getInt("english");
            System.out.println("id: "+id+" name: "+name+" chinese: " +chinese+ " math: "+math
                    +" english: "+english);
        }
    }
}
