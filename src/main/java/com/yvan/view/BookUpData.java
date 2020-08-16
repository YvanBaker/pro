/*
 * Created by JFormDesigner on Sun Aug 16 08:14:05 GMT+08:00 2020
 */

package com.yvan.view;

import com.yvan.biz.BookBiz;
import com.yvan.biz.impl.BookBizImpl;
import com.yvan.entity.Book;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

/**
 * @author unknown
 */

public class BookUpData extends JInternalFrame {
    private final BookBiz bookBiz = new BookBizImpl();

    public BookUpData() {
        initComponents();
    }

    /**
     * 表格加载时
     *
     * @param e 事件
     */
    private void bookInfoAncestorAdded(AncestorEvent e) {
        // TODO add your code here
        List<Book> bookList = bookBiz.findAll();
        setTable(bookList);
    }

    /**
     * 设置表格显示
     *
     * @param bookList 显示的数据
     */
    private void setTable(List<Book> bookList) {
        DefaultTableModel bookInfoModel = (DefaultTableModel) bookInfo.getModel();
        bookInfoModel.setRowCount(0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        for (Book book : bookList) {
            Vector vector = new Vector();
            vector.add(book.getId());
            vector.add(book.getBookName());
            vector.add(book.getAuthor());
            vector.add(book.getPress());
            vector.add(simpleDateFormat.format(book.getPublicationDate()));
            vector.add(book.getType());
            vector.add(book.getBookDeposit());
            vector.add(book.getTotal());
            vector.add(book.getCount());
            vector.add(book.getTimes());
            vector.add(book.getHasLended());
            bookInfoModel.addRow(vector);
        }
        System.out.println(1111);
    }

    /**
     * 点击查询按钮的响应
     *
     * @param e 事件
     */
    private void inquireButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        List<Book> list = bookBiz.findByString(strTextField.getText());
        System.out.println(list);
        if (list == null){
            JOptionPane.showMessageDialog(this, "查询不到该书籍！！");
            return;
        }
        setTable(list);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        strTextField = new JTextField();
        inquireButton = new JButton();
        scrollPane1 = new JScrollPane();
        bookInfo = new JTable();

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
                    "id", "\u4e66\u540d", "\u4f5c\u8005", "\u51fa\u7248\u793e", "\u51fa\u7248\u65e5\u671f", "\u7c7b\u578b", "\u4e66\u7c4d\u62bc\u91d1", "\u4e66\u7c4d\u6570\u91cf", "\u5728\u9986\u6570\u91cf", "\u5df2\u501f\u51fa\u6570\u91cf", "\u603b\u501f\u51fa\u6570\u91cf"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Float.class, Integer.class, Integer.class, Integer.class, Integer.class
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
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

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(124, 124, 124)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(strTextField, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
                            .addGap(47, 47, 47)
                            .addComponent(inquireButton))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 883, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(684, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addComponent(strTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(inquireButton))
                    .addGap(49, 49, 49)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 695, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(31, Short.MAX_VALUE))
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
