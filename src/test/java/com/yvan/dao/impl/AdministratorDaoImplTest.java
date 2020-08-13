package com.yvan.dao.impl;

import junit.framework.TestCase;

public class AdministratorDaoImplTest extends TestCase {

    public void testFindByName() {
        assertTrue(new AdministratorDaoImpl().findByName("admin") != null);
    }
}