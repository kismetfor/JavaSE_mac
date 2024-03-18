import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        //建立线路
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/xutao?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("3345576297ltLT");

        //建立连接
        Connection connection = dataSource.getConnection();



        //构造一个能够操作数据库的语句
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入id");
        int id = scanner.nextInt();
        System.out.println("输入姓名");
        String name = scanner.next();
        System.out.println("输入语文成绩");
        float chinese_score = scanner.nextFloat();
        System.out.println("输入数学成绩");
        float math_score = scanner.nextFloat();
        System.out.println("输入英语成绩");
        float english_score = scanner.nextFloat();


        //写语句
        /*String sql = "insert into exam_result values(" + id + ','  + name + ',' + chinese_score
                +',' +math_score+','+ english_score+ ");" ;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);*/
        // 构造 PreparedStatement 并执行插入操作
        String sql = "INSERT INTO exam_result VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setFloat(3, chinese_score);
        preparedStatement.setFloat(4, math_score);
        preparedStatement.setFloat(5, english_score);

        int n = preparedStatement.executeUpdate();
        System.out.println(n);

        preparedStatement.close();
        connection.close();
    }
}
