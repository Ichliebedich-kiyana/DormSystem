package cn.login;
// 数据库连接部分

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // 数据库位置/数据库（架构）名
    private static final String URL = "jdbc:mysql://localhost:3306/db02";
    private static final String USER = "root";
    private static final String PASSWORD = "chulian123";
//    private static final String PASSWORD = "123123123";

    // 定义静态方法（方便使用类名.直接调用）
    public static Connection getConnection() throws SQLException {
        // 管理JDBC驱动程序并建立数据库连接
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
