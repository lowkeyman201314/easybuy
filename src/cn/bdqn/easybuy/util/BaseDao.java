package cn.bdqn.easybuy.util;

import java.sql.*;

/**
 * @Author: 老鱼
 * @Date: 2019/1/9 14:47
 * @Description:
 */
public class BaseDao {

    public final static String DRIVER = "com.mysql.jdbc.Driver"; // 数据库驱动

    public final static String URL = "jdbc:mysql://localhost:3306/easybuy?characterEncoding=utf-8"; // url

    public final static String DBNAME = "root"; // 数据库用户名

    public final static String DBPASS = "root"; // 数据库密码

    protected Connection conn = null;

    protected PreparedStatement pstmt = null;

    protected ResultSet rs = null;

    /**
     * 得到数据库连接
     *
     * @return 数据库连接
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection getConn() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DRIVER); // 注册驱动
            conn = DriverManager.getConnection(URL, DBNAME, DBPASS); // 获得数据库连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 释放资源
     *
     * @param conn  数据库连接
     * @param pstmt PreparedStatement对象
     * @param rs    结果集
     */
    public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {

        /* 如果rs不空，关闭rs */
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        /* 如果pstmt不空，关闭pstmt */
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        /* 如果conn不空，关闭conn */
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 执行SQL语句，可以进行增、删、改的操作，不能执行查询
     *
     * @param sql   预编译的 SQL 语句
     * @param param 预编译的 SQL 语句中的‘？’参数的字符串数组
     * @return 影响的条数
     */
    public int executeUpdate(String sql, Object... param) {
        int num = 0;
        /* 处理SQL,执行SQL */
        try {
            getConn(); // 得到数据库连接
            pstmt = conn.prepareStatement(sql); // 得到PreparedStatement对象
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    pstmt.setObject(i + 1, param[i]); // 为预编译sql设置参数
                }
            }
            num = pstmt.executeUpdate(); // 执行SQL语句
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // 处理ClassNotFoundException异常
        } catch (SQLException e) {
            e.printStackTrace(); // 处理SQLException异常
        } finally {
            this.closeAll(conn, pstmt, null);
        }
        return num;
    }

    public ResultSet executeQuery(String preparedSql, Object... param) throws ClassNotFoundException, SQLException {
        try {
            getConn(); // 得到数据库连接
            pstmt = conn.prepareStatement(preparedSql);// 得到PreparedStatement对象
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    pstmt.setObject(i + 1, param[i]); // 为预编译sql设置参数
                }
            }
            rs = pstmt.executeQuery(); // 执行SQL语句
        } catch (SQLException e) {
            e.printStackTrace();// 处理SQLException异常
        }
        return rs;
    }

}
