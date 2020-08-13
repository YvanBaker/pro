/*
 * Created by JFormDesigner on Thu Aug 13 13:24:57 GMT+08:00 2020
 */

package com.yvan.view;

import com.yvan.biz.impl.UserBizImpl;
import com.yvan.util.StringUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author unknown
 */
public class Registered extends JFrame {
    public Registered() {
        initComponents();
    }

    /**
     * 重置输入框
     *
     * @param e
     */
    private void resetButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        userNameTextField.setText("");
        passwordField.setText("");
        enterPasswordField.setText("");
    }

    /**
     * 点击确定
     *
     * @param e
     */
    private void registeredButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        String name = userNameTextField.getText();
        String password = String.valueOf(passwordField.getPassword());
        String enterPassword = String.valueOf(enterPasswordField.getPassword());
        if (StringUtil.isNull(name)) {
            JOptionPane.showMessageDialog(this, "账户名不能为空！！");
            return;
        }
        if (StringUtil.isNull(password)) {
            JOptionPane.showMessageDialog(this, "密码不能为空！！");
            return;
        }
        if (StringUtil.isNull(enterPassword)) {
            JOptionPane.showMessageDialog(this, "请再次确认密码！！");
            return;
        }
        if (!password.equals(enterPassword)) {
            JOptionPane.showMessageDialog(this, "两次输入的密码不一致，请再次确认！！");
            return;
        }
        boolean flag = new UserBizImpl().registered(name, password);
        if (!flag){
            JOptionPane.showMessageDialog(this, "用户名已存在，请重新命名！！");
            resetButtonActionPerformed(e);
            return;
        }
        JOptionPane.showMessageDialog(this,"注册成功！！！");
        resetButtonActionPerformed(e);
        return;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        userNameTextField = new JTextField();
        passwordField = new JPasswordField();
        enterPasswordField = new JPasswordField();
        registeredButton = new JButton();
        resetButton = new JButton();
        title = new JLabel();

        //======== this ========
        setTitle("\u6ce8\u518c\u754c\u9762");
        setFont(new Font("\u9ed1\u4f53", Font.BOLD, 16));
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u7528\u6237\u540d\uff1a");
        label1.setFont(new Font("\u6977\u4f53", Font.BOLD, 14));
        label1.setIcon(new ImageIcon("G:\\zzb\\pro\\src\\img\\user.png"));

        //---- label2 ----
        label2.setText("\u5bc6  \u7801\uff1a");
        label2.setFont(new Font("\u6977\u4f53", Font.BOLD, 14));
        label2.setIcon(new ImageIcon("G:\\zzb\\pro\\src\\img\\password.png"));

        //---- label3 ----
        label3.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");
        label3.setFont(new Font("\u6977\u4f53", Font.BOLD, 14));
        label3.setIcon(new ImageIcon("G:\\zzb\\pro\\src\\img\\password.png"));

        //---- registeredButton ----
        registeredButton.setText("\u786e\u8ba4");
        registeredButton.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
        registeredButton.setIcon(new ImageIcon("G:\\zzb\\pro\\src\\img\\\u786e\u8ba4.png"));
        registeredButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registeredButtonActionPerformed(e);
            }
        });

        //---- resetButton ----
        resetButton.setText("\u91cd\u7f6e");
        resetButton.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
        resetButton.setIcon(new ImageIcon("G:\\zzb\\pro\\src\\img\\\u91cd\u7f6e.png"));
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetButtonActionPerformed(e);
            }
        });

        //---- title ----
        title.setText("     \u7528\u6237\u6ce8\u518c");
        title.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 30));
        title.setIcon(new ImageIcon("G:\\zzb\\pro\\src\\img\\github.png"));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(registeredButton)
                                        .addGroup(contentPaneLayout.createParallelGroup()
                                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(65, 65, 65)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(enterPasswordField, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(userNameTextField, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                                                                .addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(189, 189, 189)
                                                .addComponent(resetButton)))
                                .addContainerGap(128, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addContainerGap(188, Short.MAX_VALUE)
                                .addComponent(title, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(title)
                                .addGap(14, 14, 14)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(enterPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(registeredButton)
                                        .addComponent(resetButton))
                                .addGap(28, 28, 28))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField userNameTextField;
    private JPasswordField passwordField;
    private JPasswordField enterPasswordField;
    private JButton registeredButton;
    private JButton resetButton;
    private JLabel title;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
