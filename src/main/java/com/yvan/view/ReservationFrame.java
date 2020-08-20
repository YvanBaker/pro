/*
 * Created by JFormDesigner on Tue Aug 18 21:41:58 GMT+08:00 2020
 */

package com.yvan.view;

import com.yvan.biz.BookBiz;
import com.yvan.biz.CollectionBiz;
import com.yvan.biz.ReservationBiz;
import com.yvan.biz.impl.BookBizImpl;
import com.yvan.biz.impl.CollectionBizImpl;
import com.yvan.biz.impl.ReservationBizImpl;
import com.yvan.entity.Book;
import com.yvan.entity.User;
import com.yvan.util.StringUtil;
import com.yvan.util.TimeUtil;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

/**
 * @author unknown
 */
public class ReservationFrame extends JInternalFrame {
    private final BookBiz bookBiz = new BookBizImpl();
    private final ReservationBiz reservationBiz = new ReservationBizImpl();
    private final CollectionBiz collectionBiz = new CollectionBizImpl();
    private User user;
    private List<Book> bookList;

    public ReservationFrame() {
        initComponents();
    }

    public ReservationFrame(User user) {
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
            JOptionPane.showMessageDialog(this, "用户名存在敏感词汇或字符，如 and,or或#,*");
            return true;
        }
        return false;
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
            vector.add(book.isCollection());
            bookInfoModel.addRow(vector);
        }
    }

    /**
     * 点击预约的响应
     *
     * @param e 事件
     */
    private void reservationButtonActionPerformed(ActionEvent e) {
        if (bookInfo.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "请选择图书！！");
            return;
        }
        if (datePicker.getDate() == null) {
            JOptionPane.showMessageDialog(this, "请输入预约的时间！！");
            return;
        }
        if (TimeUtil.timeLessCurrent(datePicker.getDate())) {
            JOptionPane.showMessageDialog(this, "预约的时间只能在今天以后的时间！！");
            return;
        }
        boolean flag = reservationBiz.reservation(user, bookList.get(bookInfo.getSelectedRow()), datePicker.getDate());
        if (!flag) {
            JOptionPane.showMessageDialog(this, "存在该书的预约记录！！");
            return;
        }
        JOptionPane.showMessageDialog(this, "预约成功！！");
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
        bookList = bookBiz.findCountZoneByString(strTextField.getText(), user);
        if (bookList.size() == 0) {
            JOptionPane.showMessageDialog(this, "查询不到该书籍或馆中有书，可以直接接！！");
            return;
        }
        setTable();
    }

    /**
     * 表格初始加载的事件
     *
     * @param e 事件
     */
    private void bookInfoAncestorAdded(AncestorEvent e) {
        bookList = bookBiz.findCountZero(user);
        if (bookList.isEmpty()) {
            return;
        }
        setTable();
    }

    /**
     * 表格的值发生改变时
     *
     * @param e 事件
     */
    private void bookInfoPropertyChange(PropertyChangeEvent e) {
        if (bookInfo.getSelectedRow() == -1) {
            return;
        }
        DefaultTableModel bookInfoModel = (DefaultTableModel) bookInfo.getModel();
        boolean flag = (boolean) bookInfoModel.getValueAt(bookInfo.getSelectedRow(), 6);
        collectionBiz.updateDel(user, bookList.get(bookInfo.getSelectedRow()), flag);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        reservationButton = new JButton();
        inquireButton = new JButton();
        strTextField = new JTextField();
        scrollPane1 = new JScrollPane();
        bookInfo = new JTable();
        datePicker = new JXDatePicker();
        label2 = new JLabel();

        //======== this ========
        setVisible(true);
        setClosable(true);
        setMaximizable(true);
        setTitle("\u9884\u7ea6");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u4e66\u7c4d\u67e5\u8be2\uff1a");
        label1.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
        label1.setIcon(new ImageIcon(getClass().getResource("/img/\u56fe\u4e66\u7ba1\u7406.png")));

        //---- reservationButton ----
        reservationButton.setText("\u9884\u7ea6");
        reservationButton.setIcon(new ImageIcon(getClass().getResource("/img/\u501f\u4e66.png")));
        reservationButton.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
        reservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reservationButtonActionPerformed(e);
            }
        });

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
                    "\u4e66\u540d", "\u4f5c\u8005", "\u51fa\u7248\u793e", "\u51fa\u7248\u65e5\u671f", "\u7c7b\u578b", "\u4e66\u7c4d\u62bc\u91d1", "\u6536\u85cf"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Object.class, Object.class, Object.class, Object.class, Object.class, Float.class, Boolean.class
                };
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false, false, false, true
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
            scrollPane1.setViewportView(bookInfo);
        }

        //---- label2 ----
        label2.setText("\u9884\u7ea6\u65f6\u95f4\uff1a");
        label2.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
        label2.setIcon(new ImageIcon(getClass().getResource("/img/\u9884\u7ea6.png")));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(130, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 923, GroupLayout.PREFERRED_SIZE)
                    .addGap(112, 112, 112))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(206, 206, 206)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(datePicker, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                        .addComponent(strTextField, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
                    .addGap(86, 86, 86)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(reservationButton)
                        .addComponent(inquireButton))
                    .addContainerGap(355, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(49, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addComponent(strTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(inquireButton))
                    .addGap(23, 23, 23)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(reservationButton)
                        .addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 528, GroupLayout.PREFERRED_SIZE)
                    .addGap(39, 39, 39))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JButton reservationButton;
    private JButton inquireButton;
    private JTextField strTextField;
    private JScrollPane scrollPane1;
    private JTable bookInfo;
    private JXDatePicker datePicker;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
