package com.yvan.biz.impl;

import com.yvan.biz.FreezeBiz;
import com.yvan.dao.FreezeDao;
import com.yvan.dao.impl.FreezeDaoImpl;
import com.yvan.util.TimeUtil;

/**
 * @author Yvan
 * @Description TODO
 * @Classname FreezeBizImpl
 * @Date 2020/8/20 14:57
 */
public class FreezeBizImpl implements FreezeBiz {
    private final FreezeDao freezeDao = new FreezeDaoImpl();

    @Override
    public boolean freezeUser(int uid, String reason) {
        int res = freezeDao.inset(uid, TimeUtil.getTime(), reason);
        return res > 0;
    }
}
