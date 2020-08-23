/*
 * Created by JFormDesigner on Thu Aug 20 17:11:09 GMT+08:00 2020
 */

package com.yvan.view;

import com.yvan.biz.UserBiz;
import com.yvan.biz.impl.UserBizImpl;
import com.yvan.entity.User;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @author unknown
 */
public class RechargeFrame extends JInternalFrame {
    private static final int MIN_PROGRESS = 0;
    private static final int MAX_PROGRESS = 100;
    private final UserBiz userBiz = new UserBizImpl();
    private User user;


    public RechargeFrame(User user) {
        this.user = user;
        initComponents();
    }


    /**
     * 选择金额变化的响应
     *
     * @param e 事件
     */
    private void moneyComboBoxItemStateChanged(ItemEvent e) {
        String fileName = "/img/pay" + moneyComboBox.getSelectedItem() + ".png";
        imageLabel.setIcon(new ImageIcon(getClass().getResource(fileName)));
    }

    /**
     * 点击充值的响应
     *
     * @param e 事件
     */
    private void rechargeButtonActionPerformed(ActionEvent e) {
        int money = Integer.parseInt(String.valueOf(moneyComboBox.getSelectedItem()));
        User res = userBiz.recharge(user, money);
        if (res == null) {
            JOptionPane.showMessageDialog(this, "未知原因，充值失败，请重试！！！");
            return;
        }
        user = res;
        String str = String.format("%.2f", user.getBalance());
        balanceLabel.setText(str);
        System.out.println(user.getLevel());
        levelLabel.setText(String.valueOf(user.getLevel()));
        JOptionPane.showMessageDialog(this, "充值成功！！！");
    }

    /**
     * 余额初始显示
     *
     * @param e 事件
     */
    private void balanceLabelAncestorAdded(AncestorEvent e) {
        String str = String.format("%.2f", user.getBalance());
        balanceLabel.setText(str);
    }

    /**
     * 等级 初始显示
     *
     * @param e 事件
     */
    private void levelLabelAncestorAdded(AncestorEvent e) {
        System.out.println(user.getLevel());
        levelLabel.setText(String.valueOf(user.getLevel()));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        imageLabel = new JLabel();
        rechargeButton = new JButton();
        moneyComboBox = new JComboBox<>();
        label1 = new JLabel();
        label2 = new JLabel();
        balanceLabel = new JLabel();
        levelLabel = new JLabel();

        //======== this ========
        setVisible(true);
        setClosable(true);
        setMaximizable(true);
        setTitle("\u5145\u503c");
        Container contentPane = getContentPane();

        //---- imageLabel ----
        imageLabel.setIcon(new ImageIcon(getClass().getResource("/img/pay6.png")));

        //---- rechargeButton ----
        rechargeButton.setText("\u5145\u503c");
        rechargeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rechargeButtonActionPerformed(e);
            }
        });

        //---- moneyComboBox ----
        moneyComboBox.setModel(new DefaultComboBoxModel<>(new String[]{
                "6",
                "30",
                "68",
                "128",
                "198",
                "328",
                "648"
        }));
        moneyComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                moneyComboBoxItemStateChanged(e);
            }
        });

        //---- label1 ----
        label1.setText("\u7528\u6237\u4f59\u989d\uff1a");
        label1.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));

        //---- label2 ----
        label2.setText("\u7528\u6237vip\u7b49\u7ea7\uff1a");
        label2.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));

        //---- balanceLabel ----
        balanceLabel.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent e) {
                balanceLabelAncestorAdded(e);
            }

            @Override
            public void ancestorMoved(AncestorEvent e) {
            }

            @Override
            public void ancestorRemoved(AncestorEvent e) {
            }
        });

        //---- levelLabel ----
        levelLabel.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent e) {
                levelLabelAncestorAdded(e);
            }

            @Override
            public void ancestorMoved(AncestorEvent e) {
            }

            @Override
            public void ancestorRemoved(AncestorEvent e) {
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(label2)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(levelLabel))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(label1)
                                                .addGap(18, 18, 18)
                                                .addComponent(balanceLabel)))
                                .addContainerGap(661, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addContainerGap(331, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addComponent(moneyComboBox, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
                                                .addGap(252, 252, 252))
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addComponent(imageLabel)
                                                .addGap(216, 216, 216))
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addComponent(rechargeButton)
                                                .addGap(312, 312, 312))))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(label1)
                                                        .addComponent(balanceLabel))
                                                .addGap(39, 39, 39))
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(moneyComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label2)
                                        .addComponent(levelLabel))
                                .addGap(10, 10, 10)
                                .addComponent(imageLabel)
                                .addGap(61, 61, 61)
                                .addComponent(rechargeButton)
                                .addContainerGap(78, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel imageLabel;
    private JButton rechargeButton;
    private JComboBox<String> moneyComboBox;
    private JLabel label1;
    private JLabel label2;
    private JLabel balanceLabel;
    private JLabel levelLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
