/*
 * Created by JFormDesigner on Wed Aug 19 19:50:08 GMT+08:00 2020
 */

package com.yvan.view;

import com.yvan.biz.FreezeBiz;
import com.yvan.biz.UserBiz;
import com.yvan.biz.impl.FreezeBizImpl;
import com.yvan.biz.impl.UserBizImpl;
import com.yvan.entity.Freeze;
import com.yvan.entity.User;
import com.yvan.util.StringUtil;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 * @author unknown
 */
public class UserManageFrame extends JInternalFrame {
    private final UserBiz userBiz = new UserBizImpl();
    private final FreezeBiz freezeBiz = new FreezeBizImpl();
    private Map<User, Freeze> userFreezeMap = new HashMap<>();

    public UserManageFrame() {
        initComponents();
    }

    /**
     * 设置表格数据
     */
    private void setTable() {
        DefaultTableModel userTableModel = (DefaultTableModel) userTable.getModel();
        userTableModel.setRowCount(0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Set<Map.Entry<User, Freeze>> entries = userFreezeMap.entrySet();
        for (Map.Entry<User, Freeze> entry : entries) {
            Vector<Serializable> vector = new Vector<>();
            vector.add(entry.getKey().getId());
            vector.add(entry.getKey().getName());
            Freeze freeze = entry.getValue();
            vector.add(freeze != null);
            userTableModel.addRow(vector);
        }
    }

    /**
     * 点击初始密码的响应
     *
     * @param e 事件
     */
    private void initializeButtonActionPerformed(ActionEvent e) {
        int row = userTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择用户！！");
            return;
        }
        DefaultTableModel userTableModel = (DefaultTableModel) userTable.getModel();
        int uid = (int) userTableModel.getValueAt(row, 0);
        boolean flag = userBiz.initializePassword(uid);
        if (!flag) {
            JOptionPane.showMessageDialog(this, "未知原因重置失败！！");
            return;
        }
        JOptionPane.showMessageDialog(this, "重置成功！！");
    }


    private void userTableAncestorAdded(AncestorEvent e) {
        userFreezeMap = userBiz.userFreezeList();
        if (!userFreezeMap.isEmpty()) {
            setTable();
        }
    }

    /**
     * 冻结用户的响应
     * @param e 事件
     */
    private void freezeButtonActionPerformed(ActionEvent e) {
        int row = userTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请先选择一个用户！！");
            return;
        }
        DefaultTableModel userTableModel = (DefaultTableModel) userTable.getModel();
        int uid = (int) userTableModel.getValueAt(row, 0);
        boolean flag = (boolean) userTableModel.getValueAt(row, 2);
        if (flag) {
            JOptionPane.showMessageDialog(this, "用户已经冻结，无需重复冻结！！");
            reasonEditorPane.setText("");
            return;
        }
        String reason = reasonEditorPane.getText();
        if (StringUtil.isNull(reason)) {
            JOptionPane.showMessageDialog(this, "请说明冻结原因！！");
            return;
        }

        flag = freezeBiz.freezeUser(uid, reason);
        if (!flag) {
            JOptionPane.showMessageDialog(this, "未知原因导致冻结失败，请重试！！！");
            return;
        }
        JOptionPane.showMessageDialog(this, "冻结成功！！！");
        inquireButtonActionPerformed(e);
        reasonEditorPane.setText("");
    }

    /**
     * 解冻用户的响应
     * @param e 事件
     */
    private void unfreezeButtonActionPerformed(ActionEvent e) {
        int row = userTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请先选择一个用户！！");
            return;
        }

        DefaultTableModel userTableModel = (DefaultTableModel) userTable.getModel();
        int uid = (int) userTableModel.getValueAt(row, 0);
        Freeze freeze = userFreezeMap.get(new User(uid));
        boolean flag = (boolean) userTableModel.getValueAt(row, 2);
        if (!flag) {
            JOptionPane.showMessageDialog(this, "用户没有被冻结，无需解冻！！");
            reasonEditorPane.setText("");
            return;
        }

        String reason = reasonEditorPane.getText();
        if (StringUtil.isNull(reason)) {
            JOptionPane.showMessageDialog(this, "请说明解冻结原因！！");
            return;
        }

        flag = freezeBiz.unfreezeUser(freeze,reason);
        if (!flag) {
            JOptionPane.showMessageDialog(this, "未知原因导致解冻失败，请重试！！！");
            return;
        }
        JOptionPane.showMessageDialog(this, "解冻成功！！！");
        inquireButtonActionPerformed(e);
        reasonEditorPane.setText("");
    }

    private void inquireButtonActionPerformed(ActionEvent e) {
        String str = strTextField.getText();
        if (str == null) {
            str = "";
        }
        userFreezeMap = userBiz.userFreezeList(str);
        if (userFreezeMap.isEmpty()) {
            JOptionPane.showMessageDialog(this, "查询不到该用户，或该用户已经注销！！");
            return;
        }
        setTable();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        strTextField = new JTextField();
        inquireButton = new JButton();
        initializeButton = new JButton();
        freezeButton = new JButton();
        unfreezeButton = new JButton();
        scrollPane1 = new JScrollPane();
        userTable = new JTable();
        label2 = new JLabel();
        scrollPane2 = new JScrollPane();
        reasonEditorPane = new JEditorPane();

        //======== this ========
        setVisible(true);
        setTitle("\u666e\u901a\u7528\u6237\u7ba1\u7406");
        setClosable(true);
        setMaximizable(true);
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u7528\u6237\u67e5\u8be2\uff1a");
        label1.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
        label1.setIcon(new ImageIcon(getClass().getResource("/img/\u7528\u6237\u67e5\u8be2.png")));

        //---- inquireButton ----
        inquireButton.setText("\u67e5\u8be2");
        inquireButton.setIcon(new ImageIcon(getClass().getResource("/img/\u67e5\u8be2.png")));
        inquireButton.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
        inquireButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inquireButtonActionPerformed(e);
            }
        });

        //---- initializeButton ----
        initializeButton.setText("\u521d\u59cb\u5316\u5bc6\u7801");
        initializeButton.setIcon(new ImageIcon(getClass().getResource("/img/\u67e5\u8be2.png")));
        initializeButton.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
        initializeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeButtonActionPerformed(e);
            }
        });

        //---- freezeButton ----
        freezeButton.setText("\u51bb\u7ed3\u7528\u6237");
        freezeButton.setIcon(new ImageIcon(getClass().getResource("/img/\u51bb\u7ed3.png")));
        freezeButton.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
        freezeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                freezeButtonActionPerformed(e);
            }
        });

        //---- unfreezeButton ----
        unfreezeButton.setText("\u89e3\u51bb\u7528\u6237");
        unfreezeButton.setIcon(new ImageIcon(getClass().getResource("/img/\u89e3\u51bb.png")));
        unfreezeButton.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
        unfreezeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unfreezeButtonActionPerformed(e);
            }
        });

        //======== scrollPane1 ========
        {

            //---- userTable ----
            userTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "id", "\u7528\u6237\u540d", "\u51bb\u7ed3\u72b6\u6001"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Object.class, Object.class, Boolean.class
                };
                boolean[] columnEditable = new boolean[] {
                    true, false, false
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            userTable.setMinimumSize(null);
            userTable.setFillsViewportHeight(true);
            userTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            userTable.addAncestorListener(new AncestorListener() {
                @Override
                public void ancestorAdded(AncestorEvent e) {
                    userTableAncestorAdded(e);
                }
                @Override
                public void ancestorMoved(AncestorEvent e) {}
                @Override
                public void ancestorRemoved(AncestorEvent e) {}
            });
            scrollPane1.setViewportView(userTable);
        }

        //---- label2 ----
        label2.setText("\u539f\u56e0\uff1a");
        label2.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
        label2.setIcon(new ImageIcon(getClass().getResource("/img/\u6d88\u606f.png")));

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(reasonEditorPane);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(81, 81, 81)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 725, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(44, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addGap(27, 27, 27)
                            .addComponent(strTextField, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
                            .addGap(41, 41, 41)
                            .addComponent(inquireButton)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                            .addComponent(initializeButton, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(43, Short.MAX_VALUE))))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(172, 172, 172)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(212, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(freezeButton)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
                            .addComponent(unfreezeButton)
                            .addGap(179, 179, 179))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addComponent(strTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(inquireButton)
                        .addComponent(initializeButton))
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addGap(65, 65, 65)))
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(unfreezeButton)
                        .addComponent(freezeButton))
                    .addGap(26, 26, 26))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JTextField strTextField;
    private JButton inquireButton;
    private JButton initializeButton;
    private JButton freezeButton;
    private JButton unfreezeButton;
    private JScrollPane scrollPane1;
    private JTable userTable;
    private JLabel label2;
    private JScrollPane scrollPane2;
    private JEditorPane reasonEditorPane;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
