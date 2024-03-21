import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/xutao?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("3345576297ltLT");

        Connection connection = dataSource.getConnection();

        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int age = scanner.nextInt();

        String sql = "insert into my_table values (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, age);

        System.out.println(preparedStatement.executeUpdate());

        preparedStatement.close();
        connection.close();
    }
}
