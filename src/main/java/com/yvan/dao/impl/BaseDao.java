package com.yvan.dao.impl;

import com.yvan.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BaseDao {
    protected Connection conn;
    protected PreparedStatement ps;
    protected ResultSet rs;

    /**
     * 获取Connection连接
     */
    public void getConn() {
        this.conn = JdbcUtil.getConn();
    }

    /**
     * 关闭Connection连接
     */
    public void closeConn() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭其他流
     *
     * @param ps
     * @param rs
     */
    protected void closeIter(PreparedStatement ps, ResultSet rs) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭PreparedStatement流
     *
     * @param ps PreparedStatement流
     */
    protected void closePreparedStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭ResultSet流
     *
     * @param rs ResultSet流
     */
    protected void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void closeAll(){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 执行PreparedStatement的executeQuery操作
     *
     * @param sql  sql语句
     * @param list 参数列表
     * @return 执行条数
     */
    protected void executeQuery(String sql, List<Object> list) {
        ps = null;
        rs = null;
        getConn();
        try {
            ps = conn.prepareStatement(sql);
            int i = 1;
            for (Object o : list) {
                ps.setObject(i++, o);
            }
            rs =  ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 执行PreparedStatement的executeUpdate操作
     *
     * @param sql  sql语句
     * @param list 参数列表
     * @return ResultSet集合
     */
    protected int executeUpdate(String sql, List<Object> list) {
        int res = 0;
        getConn();
        try {
            ps = conn.prepareStatement(sql);
            int i = 1;
            for (Object o : list) {
                ps.setObject(i++, o);
            }
            res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
