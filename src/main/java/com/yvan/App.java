package com.yvan;

import com.yvan.entity.Administrator;
import com.yvan.view.SuperAdministratorFrame;

/**
 * @author Yvan
 */

public class App {
    public static void main(String[] args) {

//        Login login = new Login();
//        login.setVisible(true);
        new SuperAdministratorFrame(new Administrator(1,"admin","123","超级管理")).setVisible(true);

    }
}
