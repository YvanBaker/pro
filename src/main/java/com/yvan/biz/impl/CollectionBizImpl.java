package com.yvan.biz.impl;

import com.yvan.biz.CollectionBiz;
import com.yvan.dao.CollectionDao;
import com.yvan.dao.impl.CollectionDaoImpl;
import com.yvan.entity.Book;
import com.yvan.entity.Collection;
import com.yvan.entity.User;
import com.yvan.util.TimeUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yvan
 * @Description TODO
 * @Classname CollectionBizImpl
 * @Date 2020/8/18 13:11
 */
public class CollectionBizImpl implements CollectionBiz {
    private final CollectionDao collectionDao = new CollectionDaoImpl();

    @Override
    public boolean save(Book book, boolean flag) {

        return false;
    }

    @Override
    public Map<Integer, Boolean> findByUser(User user) {
        Map<Integer, Boolean> map = new HashMap<>(12);
        List<Collection> dataCollection = collectionDao.findByUid(user.getId());
        for (Collection collection : dataCollection) {
            map.put(collection.getBid(), collection.getDel());
        }
        return map;
    }

    @Override
    public boolean updateDel(User user, Book book, boolean flag) {
        Collection dataCollection = collectionDao.findByBidUid(book.getId(), user.getId());
        if (dataCollection == null) {
            collectionDao.save(user.getId(), book.getId(), TimeUtil.getTime());
        }
        int i;
        if (flag) {
            i = collectionDao.updateDelFalse(user.getId(), book.getId(), TimeUtil.getTime());
        } else {
            i = collectionDao.updateDelTrue(user.getId(), book.getId(), TimeUtil.getTime());
        }
        return i > 0;
    }
}
