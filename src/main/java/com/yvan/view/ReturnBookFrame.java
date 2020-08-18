/*
 * Created by JFormDesigner on Mon Aug 17 13:32:23 GMT+08:00 2020
 */

package com.yvan.view;

import com.yvan.biz.RecordBookBiz;
import com.yvan.biz.impl.RecordBookBizImpl;
import com.yvan.entity.RecordView;
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
import java.util.List;
import java.util.Vector;

/**
 * @author unknown
 */
public class ReturnBookFrame extends JInternalFrame {
    private final RecordBookBiz recordBookBiz = new RecordBookBizImpl();
    private User user;
    private List<RecordView> recordViewList;

    public ReturnBookFrame() {
        initComponents();
    }

    public ReturnBookFrame(User user) {
        this.user = user;
        initComponents();
    }

    /**
     * 设置表格的值
     */
    private void setTable() {
        DefaultTableModel bookInfoModel = (DefaultTableModel) bookInfo.getModel();
        bookInfoModel.setRowCount(0);
        for (RecordView recordView : recordViewList) {
            Vector<Serializable> vector = new Vector<>();
            vector.add(recordView.getBookName());
            vector.add(recordView.getAuthor());
            vector.add(recordView.getLendTime());
            vector.add(recordView.getDeposit());
            vector.add(recordView.isRenew());
            bookInfoModel.addRow(vector);
        }
    }

    /**
     * 点击查询的响应
     *
     * @param e 事件
     */
    private void inquireButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        if (StringUtil.isNull(strTextField.getText())) {
            strTextField.setText("");
        }
        recordViewList = recordBookBiz.findNotReturnByString(user, strTextField.getText());
        if (recordViewList == null) {
            JOptionPane.showMessageDialog(this, "查询不到记录，或者该书籍已经还了 ！！");
            return;
        }
        setTable();
    }

    /**
     * 表格加载时的操作
     *
     * @param e 事件
     */
    private void bookInfoAncestorAdded(AncestorEvent e) {
        recordViewList = recordBookBiz.showBorrowNotReturnRecord(user);
        setTable();
    }

    /**
     * 点击还书的响应
     *
     * @param e 事件
     */
    private void returnButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        if (bookInfo.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "请选择要还的书 ！！");
            return;
        }
        boolean flag = recordBookBiz.returnBook(recordViewList.get(bookInfo.getSelectedRow()), user);
        if (!flag) {
            JOptionPane.showMessageDialog(this, "还书失败，请重试 ！！");
            return;
        }
        JOptionPane.showMessageDialog(this, "还书成功 ！！");
        inquireButtonActionPerformed(e);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        strTextField = new JTextField();
        inquireButton = new JButton();
        scrollPane1 = new JScrollPane();
        bookInfo = new JTable();
        returnButton = new JButton();
        button = new JButton();

        //======== this ========
        setVisible(true);
        setClosable(true);
        setMaximizable(true);
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u501f\u9605\u8bb0\u5f55\u67e5\u8be2\uff1a");
        label1.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
        label1.setIcon(new ImageIcon(getClass().getResource("/img/\u56fe\u4e66\u7ba1\u7406.png")));

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

        //======== scrollPane1 ========
        {

            //---- bookInfo ----
            bookInfo.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "\u4e66\u540d", "\u4f5c\u8005", "\u501f\u9605\u65f6\u95f4", "\u4ea4\u62bc\u91d1\u91d1\u989d", "\u662f\u5426\u7eed\u501f\u8fc7"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Object.class, Object.class, Object.class, Object.class, Boolean.class
                };
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false, false
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
            bookInfo.setMinimumSize(null);
            bookInfo.setFillsViewportHeight(true);
            bookInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            bookInfo.addAncestorListener(new AncestorListener() {
                @Override
                public void ancestorAdded(AncestorEvent e) {
                    bookInfoAncestorAdded(e);
                }
                @Override
                public void ancestorMoved(AncestorEvent e) {}
                @Override
                public void ancestorRemoved(AncestorEvent e) {}
            });
            scrollPane1.setViewportView(bookInfo);
        }

        //---- returnButton ----
        returnButton.setText("\u5f52\u8fd8\u56fe\u4e66");
        returnButton.setIcon(new ImageIcon(getClass().getResource("/img/\u56fe\u4e66\u5f52\u8fd8.png")));
        returnButton.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnButtonActionPerformed(e);
            }
        });

        //---- button ----
        button.setText("\u7eed\u501f");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(67, 67, 67)
                            .addComponent(label1)
                            .addGap(18, 18, 18)
                            .addComponent(strTextField, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(inquireButton)
                            .addGap(35, 35, 35)
                            .addComponent(returnButton, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(button))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 889, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(27, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addComponent(strTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(inquireButton)
                        .addComponent(returnButton)
                        .addComponent(button))
                    .addGap(36, 36, 36)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 528, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(71, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JTextField strTextField;
    private JButton inquireButton;
    private JScrollPane scrollPane1;
    private JTable bookInfo;
    private JButton returnButton;
    private JButton button;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
