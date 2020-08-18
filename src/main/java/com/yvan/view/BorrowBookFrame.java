/*
 * Created by JFormDesigner on Sun Aug 16 21:57:29 GMT+08:00 2020
 */

package com.yvan.view;

import com.yvan.biz.BookBiz;
import com.yvan.biz.RecordBookBiz;
import com.yvan.biz.impl.BookBizImpl;
import com.yvan.biz.impl.RecordBookBizImpl;
import com.yvan.entity.Book;
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
import java.util.List;
import java.util.Vector;

/**
 * @author unknown
 */
public class BorrowBookFrame extends JInternalFrame {
    private final BookBiz bookBiz = new BookBizImpl();
    private final RecordBookBiz recordBookBiz = new RecordBookBizImpl();
    private User user;
    private List<Book> bookList;

    public BorrowBookFrame() {
        initComponents();
    }

    public BorrowBookFrame(User user) {
        this.user = user;
        initComponents();
    }

    /**
     * 点击查询的响应
     *
     * @param e 事件
     */
    private void inquireButtonActionPerformed(ActionEvent e) {
        if (StringUtil.isNull(strTextField.getText())) {
            strTextField.setText("");
        }
        bookList = bookBiz.findByString(strTextField.getText());
        if (bookList == null) {
            JOptionPane.showMessageDialog(this, "查询不到该书籍！！");
            return;
        }
        setTable();
    }

    /**
     * 表格初始加载时的事件
     *
     * @param e 事件
     */
    private void bookInfoAncestorAdded(AncestorEvent e) {
        bookList = bookBiz.findAll();
        if (bookList.isEmpty()) {
            System.out.println("没有查到书籍");
        }
        setTable();

    }

    /**
     * 设置表格数据
     */
    private void setTable() {
        DefaultTableModel bookInfoModel = (DefaultTableModel) bookInfo.getModel();
        bookInfoModel.setRowCount(0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        for (Book book : bookList) {
            Vector<Serializable> vector;
            vector = new Vector<>();
            vector.add(book.getBookName());
            vector.add(book.getAuthor());
            vector.add(book.getPress());
            vector.add(simpleDateFormat.format(book.getPublicationDate()));
            vector.add(book.getType());
            vector.add(book.getBookDeposit());
            vector.add(book.getCount());
            bookInfoModel.addRow(vector);
        }
    }

    /**
     * 点击借书的响应
     *
     * @param e 事件
     */
    private void borrowButtonActionPerformed(ActionEvent e) {
        int select = bookInfo.getSelectedRow();
        if (select == -1) {
            JOptionPane.showMessageDialog(this, "请选择图书借阅！！");
            return;
        }
        Book book = bookList.get(bookInfo.getSelectedRow());
        int i = recordBookBiz.borrow(book, user);
        //1 失败 没有书; 2 库存不足; 3 金额不足 ; 4 借书记录保存失败； 5 成功
        switch (i) {
            case 1:
                JOptionPane.showMessageDialog(this, "库中没有该书籍，请重新查询！！");
                break;
            case 2:
                JOptionPane.showMessageDialog(this, "没有在馆图书！！");
                break;
            case 3:
                JOptionPane.showMessageDialog(this, "账号余额不足，请及时充值！！");
                break;
            case 4:
                JOptionPane.showMessageDialog(this, "存在该类书籍没有还！！");
                break;
            case 5:
                JOptionPane.showMessageDialog(this, "未知原因失败，请重新操作！！");
                break;
            case 6:
                JOptionPane.showMessageDialog(this, "借阅成功！！");
                break;
            default:
                break;
        }
        inquireButtonActionPerformed(e);
    }

    /**
     * 自动生成的窗体代码
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        strTextField = new JTextField();
        inquireButton = new JButton();
        scrollPane1 = new JScrollPane();
        bookInfo = new JTable();
        borrowButton = new JButton();

        //======== this ========
        setVisible(true);
        setClosable(true);
        setMaximizable(true);
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u4e66\u7c4d\u67e5\u8be2\uff1a");
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
                    "\u4e66\u540d", "\u4f5c\u8005", "\u51fa\u7248\u793e", "\u51fa\u7248\u65e5\u671f", "\u7c7b\u578b", "\u4e66\u7c4d\u62bc\u91d1", "\u5728\u9986\u6570\u91cf"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Object.class, Object.class, Object.class, Object.class, Object.class, Float.class, Integer.class
                };
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false, false, false, false
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

        //---- borrowButton ----
        borrowButton.setText("\u501f\u9605");
        borrowButton.setIcon(new ImageIcon(getClass().getResource("/img/\u501f\u4e66.png")));
        borrowButton.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
        borrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrowButtonActionPerformed(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(103, 103, 103)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(strTextField, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(inquireButton)
                            .addGap(43, 43, 43)
                            .addComponent(borrowButton))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 802, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(51, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addComponent(strTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(inquireButton)
                        .addComponent(borrowButton))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 528, GroupLayout.PREFERRED_SIZE)
                    .addGap(39, 39, 39))
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
    private JButton borrowButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
