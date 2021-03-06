/*
 * Created by JFormDesigner on Thu Aug 13 11:57:57 GMT+08:00 2020
 */

package com.yvan.view;

import com.yvan.biz.AdministratorBiz;
import com.yvan.biz.ReservationBiz;
import com.yvan.biz.UserBiz;
import com.yvan.biz.impl.AdministratorBizImpl;
import com.yvan.biz.impl.ReservationBizImpl;
import com.yvan.biz.impl.UserBizImpl;
import com.yvan.entity.Administrator;
import com.yvan.entity.Book;
import com.yvan.entity.User;
import com.yvan.entity.UserType;
import com.yvan.util.TimeUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author unknown
 */
public class SuperAdministratorFrame extends JFrame {
    private Administrator administrator;
    private User user;
    private final AdministratorBiz administratorBiz = new AdministratorBizImpl();
    private final UserBiz userBiz = new UserBizImpl();
    private final ReservationBiz reservationBiz = new ReservationBizImpl();

    public SuperAdministratorFrame() {
        initComponents();
    }

    public SuperAdministratorFrame(Administrator administrator) {
        this.administrator = administrator;
        initComponents();
    }

    public SuperAdministratorFrame(User user) {
        this.user = user;
        initComponents();
    }


    /**
     * 选择关于我们的响应
     *
     * @param e 点击的按钮
     */
    private void menuItem6ActionPerformed(ActionEvent e) {
        StringBuffer info = new StringBuffer(" -- Yvan -- 出品\n");
        info.append("邮箱：1565924134@qq.com\n");
        info.append("电话：12345678901");
        String[] button = {"ok", "一会"};
        JOptionPane.showOptionDialog(this, info, "关于我们", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE, new ImageIcon(getClass().getResource("/img/logo.png")), button, null);
    }

    /**
     * 选择添加图书的响应
     * 在desktopPane中添加一个子窗口
     *
     * @param e 点击的按钮
     */
    private void addBookActionPerformed(ActionEvent e) {
        AddBookFrame addBookFrame = new AddBookFrame();
        addBookFrame.pack();
        addBookFrame.setVisible(true);
        desktopPane.add(addBookFrame);
    }

    /**
     * 选择返回登录响应
     *
     * @param e 点击的按钮
     */
    private void backToLoginActionPerformed(ActionEvent e) {
        new Login().setVisible(true);
        this.dispose();
    }

    /**
     * 选择退出系统的响应
     *
     * @param e 事件
     */
    private void exitActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    /**
     * 点击查看书籍的响应
     *
     * @param e 事件
     */
    private void showBookMenuItemActionPerformed(ActionEvent e) {
        BookUpData bookUpData = new BookUpData();
        bookUpData.pack();
        bookUpData.setVisible(true);
        desktopPane.add(bookUpData);
    }

    /**
     * 点击修改密码的响应
     *
     * @param e 事件
     */
    private void changePasswordMenuItemActionPerformed(ActionEvent e) {
        ChangePasswordFrame changePasswordFrame;
        if (administrator != null) {
            changePasswordFrame = new ChangePasswordFrame(administrator);
        } else {
            changePasswordFrame = new ChangePasswordFrame(user);
        }
        changePasswordFrame.pack();
        changePasswordFrame.setVisible(true);
        desktopPane.add(changePasswordFrame);
    }

    /**
     * 点击借书的响应
     *
     * @param e 事件
     */
    private void borrowBookMenuItemActionPerformed(ActionEvent e) {
        BorrowBookFrame borrowBookFrame = new BorrowBookFrame(user);
        borrowBookFrame.pack();
        borrowBookFrame.setVisible(true);
        desktopPane.add(borrowBookFrame);
    }

    /**
     * 点击还书的响应
     *
     * @param e 事件
     */
    private void returnBookMenuItemActionPerformed(ActionEvent e) {
        ReturnBookFrame returnBookFrame = new ReturnBookFrame(user);
        returnBookFrame.pack();
        returnBookFrame.setVisible(true);
        desktopPane.add(returnBookFrame);
    }

    /**
     * 点击预约的响应
     *
     * @param e 事件
     */
    private void reservatioMenuItemActionPerformed(ActionEvent e) {
        ReservationFrame reservationFrame = new ReservationFrame(user);
        reservationFrame.pack();
        reservationFrame.setVisible(true);
        desktopPane.add(reservationFrame);
    }

    /**
     * 登录时发生的响应
     *
     * @param e 事件
     */
    private void thisWindowOpened(WindowEvent e) {
        Timestamp time = TimeUtil.getTime();
        if (user == null) {
            return;
        }
        List<Book> reservation = reservationBiz.findReservation(user);
        if (reservation == null || reservation.isEmpty()){
            return;
        }
        StringBuffer str = new StringBuffer("您预约的：\n");
        for (Book book : reservation) {
            str.append(book.getBookName()).append("\n");
        }
        str.append("已经有库存了,请假借阅！！！");
        JOptionPane.showMessageDialog(this, str);
    }

    /**
     * 点击评论的响应
     *
     * @param e 事件
     */
    private void commentMenuItemActionPerformed(ActionEvent e) {
        CommentFrame commentFrame = new CommentFrame(user);
        commentFrame.pack();
        commentFrame.setVisible(true);
        desktopPane.add(commentFrame);
    }

    /**
     * 点击管理员注册的响应
     *
     * @param e 事件
     */
    private void adminMenuItem3ActionPerformed(ActionEvent e) {
        AdminRegisteredFrame adminRegisteredFrame = new AdminRegisteredFrame();
        adminRegisteredFrame.pack();
        adminRegisteredFrame.setVisible(true);
        desktopPane.add(adminRegisteredFrame);
    }

    /**
     * 点击用户管理的响应
     *
     * @param e 事件
     */
    private void userManageMenuItemActionPerformed(ActionEvent e) {
        UserManageFrame userManageFrame = new UserManageFrame();
        userManageFrame.pack();
        userManageFrame.setVisible(true);
        desktopPane.add(userManageFrame);
    }

    /**
     * 点击充值的响应
     *
     * @param e 事件
     */
    private void rechargeMenuItemActionPerformed(ActionEvent e) {
        RechargeFrame rechargeFrame = new RechargeFrame(user);
        rechargeFrame.pack();
        rechargeFrame.setVisible(true);
        desktopPane.add(rechargeFrame);
    }

    /**
     * 自动生成窗体的代码
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        changePasswordMenuItem = new JMenuItem();
        backToLogin = new JMenuItem();
        exit = new JMenuItem();
        menu2 = new JMenu();
        adminMenuItem = new JMenuItem();
        userManageMenuItem = new JMenuItem();
        rechargeMenuItem = new JMenuItem();
        menu3 = new JMenu();
        addBook = new JMenuItem();
        showBookMenuItem = new JMenuItem();
        borrowBookMenuItem = new JMenuItem();
        returnBookMenuItem = new JMenuItem();
        reservatioMenuItem = new JMenuItem();
        commentMenuItem = new JMenuItem();
        menu4 = new JMenu();
        menuItem6 = new JMenuItem();
        desktopPane = new JDesktopPane();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("\u7ba1\u7406\u5458\u4e3b\u754c\u9762");
        setIconImage(new ImageIcon(getClass().getResource("/img/logo.png")).getImage());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                thisWindowOpened(e);
            }
        });
        Container contentPane = getContentPane();

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u7cfb\u7edf\u8bbe\u7f6e");
                menu1.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
                menu1.setIcon(new ImageIcon(getClass().getResource("/img/\u7cfb\u7edf\u8bbe\u7f6e.png")));

                //---- changePasswordMenuItem ----
                changePasswordMenuItem.setText("\u4fee\u6539\u5bc6\u7801");
                changePasswordMenuItem.setIcon(new ImageIcon(getClass().getResource("/img/\u4fee\u6539\u5bc6\u7801.png")));
                changePasswordMenuItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        changePasswordMenuItemActionPerformed(e);
                    }
                });
                menu1.add(changePasswordMenuItem);

                //---- backToLogin ----
                backToLogin.setText("\u8fd4\u56de\u767b\u9646");
                backToLogin.setIcon(new ImageIcon(getClass().getResource("/img/\u8fd4\u56de.png")));
                backToLogin.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        backToLoginActionPerformed(e);
                    }
                });
                menu1.add(backToLogin);

                //---- exit ----
                exit.setText("\u9000\u51fa\u7cfb\u7edf");
                exit.setIcon(new ImageIcon(getClass().getResource("/img/\u9000\u51fa\u7cfb\u7edf.png")));
                exit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        exitActionPerformed(e);
                    }
                });
                menu1.add(exit);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("\u7528\u6237\u7ba1\u7406");
                menu2.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
                menu2.setIcon(new ImageIcon(getClass().getResource("/img/\u7528\u6237\u7ba1\u7406.png")));

                //---- adminMenuItem ----
                adminMenuItem.setText("\u7ba1\u7406\u5458\u6ce8\u518c");
                adminMenuItem.setIcon(new ImageIcon(getClass().getResource("/img/\u7ba1\u7406\u5458.png")));
                adminMenuItem.setVisible(false);
                adminMenuItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        adminMenuItem3ActionPerformed(e);
                    }
                });
                menu2.add(adminMenuItem);

                //---- userManageMenuItem ----
                userManageMenuItem.setText("\u666e\u901a\u7528\u6237\u7ba1\u7406");
                userManageMenuItem.setIcon(new ImageIcon(getClass().getResource("/img/\u7528\u6237.png")));
                userManageMenuItem.setVisible(false);
                userManageMenuItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        userManageMenuItemActionPerformed(e);
                    }
                });
                menu2.add(userManageMenuItem);

                //---- rechargeMenuItem ----
                rechargeMenuItem.setText("\u7528\u6237\u5145\u503c");
                rechargeMenuItem.setIcon(new ImageIcon(getClass().getResource("/img/\u5145\u503c.png")));
                rechargeMenuItem.setVisible(false);
                rechargeMenuItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        rechargeMenuItemActionPerformed(e);
                    }
                });
                menu2.add(rechargeMenuItem);
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("\u56fe\u4e66\u7ba1\u7406");
                menu3.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
                menu3.setIcon(new ImageIcon(getClass().getResource("/img/\u56fe\u4e66\u7ba1\u7406.png")));

                //---- addBook ----
                addBook.setText("\u6dfb\u52a0\u56fe\u4e66");
                addBook.setIcon(new ImageIcon(getClass().getResource("/img/\u6dfb\u52a0.png")));
                addBook.setVisible(false);
                addBook.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addBookActionPerformed(e);
                    }
                });
                menu3.add(addBook);

                //---- showBookMenuItem ----
                showBookMenuItem.setText("\u67e5\u770b\u56fe\u4e66");
                showBookMenuItem.setIcon(new ImageIcon(getClass().getResource("/img/\u67e5\u770b.png")));
                showBookMenuItem.setVisible(false);
                showBookMenuItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showBookMenuItemActionPerformed(e);
                    }
                });
                menu3.add(showBookMenuItem);

                //---- borrowBookMenuItem ----
                borrowBookMenuItem.setText("\u501f\u4e66");
                borrowBookMenuItem.setIcon(new ImageIcon(getClass().getResource("/img/\u501f\u4e66.png")));
                borrowBookMenuItem.setVisible(false);
                borrowBookMenuItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        borrowBookMenuItemActionPerformed(e);
                    }
                });
                menu3.add(borrowBookMenuItem);

                //---- returnBookMenuItem ----
                returnBookMenuItem.setText("\u8fd8\u4e66");
                returnBookMenuItem.setIcon(new ImageIcon(getClass().getResource("/img/\u56fe\u4e66\u5f52\u8fd8.png")));
                returnBookMenuItem.setVisible(false);
                returnBookMenuItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        returnBookMenuItemActionPerformed(e);
                    }
                });
                menu3.add(returnBookMenuItem);

                //---- reservatioMenuItem ----
                reservatioMenuItem.setText("\u9884\u7ea6");
                reservatioMenuItem.setIcon(new ImageIcon(getClass().getResource("/img/\u9884\u7ea6.png")));
                reservatioMenuItem.setVisible(false);
                reservatioMenuItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        reservatioMenuItemActionPerformed(e);
                    }
                });
                menu3.add(reservatioMenuItem);

                //---- commentMenuItem ----
                commentMenuItem.setText("\u8bc4\u8bba");
                commentMenuItem.setIcon(new ImageIcon(getClass().getResource("/img/\u8bc4\u8bba.png")));
                commentMenuItem.setVisible(false);
                commentMenuItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        commentMenuItemActionPerformed(e);
                    }
                });
                menu3.add(commentMenuItem);
            }
            menuBar1.add(menu3);

            //======== menu4 ========
            {
                menu4.setText("\u5e2e\u52a9");
                menu4.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
                menu4.setIcon(new ImageIcon(getClass().getResource("/img/\u5e2e\u52a9.png")));

                //---- menuItem6 ----
                menuItem6.setText("\u5173\u4e8e\u6211\u4eec");
                menuItem6.setIcon(new ImageIcon(getClass().getResource("/img/\u5173\u4e8e\u6211\u4eec.png")));
                menuItem6.setFont(new Font("\u6977\u4f53", Font.BOLD, 14));
                menuItem6.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuItem6ActionPerformed(e);
                    }
                });
                menu4.add(menuItem6);
            }
            menuBar1.add(menu4);
        }
        setJMenuBar(menuBar1);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 1883, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 903, Short.MAX_VALUE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        if (administrator != null){
            if (administrator.getType().equals(UserType.SUPERADMINISTRATOR.toString())){
                adminMenuItem.setVisible(true);
            }
            userManageMenuItem.setVisible(true);
            addBook.setVisible(true);
            showBookMenuItem.setVisible(true);
        }
        if (user != null){
            rechargeMenuItem.setVisible(true);
            borrowBookMenuItem.setVisible(true);
            returnBookMenuItem.setVisible(true);
            reservatioMenuItem.setVisible(true);
            commentMenuItem.setVisible(true);
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem changePasswordMenuItem;
    private JMenuItem backToLogin;
    private JMenuItem exit;
    private JMenu menu2;
    private JMenuItem adminMenuItem;
    private JMenuItem userManageMenuItem;
    private JMenuItem rechargeMenuItem;
    private JMenu menu3;
    private JMenuItem addBook;
    private JMenuItem showBookMenuItem;
    private JMenuItem borrowBookMenuItem;
    private JMenuItem returnBookMenuItem;
    private JMenuItem reservatioMenuItem;
    private JMenuItem commentMenuItem;
    private JMenu menu4;
    private JMenuItem menuItem6;
    private JDesktopPane desktopPane;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
