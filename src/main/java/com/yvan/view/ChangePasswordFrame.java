/*
 * Created by JFormDesigner on Sun Aug 16 17:09:20 GMT+08:00 2020
 */

package com.yvan.view;

import com.yvan.biz.AdministratorBiz;
import com.yvan.biz.UserBiz;
import com.yvan.biz.impl.AdministratorBizImpl;
import com.yvan.biz.impl.UserBizImpl;
import com.yvan.entity.Administrator;
import com.yvan.entity.User;
import com.yvan.util.Md5Util;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author unknown
 */
public class ChangePasswordFrame extends JInternalFrame {
    private Administrator administrator;
    private User user;
    private final AdministratorBiz administratorBiz = new AdministratorBizImpl();
    private final UserBiz userBiz = new UserBizImpl();

    public ChangePasswordFrame() {
        initComponents();
    }

    public ChangePasswordFrame(Administrator administrator) {
        this.administrator = administrator;
        initComponents();
    }

    public ChangePasswordFrame(User user) {
        this.user = user;
        initComponents();
    }


    /**
     * 加载界面是，显示当前用户名
     *
     * @param e 事件
     */
    private void userLabelAncestorAdded(AncestorEvent e) {
        if (administrator != null) {
            userLabel.setText("【" + administrator.getType() + "】" + administrator.getName());
            return;
        }
        userLabel.setText(user.getName());
    }

    /**
     * 点击重置按钮的响应
     * 重置输入框
     *
     * @param e 事件
     */
    private void resetButtonActionPerformed(ActionEvent e) {
        oldPassdwordTextField.setText("");
        newPasswordField.setText("");
        enterPasswordField.setText("");
    }

    /**
     * 点击确认修改的响应
     *
     * @param e 事件
     */
    private void enterButtonActionPerformed(ActionEvent e) {
        String oldPassword = Md5Util.md5(oldPassdwordTextField.getText());
        String newPassword = String.valueOf(newPasswordField.getPassword());
        String enterPassword = String.valueOf(enterPasswordField.getPassword());
        if (administrator != null) {
            if (!administrator.getPassword().equals(oldPassword)) {
                JOptionPane.showMessageDialog(this, "原密码错误，请重新确认！！！");
                return;
            }
            if (!newPassword.equals(enterPassword)) {
                JOptionPane.showMessageDialog(this, "两次输入的密码不一致，请重新确认！！！");
                return;
            }
            System.out.println();
            if (oldPassword.equals(Md5Util.md5(newPassword))) {
                JOptionPane.showMessageDialog(this, "原密码和新密码一致！！！");
                return;
            }
            boolean flag = administratorBiz.changePassword(administrator, newPassword);
            if (!flag) {
                JOptionPane.showMessageDialog(this, "未知原因修改失败！！！");
                return;
            }
            administrator.setPassword(Md5Util.md5(newPassword));
            JOptionPane.showMessageDialog(this, "恭喜修改成功，请小心保存密码！！！");
            resetButtonActionPerformed(e);
            return;
        }
        if (!user.getPassword().equals(oldPassword)) {
            JOptionPane.showMessageDialog(this, "原密码错误，请重新确认！！！");
            return;
        }
        if (!newPassword.equals(enterPassword)) {
            JOptionPane.showMessageDialog(this, "两次输入的密码不一致，请重新确认！！！");
            return;
        }
        if (user.getPassword().equals(newPassword)) {
            JOptionPane.showMessageDialog(this, "原密码和新密码一致！！！");
            return;
        }
        boolean flag = userBiz.changePassword(user, newPassword);
        if (!flag) {
            JOptionPane.showMessageDialog(this, "未知原因修改失败！！！");
            return;
        }
        user.setPassword(Md5Util.md5(newPassword));
        JOptionPane.showMessageDialog(this, "恭喜修改成功，请小心保存密码！！！");
        resetButtonActionPerformed(e);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        userLabel = new JLabel();
        oldPassdwordTextField = new JTextField();
        newPasswordField = new JPasswordField();
        enterButton = new JButton();
        resetButton = new JButton();
        enterPasswordField = new JPasswordField();

        //======== this ========
        setVisible(true);
        setTitle("\u4fee\u6539\u5bc6\u7801");
        setClosable(true);
        setMaximizable(true);
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u539f\u5bc6\u7801\uff1a");
        label1.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
        label1.setIcon(new ImageIcon(getClass().getResource("/img/password.png")));

        //---- label2 ----
        label2.setText("\u5f53\u524d\u7528\u6237\uff1a");
        label2.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
        label2.setIcon(new ImageIcon(getClass().getResource("/img/user.png")));

        //---- label3 ----
        label3.setText("\u65b0\u5bc6\u7801\uff1a");
        label3.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
        label3.setIcon(new ImageIcon(getClass().getResource("/img/\u5bc6\u7801.png")));

        //---- label4 ----
        label4.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");
        label4.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
        label4.setIcon(new ImageIcon(getClass().getResource("/img/\u5bc6\u7801.png")));

        //---- userLabel ----
        userLabel.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
        userLabel.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent e) {
                userLabelAncestorAdded(e);
            }
            @Override
            public void ancestorMoved(AncestorEvent e) {}
            @Override
            public void ancestorRemoved(AncestorEvent e) {}
        });

        //---- enterButton ----
        enterButton.setText("\u786e\u5b9a\u4fee\u6539");
        enterButton.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
        enterButton.setIcon(new ImageIcon(getClass().getResource("/img/\u786e\u8ba4.png")));
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterButtonActionPerformed(e);
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

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(151, 151, 151)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
                            .addGap(53, 53, 53)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(userLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(oldPassdwordTextField)
                                .addComponent(newPasswordField)
                                .addComponent(enterPasswordField, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(200, 200, 200)
                            .addComponent(enterButton)
                            .addGap(153, 153, 153)
                            .addComponent(resetButton)))
                    .addContainerGap(231, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addComponent(userLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                    .addGap(41, 41, 41)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addComponent(oldPassdwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(48, 48, 48)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addComponent(newPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(34, 34, 34)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addComponent(enterPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(31, 31, 31)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(enterButton)
                        .addComponent(resetButton))
                    .addContainerGap(41, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel userLabel;
    private JTextField oldPassdwordTextField;
    private JPasswordField newPasswordField;
    private JButton enterButton;
    private JButton resetButton;
    private JPasswordField enterPasswordField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
