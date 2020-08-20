/*
 * Created by JFormDesigner on Wed Aug 19 15:50:25 GMT+08:00 2020
 */

package com.yvan.view;

import com.yvan.biz.CommentBiz;
import com.yvan.biz.RecordBookBiz;
import com.yvan.biz.impl.CommentBizImpl;
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
public class CommentFrame extends JInternalFrame {

    private final RecordBookBiz recordBookBiz = new RecordBookBizImpl();
    private final CommentBiz commentBiz = new CommentBizImpl();
    private User user;
    private List<RecordView> recordViewList;

    public CommentFrame() {
        initComponents();
    }

    public CommentFrame(User user) {
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
            bookInfoModel.addRow(vector);
        }
    }

    private void inquireButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void bookInfoAncestorAdded(AncestorEvent e) {
        // TODO add your code here
        recordViewList = recordBookBiz.findReturn(user);
        setTable();
    }

    /**
     * 点击重置的响应
     *
     * @param e 时间
     */
    private void resetButtonActionPerformed(ActionEvent e) {
        textEditorPane.setText("");
    }

    /**
     * 点击确认的响应
     *
     * @param e 事件
     */
    private void enterButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        int row = bookInfo.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择一条记录！！！");
            return;
        }
        if (StringUtil.isNull(textEditorPane.getText())) {
            JOptionPane.showMessageDialog(this, "评论为空！！！");
            return;
        }
        String content = textEditorPane.getText();


        boolean flag = commentBiz.createComment(user, recordViewList.get(bookInfo.getSelectedRow()), content);
        if (!flag) {
            JOptionPane.showMessageDialog(this, "评论失败，请重试！！！");
            return;
        }
        JOptionPane.showMessageDialog(this, "评论成功！！！");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        strTextField = new JTextField();
        inquireButton = new JButton();
        scrollPane1 = new JScrollPane();
        bookInfo = new JTable();
        label2 = new JLabel();
        enterButton = new JButton();
        ResetButton = new JButton();
        scrollPane2 = new JScrollPane();
        textEditorPane = new JEditorPane();

        //======== this ========
        setVisible(true);
        setClosable(true);
        setMaximizable(true);
        setTitle("\u8bc4\u8bba");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u67e5\u8be2\uff1a");
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
                    {null, null},
                },
                new String[] {
                    "\u4e66\u540d", "\u4f5c\u8005"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, false
                };
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

        //---- label2 ----
        label2.setText("\u8bc4\u8bba\uff1a");
        label2.setFont(new Font("\u6977\u4f53", Font.BOLD, 20));

        //---- enterButton ----
        enterButton.setText("\u786e\u8ba4");
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterButtonActionPerformed(e);
            }
        });

        //---- ResetButton ----
        ResetButton.setText("\u91cd\u7f6e");
        ResetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetButtonActionPerformed(e);
            }
        });

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(textEditorPane);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(109, 109, 109)
                    .addComponent(label1)
                    .addGap(53, 53, 53)
                    .addComponent(strTextField, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                    .addComponent(inquireButton)
                    .addGap(93, 93, 93))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(39, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 781, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(50, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(83, 83, 83)
                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(enterButton)
                            .addGap(213, 213, 213)
                            .addComponent(ResetButton))
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(243, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                            .addComponent(strTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(inquireButton)))
                    .addGap(41, 41, 41)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(76, 76, 76)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(enterButton)
                        .addComponent(ResetButton))
                    .addGap(28, 28, 28))
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
    private JLabel label2;
    private JButton enterButton;
    private JButton ResetButton;
    private JScrollPane scrollPane2;
    private JEditorPane textEditorPane;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
