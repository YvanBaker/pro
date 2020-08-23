package com.yvan.biz;

import com.yvan.entity.Freeze;

/**
 * @author Yvan
 * @Description Freeze 的 业务逻辑
 * @Classname FreezeBiz
 * @Date 2020/8/20 14:53
 */
public interface FreezeBiz {

    /**
     * 冻结用户逻辑
     *
     * @param uid    uid
     * @param reason 原因
     * @return true 成功
     */
    boolean freezeUser(int uid, String reason);

    /**
     * 解冻用户逻辑
     *
     * @param freeze 冻结记录
     * @param reason 原因
     * @return true 成功
     */
    boolean unfreezeUser(Freeze freeze, String reason);
}
