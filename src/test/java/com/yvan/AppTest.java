package com.yvan;

import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void simTme(){
        System.out.println(new Timestamp(new Date().getTime()));
    }

    @Test
    public void map(){
        Map<Integer,Boolean> map = new HashMap<>();
        map.put(1,true);
        assertNull(map.get(2));
    }

    @Test
    public void time() throws InterruptedException {
        System.out.println(System.currentTimeMillis());
        sleep(10000);
        System.out.println(System.currentTimeMillis());
        assertTrue(true);
    }
}
