package com.yvan.biz;

/**
 * @author Yvan
 * @Description Freeze 的 业务逻辑
 * @Classname FreezeBiz
 * @Date 2020/8/20 14:53
 */
public interface FreezeBiz {

    /**
     * 冻结用户
     *
     * @param uid uid
     * @param reason 原因
     * @return true 成功
     */
    boolean freezeUser(int uid, String reason);
}
