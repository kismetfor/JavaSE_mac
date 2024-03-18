import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/xutao?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setPassword("3345576297ltLT");
        ((MysqlDataSource) dataSource).setUser("root");

        Connection connection = dataSource.getConnection();

        Scanner scanner = new Scanner(System.in);
        String sql = scanner.next();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        System.out.println(preparedStatement.executeUpdate());
        preparedStatement.close();
        connection.close();

    }
}
