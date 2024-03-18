import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public class JDBCDemo {
    public static void main(String[] args) {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setUrl("jdb:mysql://127.0.0.1:3306/xutao?characterEncoding=utf8&useSSL=false");

    }
}
