/*
 * Created by JFormDesigner on Thu Aug 13 11:57:57 GMT+08:00 2020
 */

package com.yvan.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author unknown
 */
public class SuperAdministratorFrame extends JFrame {
    public SuperAdministratorFrame() {
        initComponents();
    }

    /**
     * 选择关于我们的响应
     *
     * @param e 点击的按钮
     */
    private void menuItem6ActionPerformed(ActionEvent e) {
        // TODO add your code here
        StringBuffer info = new StringBuffer(" -- Yvan -- 出品\n");
        info.append("邮箱：1565924134@qq.com\n");
        info.append("电话：12345678901");
        String[] button = {"ok", "一会"};
        JOptionPane.showOptionDialog(this, info, "关于我们", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE, new ImageIcon(getClass().getResource("/com/yvan/img/logo.png")), button, null);
    }

    /**
     * 选择添加图书的响应
     * 在desktopPane中添加一个子窗口
     *
     * @param e 点击的按钮
     */
    private void addBookActionPerformed(ActionEvent e) {
        // TODO add your code here
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
        // TODO add your code here
        new Login().setVisible(true);
        this.dispose();
    }

    private void exitActionPerformed(ActionEvent e) {
        // TODO add your code here
        System.exit(0);
    }

    /**
     * 自动生成窗体的代码
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        backToLogin = new JMenuItem();
        exit = new JMenuItem();
        menu2 = new JMenu();
        menuItem3 = new JMenuItem();
        menuItem4 = new JMenuItem();
        menu3 = new JMenu();
        addBook = new JMenuItem();
        menuItem7 = new JMenuItem();
        menu4 = new JMenu();
        menuItem6 = new JMenuItem();
        desktopPane = new JDesktopPane();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("\u7ba1\u7406\u5458\u4e3b\u754c\u9762");
        setIconImage(new ImageIcon(getClass().getResource("/img/logo.png")).getImage());
        Container contentPane = getContentPane();

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u7cfb\u7edf\u8bbe\u7f6e");
                menu1.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
                menu1.setIcon(new ImageIcon(getClass().getResource("/img/\u7cfb\u7edf\u8bbe\u7f6e.png")));

                //---- menuItem1 ----
                menuItem1.setText("\u4fee\u6539\u5bc6\u7801");
                menuItem1.setIcon(new ImageIcon(getClass().getResource("/img/\u4fee\u6539\u5bc6\u7801.png")));
                menu1.add(menuItem1);

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

                //---- menuItem3 ----
                menuItem3.setText("text");
                menu2.add(menuItem3);

                //---- menuItem4 ----
                menuItem4.setText("text");
                menu2.add(menuItem4);
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
                addBook.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addBookActionPerformed(e);
                    }
                });
                menu3.add(addBook);

                //---- menuItem7 ----
                menuItem7.setText("\u67e5\u770b\u56fe\u4e66");
                menuItem7.setIcon(new ImageIcon(getClass().getResource("/img/\u67e5\u770b.png")));
                menu3.add(menuItem7);
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
                        .addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 1103, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem backToLogin;
    private JMenuItem exit;
    private JMenu menu2;
    private JMenuItem menuItem3;
    private JMenuItem menuItem4;
    private JMenu menu3;
    private JMenuItem addBook;
    private JMenuItem menuItem7;
    private JMenu menu4;
    private JMenuItem menuItem6;
    private JDesktopPane desktopPane;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
