/*
 * Created by JFormDesigner on Sun Aug 16 21:57:29 GMT+08:00 2020
 */

package com.yvan.view;

import com.yvan.biz.BookBiz;
import com.yvan.biz.CollectionBiz;
import com.yvan.biz.CommentBiz;
import com.yvan.biz.RecordBookBiz;
import com.yvan.biz.impl.BookBizImpl;
import com.yvan.biz.impl.CollectionBizImpl;
import com.yvan.biz.impl.CommentBizImpl;
import com.yvan.biz.impl.RecordBookBizImpl;
import com.yvan.entity.Book;
import com.yvan.entity.Comment;
import com.yvan.entity.User;
import com.yvan.util.StringUtil;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author unknown
 */
public class BorrowBookFrame extends JInternalFrame {
    private final BookBiz bookBiz = new BookBizImpl();
    private final RecordBookBiz recordBookBiz = new RecordBookBizImpl();
    private final CollectionBiz collectionBiz = new CollectionBizImpl();
    private final CommentBiz commentBiz = new CommentBizImpl();
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
     * 不合法检测
     *
     * @return false 合法
     */
    public boolean isNotLegal() {
        if (StringUtil.isNotLegal(strTextField.getText())) {
            JOptionPane.showMessageDialog(this, "输入不合法，如 and,or或#,*");
            return true;
        }
        return false;
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
        if (isNotLegal()) {
            return;
        }
        bookList = bookBiz.findByString(strTextField.getText(), user);
        if (bookList.size() == 0) {
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
        bookList = bookBiz.findAll(user);
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
            vector.add(book.isCollection());
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
     * 点击收藏时响应
     *
     * @param e 事件
     */
    private void bookInfoPropertyChange(PropertyChangeEvent e) {
        // TODO add your code here
        if (bookInfo.getSelectedRow() == -1) {
            return;
        }
        DefaultTableModel bookInfoModel = (DefaultTableModel) bookInfo.getModel();
        boolean flag = (boolean) bookInfoModel.getValueAt(bookInfo.getSelectedRow(), 7);
        collectionBiz.updateDel(user, bookList.get(bookInfo.getSelectedRow()), flag);
    }

    /**
     * 选择表格是的响应
     *
     * @param e 事件
     */
    private void bookInfoMouseClicked(MouseEvent e) {
        if (bookInfo.getSelectedRow() == -1) {
            return;
        }
        List<Comment> comments = commentBiz.getContent(bookList.get(bookInfo.getSelectedRow()));
        ArrayList<String> contents = new ArrayList<>();
        for (Comment comment : comments) {
            contents.add(comment.getContent());
        }
        final String[] v = contents.toArray(new String[0]);

        commentList.setModel(new AbstractListModel<String>() {
            String[] values = v;

            @Override
            public int getSize() {
                return values.length;
            }

            @Override
            public String getElementAt(int i) {
                return values[i];
            }
        });
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
        scrollPane2 = new JScrollPane();
        commentList = new JList<>();

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
                    "\u4e66\u540d", "\u4f5c\u8005", "\u51fa\u7248\u793e", "\u51fa\u7248\u65e5\u671f", "\u7c7b\u578b", "\u4e66\u7c4d\u62bc\u91d1", "\u5728\u9986\u6570\u91cf", "\u6536\u85cf"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Object.class, Object.class, Object.class, Object.class, Object.class, Float.class, Integer.class, Boolean.class
                };
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false, false, false, false, true
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
            bookInfo.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent e) {
                    bookInfoPropertyChange(e);
                }
            });
            bookInfo.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    bookInfoMouseClicked(e);
                }
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

        //======== scrollPane2 ========
        {

            //---- commentList ----
            commentList.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
            scrollPane2.setViewportView(commentList);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(84, 84, 84)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(strTextField, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)
                            .addGap(48, 48, 48)
                            .addComponent(inquireButton, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                            .addGap(59, 59, 59)
                            .addComponent(borrowButton, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 923, GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34)
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(50, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addComponent(inquireButton)
                        .addComponent(borrowButton)
                        .addComponent(strTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 528, GroupLayout.PREFERRED_SIZE)
                        .addComponent(scrollPane2))
                    .addGap(40, 40, 40))
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
    private JScrollPane scrollPane2;
    private JList<String> commentList;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
