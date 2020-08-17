package com.yvan.dao.impl;

import com.yvan.dao.RecordDao;
import com.yvan.entity.RecordView;
import com.yvan.util.SqlUtil;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yvan
 * @Description RecordDao 的实现类
 * @Classname RecordDaoImpl
 * @Date 2020/8/17 10:08
 */
public class RecordDaoImpl extends BaseDao implements RecordDao {

    @NotNull
    private List<RecordView> creatRecordList() {
        List<RecordView> recordViews = new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                int uid = rs.getInt("uid");
                int bid = rs.getInt("bid");
                String userName = rs.getString("name");
                String bookName = rs.getString("book_name");
                String author = rs.getString("author");
                Timestamp lendTime = rs.getTimestamp("lend_time");
                Timestamp returnTime = rs.getTimestamp("return_time");
                float deposit = rs.getFloat("deposit");
                float returnTerm = rs.getFloat("return_term");
                Timestamp actualTime = rs.getTimestamp("actual_time");
                boolean isRenew = rs.getBoolean("is_renew");
                boolean isReturn = rs.getBoolean("is_return");
                recordViews.add(new RecordView(id, uid, bid, userName, bookName, author, lendTime, returnTime, deposit, returnTerm, actualTime, isRenew, isReturn));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return recordViews;
    }

    @Override
    public int save(int bookId, int userId, Timestamp lendTime, Timestamp returnTime, float deposit) {
        String table = "record";
        String field = "uid,bid,lend_time,return_time,deposit";
        String term = "?,?,?,?,?";
        String sql = SqlUtil.insert(table, field, term);
        List<Object> list = new ArrayList<>();
        list.add(userId);
        list.add(bookId);
        list.add(lendTime);
        list.add(returnTime);
        list.add(deposit);
        int res = executeUpdate(sql, list);
        closeAll();
        return res;
    }

    @Override
    public List<RecordView> findAllByUid(int uid) {
        String table = "recordView";
        String field = "id,uid,bid,name,book_name,author,lend_time,return_time,deposit,return_term,actual_time,is_renew,is_return";
        String term = "uid = ?";
        String sql = SqlUtil.select(field, table, term);
        List<RecordView> recordViews = new ArrayList<>();
        List<Object> list = new ArrayList<>();
        list.add(uid);
        executeQuery(sql, list);
        return creatRecordList();
    }

    @Override
    public List<RecordView> findIdByUidBid(int uid, int bid) {
        String table = "recordView";
        String field = "id,uid,bid,name,book_name,author,lend_time,return_time,deposit,return_term,actual_time,is_renew,is_return";
        String term = "uid = ? and bid = ?";
        String sql = SqlUtil.select(field, table, term);
        List<Object> list = new ArrayList<>();
        list.add(uid);
        list.add(bid);
        executeQuery(sql, list);
        return creatRecordList();
    }

    @Override
    public List<RecordView> findAllByStr(int uid, String str) {
        str = "%" + str + "%";
        String table = "recordView";
        String field = "id,uid,bid,name,book_name,author,lend_time,return_time,deposit,return_term,actual_time,is_renew,is_return";
        String term = "uid = ? and (book_name LIKE ? or book_name LIKE ?)";
        String sql = SqlUtil.select(field, table, term);
        List<Object> list = new ArrayList<>();
        list.add(uid);
        list.add(str);
        list.add(str);
        executeQuery(sql, list);
        return creatRecordList();
    }

    @Override
    public int updateIsReturn(int id, boolean isReturn) {
        String table = "record";
        String field = "is_return = ?";
        String term = "id = ?";
        String sql = SqlUtil.update(table, field, term);
        List<Object> list = new ArrayList<>();
        list.add(isReturn);
        list.add(id);
        int res = executeUpdate(sql, list);
        closeAll();
        return res;
    }

    @Override
    public int updateActualTime(int id, Timestamp actualTime) {
        String table = "record";
        String field = "actual_time = ?";
        String term = "id = ?";
        String sql = SqlUtil.update(table, field, term);
        List<Object> list = new ArrayList<>();
        list.add(actualTime);
        list.add(id);
        int res = executeUpdate(sql, list);
        closeAll();
        return res;
    }

    @Override
    public int updateReturnTerm(int id, float returnTerm) {
        String table = "record";
        String field = "return_term = ?";
        String term = "id = ?";
        String sql = SqlUtil.update(table, field, term);
        List<Object> list = new ArrayList<>();
        list.add(returnTerm);
        list.add(id);
        int res = executeUpdate(sql, list);
        closeAll();
        return res;
    }
}
