/*
 * Created by JFormDesigner on Wed Aug 12 22:45:03 GMT+08:00 2020
 */

package com.yvan.view;

import com.yvan.biz.impl.AdministratorBizImpl;
import com.yvan.biz.impl.UserBizImpl;
import com.yvan.entity.Administrator;
import com.yvan.entity.User;
import com.yvan.entity.UserType;
import com.yvan.util.StringUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author unknown
 */
public class Login extends JFrame {
    private Administrator administrator;
    private User user;

    public Login() {
        initComponents();
    }

    /**
     * typeComboBox.setModel(new DefaultComboBoxModel<>(new UserType[]{
     *                 UserType.USER,
     *                 UserType.ADMINISTRATOR,
     *                 UserType.SUPERADMINISTRATOR,
     *         }))
     */


    /**
     * 重置输入
     *
     * @param e
     */
    private void resetButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        userNameTextField.setText("");
        passwordField.setText("");
        typeComboBox.setSelectedIndex(0);
    }

    /**
     * 管理员登录
     *
     * @param userName 管理名字
     * @param password 密码
     * @param type     类型
     */
    private void administratorLogin(String userName, String password, String type) {
        administrator = new AdministratorBizImpl().login(userName, password, type);
        if (administrator == null) {
            JOptionPane.showMessageDialog(this, "账户或密码错误！！");
            return;
        }
        if (administrator.getDel()) {
            JOptionPane.showMessageDialog(this, "账户已经被注销了！！");
            administrator = null;
            return;
        }
        this.dispose();
        new SuperAdministratorFrame().setVisible(true);
    }


    private void registeredButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        new Registered().setVisible(true);
    }

    private void loginButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        String userName = userNameTextField.getText();
        String password = String.valueOf(passwordField.getPassword());
        if (StringUtil.isNull(userName)) {
            JOptionPane.showMessageDialog(this, "账户不能为空！！");
            return;
        }
        if (StringUtil.isNull(password)) {
            JOptionPane.showMessageDialog(this, "密码不能为空！！");
            return;
        }
        UserType type = (UserType) typeComboBox.getSelectedItem();
        switch (type) {
            case USER:
                userLogin(userName, password);
                break;
            case ADMINISTRATOR:
            case SUPERADMINISTRATOR:
                administratorLogin(userName, password, type.getType());
                break;
        }
    }

    private void userLogin(String userName, String password) {
        user = new UserBizImpl().login(userName, password);
        if (user == null) {
            JOptionPane.showMessageDialog(this, "账户或密码错误！！");
            return;
        }
        if (user.getDel()) {
            JOptionPane.showMessageDialog(this, "账户已经被注销了！！");
            user = null;
            return;
        }
        if (user.getFreeze()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("账号因欠款");
            stringBuffer.append(user.getPoint());
            stringBuffer.append("，已经被冻结，请及时充值！！");
            JOptionPane.showMessageDialog(this, stringBuffer);
            return;
        }
        this.dispose();
        new SuperAdministratorFrame().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        title = new JLabel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        userNameTextField = new JTextField();
        passwordField = new JPasswordField();
        typeComboBox = new JComboBox<>();
        resetButton = new JButton();
        loginButton = new JButton();
        registeredButton = new JButton();

        //======== this ========
        setFont(new Font("\u9ed1\u4f53", Font.BOLD, 16));
        setTitle("\u767b\u5f55\u754c\u9762");
        Container contentPane = getContentPane();

        //---- title ----
        title.setText("     \u56fe\u4e66\u7ba1\u767b\u5f55");
        title.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 30));
        title.setIcon(new ImageIcon("G:\\zzb\\pro\\src\\img\\github.png"));

        //---- label1 ----
        label1.setText("\u7528\u6237\u540d\uff1a");
        label1.setFont(new Font("\u6977\u4f53", Font.BOLD, 14));
        label1.setIcon(new ImageIcon("G:\\zzb\\pro\\src\\img\\user.png"));

        //---- label2 ----
        label2.setText("\u5bc6  \u7801\uff1a");
        label2.setFont(new Font("\u6977\u4f53", Font.BOLD, 14));
        label2.setIcon(new ImageIcon("G:\\zzb\\pro\\src\\img\\password.png"));

        //---- label3 ----
        label3.setText("\u8d26\u53f7\u7c7b\u578b\uff1a");
        label3.setFont(new Font("\u6977\u4f53", Font.BOLD, 14));
        label3.setIcon(new ImageIcon("G:\\zzb\\pro\\src\\img\\usertype.png"));

        //---- userNameTextField ----
        userNameTextField.setFont(new Font("\u65b0\u5b8b\u4f53", Font.BOLD, 14));

        //---- typeComboBox ----
        typeComboBox.setModel(new DefaultComboBoxModel<>(new UserType[]{
                UserType.USER,
                UserType.ADMINISTRATOR,
                UserType.SUPERADMINISTRATOR,
        }));

        //---- resetButton ----
        resetButton.setText("\u91cd\u7f6e");
        resetButton.setFont(new Font("\u6977\u4f53", Font.BOLD, 14));
        resetButton.setIcon(new ImageIcon("G:\\zzb\\pro\\src\\img\\\u91cd\u7f6e.png"));
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetButtonActionPerformed(e);
            }
        });

        //---- loginButton ----
        loginButton.setText("\u767b\u5f55");
        loginButton.setFont(new Font("\u6977\u4f53", Font.BOLD, 14));
        loginButton.setIcon(new ImageIcon("G:\\zzb\\pro\\src\\img\\\u767b\u5f55.png"));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginButtonActionPerformed(e);
            }
        });

        //---- registeredButton ----
        registeredButton.setText("\u6ce8\u518c");
        registeredButton.setIcon(new ImageIcon("G:\\zzb\\pro\\src\\img\\\u6ce8\u518c.png"));
        registeredButton.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
        registeredButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registeredButtonActionPerformed(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(203, 203, 203)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(title, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(contentPaneLayout.createSequentialGroup()
                                                        .addComponent(loginButton)
                                                        .addGap(52, 52, 52)
                                                        .addComponent(registeredButton)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                                        .addComponent(resetButton))
                                                .addGroup(contentPaneLayout.createSequentialGroup()
                                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(userNameTextField, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                                                .addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                                                .addComponent(typeComboBox, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))))
                                .addContainerGap(165, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(title)
                                .addGap(62, 62, 62)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label1)
                                        .addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label2)
                                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label3)
                                        .addComponent(typeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(loginButton)
                                                .addComponent(registeredButton))
                                        .addComponent(resetButton, GroupLayout.Alignment.TRAILING))
                                .addGap(68, 68, 68))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel title;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField userNameTextField;
    private JPasswordField passwordField;
    private JComboBox<UserType> typeComboBox;
    private JButton resetButton;
    private JButton loginButton;
    private JButton registeredButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
