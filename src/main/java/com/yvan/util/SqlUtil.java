package com.yvan.util;

import org.jetbrains.annotations.NotNull;

/**
 * @author Yvan
 * @Description Sql语句拼接工具类
 * @Classname SqlUtil
 * @Date 2020/8/16 10:05
 */
public class SqlUtil {
    /**
     * 查询语句
     *
     * @param field 查询的字段
     * @param table 表
     * @return select [field] from [table]
     */
    @NotNull
    public static String select(String field, String table) {
        StringBuffer res = new StringBuffer("Select ");
        res.append(field);
        res.append(" from ");
        res.append(table);
        return res.toString();
    }

    /**
     * 条件查询语句
     *
     * @param field 查询的字段
     * @param table 表
     * @param term  条件
     * @return select [field] from [table] where [term]
     */
    @NotNull
    public static String select(String field, String table, String term) {
        StringBuffer res = new StringBuffer("Select ");
        res.append(field);
        res.append(" from ");
        res.append(table);
        res.append(" where ");
        res.append(term);
        return res.toString();
    }

    /**
     * 整表按照顺序插入
     *
     * @param table 表名
     * @param term  字段
     * @return INSERT INTO [table] VALUE ([term])
     */
    @NotNull
    public static String insert(String table, String term) {
        StringBuffer res = new StringBuffer("INSERT INTO ");
        res.append(table);
        res.append(" VALUE ");
        res.append("(");
        res.append(term);
        res.append(")");
        return res.toString();
    }

    /**
     * 顺序插入语句
     *
     * @param table 表
     * @param field 字段
     * @param term  值
     * @return INSERT INTO [table]([field]) VALUE ([term])
     */
    @NotNull
    public static String insert(String table, String field, String term) {
        StringBuffer res = new StringBuffer("INSERT INTO ");
        res.append(table);
        res.append("(");
        res.append(field);
        res.append(")");
        res.append(" VALUE ");
        res.append("(");
        res.append(term);
        res.append(")");
        return res.toString();
    }

    /**
     * 更新数据语句
     *
     * @param table 表
     * @param field 字段
     * @param term  条件
     * @return UPDATE [table] SET [field] WHERE [term]
     */
    @NotNull
    public static String update(String table, String field, String term) {
        StringBuffer res = new StringBuffer("UPDATE ");
        res.append(table);
        res.append(" SET ");
        res.append(field);
        res.append(" WHERE ");
        res.append(term);
        return res.toString();
    }

    /**
     * 删除语句
     *
     * @param table 表名
     * @param term  条件
     * @return
     */
    @NotNull
    public static String delete(String table, String term) {
        StringBuffer res = new StringBuffer("'DELETE FROM ");
        res.append(table);
        res.append(" WHERE ");
        res.append(term);
        return res.toString();
    }
}
