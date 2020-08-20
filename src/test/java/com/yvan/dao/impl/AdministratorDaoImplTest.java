package com.yvan.dao.impl;

import junit.framework.TestCase;

public class AdministratorDaoImplTest extends TestCase {

    public void testFindByName() {
        assertNotNull(new AdministratorDaoImpl().findByName("admin", "管理员"));
    }
}