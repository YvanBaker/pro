package com.yvan;

import com.yvan.util.JdbcUtil;
import com.yvan.view.Login;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        JdbcUtil.getConn();
        new Login().setVisible(true);
        System.out.println( "Hello World!" );
    }
}
