/*
 * Created by JFormDesigner on Wed Aug 19 19:20:12 GMT+08:00 2020
 */

package com.yvan.view;

import com.yvan.biz.impl.AdministratorBizImpl;
import com.yvan.entity.UserType;
import com.yvan.util.StringUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author unknown
 */
public class AdminRegisteredFrame extends JInternalFrame {
    public AdminRegisteredFrame() {
        initComponents();
    }

    /**
     * 必填输入框为空判断
     *
     * @return true 空
     */
    private boolean isNll() {
        if (StringUtil.isNull(userNameTextField.getText())) {
            JOptionPane.showMessageDialog(this, StringUtil.isNullString("账户名"));
            return true;
        }
        if (StringUtil.isNull(String.valueOf(passwordField.getPassword()))) {
            JOptionPane.showMessageDialog(this, StringUtil.isNullString("密码"));
            return true;
        }
        return false;
    }

    /**
     * 不合法检测
     *
     * @return false 合法
     */
    public boolean isNotLegal() {
        if (StringUtil.isNotLegal(userNameTextField.getText())) {
            JOptionPane.showMessageDialog(this, "用户名存在敏感词汇或字符，如 and,or或#,*");
            return true;
        }
        return false;
    }


    private void registeredButtonActionPerformed(ActionEvent e) {
        if (isNll()) {
            return;
        }
        if (isNotLegal()) {
            return;
        }
        String name = userNameTextField.getText();
        String password = String.valueOf(passwordField.getPassword());
        String enterPassword = String.valueOf(enterPasswordField.getPassword());
        UserType type = (UserType) typeComboBox.getSelectedItem();
        if (StringUtil.isNull(enterPassword)) {
            JOptionPane.showMessageDialog(this, "请再次确认密码！！");
            return;
        }
        if (!password.equals(enterPassword)) {
            JOptionPane.showMessageDialog(this, "两次输入的密码不一致，请再次确认！！");
            return;
        }
        assert type != null;
        boolean flag = new AdministratorBizImpl().registered(name, password, type);
        if (!flag) {
            JOptionPane.showMessageDialog(this, "同类型性用户名已存在，请重新命名！！");
            resetButtonActionPerformed(e);
            return;
        }
        JOptionPane.showMessageDialog(this, "注册成功！！");
        resetButtonActionPerformed(e);
    }

    private void resetButtonActionPerformed(ActionEvent e) {
        userNameTextField.setText("");
        passwordField.setText("");
        enterPasswordField.setText("");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        userNameTextField = new JTextField();
        label2 = new JLabel();
        passwordField = new JPasswordField();
        label3 = new JLabel();
        enterPasswordField = new JPasswordField();
        registeredButton = new JButton();
        resetButton = new JButton();
        title = new JLabel();
        label4 = new JLabel();
        typeComboBox = new JComboBox<>();

        //======== this ========
        setVisible(true);
        setTitle("\u7ba1\u7406\u5458\u6ce8\u518c");
        setClosable(true);
        setMaximizable(true);
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u7528\u6237\u540d\uff1a");
        label1.setFont(new Font("\u6977\u4f53", Font.BOLD, 14));
        label1.setIcon(new ImageIcon(getClass().getResource("/img/user.png")));

        //---- label2 ----
        label2.setText("\u5bc6  \u7801\uff1a");
        label2.setFont(new Font("\u6977\u4f53", Font.BOLD, 14));
        label2.setIcon(new ImageIcon(getClass().getResource("/img/password.png")));

        //---- label3 ----
        label3.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");
        label3.setFont(new Font("\u6977\u4f53", Font.BOLD, 14));
        label3.setIcon(new ImageIcon(getClass().getResource("/img/password.png")));

        //---- registeredButton ----
        registeredButton.setText("\u786e\u8ba4");
        registeredButton.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
        registeredButton.setIcon(new ImageIcon(getClass().getResource("/img/\u786e\u8ba4.png")));
        registeredButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registeredButtonActionPerformed(e);
            }
        });

        //---- resetButton ----
        resetButton.setText("\u91cd\u7f6e");
        resetButton.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
        resetButton.setIcon(new ImageIcon(getClass().getResource("/img/\u91cd\u7f6e.png")));
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetButtonActionPerformed(e);
            }
        });

        //---- title ----
        title.setText("     \u7ba1\u7406\u5458\u6ce8\u518c");
        title.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 30));
        title.setIcon(new ImageIcon(getClass().getResource("/img/github.png")));

        //---- label4 ----
        label4.setText("\u8d26\u53f7\u7c7b\u578b\uff1a");
        label4.setFont(new Font("\u6977\u4f53", Font.BOLD, 14));
        label4.setIcon(new ImageIcon(getClass().getResource("/img/usertype.png")));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(199, 199, 199)
                            .addComponent(title, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label4)
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(typeComboBox, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(enterPasswordField, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(registeredButton)
                                    .addGap(202, 202, 202)
                                    .addComponent(resetButton)
                                    .addGap(0, 0, Short.MAX_VALUE)))))
                    .addContainerGap(221, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(title)
                    .addGap(14, 14, 14)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                        .addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(43, 43, 43)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(enterPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                    .addGap(28, 28, 28)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(typeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                    .addGap(46, 46, 46)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(registeredButton)
                        .addComponent(resetButton))
                    .addGap(33, 33, 33))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        typeComboBox.setModel(new DefaultComboBoxModel<>(new UserType[]{
                UserType.ADMINISTRATOR,
                UserType.SUPERADMINISTRATOR
        }));
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JTextField userNameTextField;
    private JLabel label2;
    private JPasswordField passwordField;
    private JLabel label3;
    private JPasswordField enterPasswordField;
    private JButton registeredButton;
    private JButton resetButton;
    private JLabel title;
    private JLabel label4;
    private JComboBox<UserType> typeComboBox;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
