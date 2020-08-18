/*
 * Created by JFormDesigner on Sun Aug 16 08:14:05 GMT+08:00 2020
 */

package com.yvan.view;

import com.yvan.biz.BookBiz;
import com.yvan.biz.impl.BookBizImpl;
import com.yvan.entity.Book;
import com.yvan.util.StringUtil;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 * @author unknown
 */

public class BookUpData extends JInternalFrame {
    private final BookBiz bookBiz = new BookBizImpl();
    private List<Book> bookList;

    public BookUpData() {
        initComponents();
    }

    /**
     * 输入为空判断
     *
     * @return true 为空
     */
    private boolean isNull() {
        if (StringUtil.isNull(idTextField.getText())) {
            JOptionPane.showMessageDialog(this, "请选择要修改的书！！");
            return true;
        }
        if (StringUtil.isNull(bookNameTextField.getText().trim())) {
            JOptionPane.showMessageDialog(this, StringUtil.isNullString("书名"));
            return true;
        }
        if (StringUtil.isNull(authorTextField.getText().trim())) {
            JOptionPane.showMessageDialog(this, StringUtil.isNullString("作者"));
            return true;
        }
        if (StringUtil.isNull(pressTextField.getText().trim())) {
            JOptionPane.showMessageDialog(this, StringUtil.isNullString("出版社"));
            return true;
        }
        if (publicationDatePicker.getDate() == null) {
            JOptionPane.showMessageDialog(this, StringUtil.isNullString("出版时间"));
            return true;
        }
        if (StringUtil.isNull(bookDepositTextField.getText())) {
            JOptionPane.showMessageDialog(this, StringUtil.isNullString("书籍押金"));
            return true;
        }
        if (StringUtil.isNull(typeTextField.getText())) {
            JOptionPane.showMessageDialog(this, StringUtil.isNullString("书籍类型"));
            return true;
        }
        if (StringUtil.isNull(bookDepositTextField.getText())) {
            JOptionPane.showMessageDialog(this, StringUtil.isNullString("在馆数量"));
            return true;
        }

        return false;
    }

    /**
     * 不合法检测
     *
     * @return true 不合法
     */
    public boolean isNotLegal() {
        if (StringUtil.isNotLegal(bookNameTextField.getText())) {
            JOptionPane.showMessageDialog(this, "书名存在敏感词汇或字符，如 and,or或#,*");
            return true;
        }
        if (StringUtil.isNotLegal(authorTextField.getText())) {
            JOptionPane.showMessageDialog(this, "作者名存在敏感词汇或字符，如 and,or或#,*");
            return true;
        }
        if (StringUtil.isNotLegal(pressTextField.getText())) {
            JOptionPane.showMessageDialog(this, "出版社存在敏感词汇或字符，如 and,or或#,*");
            return true;
        }
        return false;
    }

    /**
     * 表格加载时
     *
     * @param e 事件
     */
    private void bookInfoAncestorAdded(AncestorEvent e) {
        bookList = bookBiz.findAll();
        setTable();
    }

    /**
     * 设置表格显示
     */
    private void setTable() {
        DefaultTableModel bookInfoModel = (DefaultTableModel) bookInfo.getModel();
        bookInfoModel.setRowCount(0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        for (Book book : bookList) {
            Vector<java.io.Serializable> vector;
            vector = new Vector<>();
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
    }

    /**
     * 点击查询按钮的响应
     *
     * @param e 事件
     */
    private void inquireButtonActionPerformed(ActionEvent e) {
        bookList = bookBiz.findByString(strTextField.getText());
        if (bookList == null) {
            JOptionPane.showMessageDialog(this, "查询不到该书籍！！");
            return;
        }
        setTable();
    }

    /**
     * 选择表格中的数据时的响应
     *
     * @param e 事件
     */
    private void bookInfoMouseClicked(MouseEvent e) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date publicationData = null;
        DefaultTableModel bookInfoModel = (DefaultTableModel) bookInfo.getModel();
        int id = (int) bookInfoModel.getValueAt(bookInfo.getSelectedRow(), 0);
        String bookName = (String) bookInfoModel.getValueAt(bookInfo.getSelectedRow(), 1);
        String author = (String) bookInfoModel.getValueAt(bookInfo.getSelectedRow(), 2);
        String press = (String) bookInfoModel.getValueAt(bookInfo.getSelectedRow(), 3);
        try {
            publicationData = sdf.parse((String) bookInfoModel.getValueAt(bookInfo.getSelectedRow(), 4));
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }

        String type = (String) bookInfoModel.getValueAt(bookInfo.getSelectedRow(), 5);
        float bookDeposit = (float) bookInfoModel.getValueAt(bookInfo.getSelectedRow(), 6);
        int count = (int) bookInfoModel.getValueAt(bookInfo.getSelectedRow(), 8);
        idTextField.setText("" + id);
        bookNameTextField.setText(bookName);
        authorTextField.setText(author);
        pressTextField.setText(press);
        publicationDatePicker.setDate(publicationData);
        typeTextField.setText(type);
        bookDepositTextField.setText("" + bookDeposit);
        countTextField.setText("" + count);
    }

    /**
     * 点击删除按钮的响应
     *
     * @param e 事件
     */
    private void deleteButtonActionPerformed(ActionEvent e) {
        String idText = idTextField.getText();
        if (StringUtil.isNull(idText)) {
            JOptionPane.showMessageDialog(this, "请选择要删除的书籍！！");
            return;
        }
        int id = Integer.parseInt(idText);
        if (JOptionPane.showConfirmDialog(this, "确定删除" + id + "这本书吗！！") != JOptionPane.OK_OPTION) {
            return;
        }
        boolean flag = bookBiz.delBook(id);
        if (!flag) {
            JOptionPane.showMessageDialog(this, "删除失败！！");
            return;
        }
        JOptionPane.showMessageDialog(this, "删除成功！！");
        inquireButtonActionPerformed(e);
    }

    /**
     * 点击修改的响应
     *
     * @param e 事件
     */
    private void enterButtonActionPerformed(ActionEvent e) {
        if (isNull()) {
            return;
        }
        int id = Integer.parseInt(idTextField.getText());
        String bookName = bookNameTextField.getText();
        String author = authorTextField.getText();
        String press = pressTextField.getText();
        Date date = publicationDatePicker.getDate();
        Timestamp publicationDate = new Timestamp(date.getTime());
        float bookDeposit;
        try {
            bookDeposit = Float.parseFloat(bookDepositTextField.getText());
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(this, "书籍押金输入不合法！！");
            return;
        }
        String type = typeTextField.getText();
        int count;
        try {
            count = Integer.parseInt(countTextField.getText());
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(this, "在库数量输入不合法！！");
            return;
        }
        Book newBook = new Book(id, bookName, author, press, publicationDate, type, bookDeposit, count);
        if (bookList.get(bookInfo.getSelectedRow()).equals(newBook)) {
            JOptionPane.showMessageDialog(this, "书籍数据没有变化，无法修改！！");
            return;
        }
        boolean flag = bookBiz.updateBookInfo(newBook.getId(), newBook);
        if (!flag) {
            JOptionPane.showMessageDialog(this, "存在同名同作者的图书！！");
            return;
        }
        JOptionPane.showMessageDialog(this, "修改成功！！");
    }


    /**
     * 自动生成的可视化主体
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        strTextField = new JTextField();
        inquireButton = new JButton();
        scrollPane1 = new JScrollPane();
        bookInfo = new JTable();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        idTextField = new JTextField();
        bookNameTextField = new JTextField();
        authorTextField = new JTextField();
        pressTextField = new JTextField();
        bookDepositTextField = new JTextField();
        countTextField = new JTextField();
        typeTextField = new JTextField();
        publicationDatePicker = new JXDatePicker();
        enterButton = new JButton();
        deleteButton = new JButton();

        //======== this ========
        setVisible(true);
        setClosable(true);
        setMaximizable(true);
        setTitle("\u67e5\u770b\u56fe\u4e66");
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
                    {null, null, null, null, null, null, null, null, null, null, null},
                },
                new String[] {
                    "id", "\u4e66\u540d", "\u4f5c\u8005", "\u51fa\u7248\u793e", "\u51fa\u7248\u65e5\u671f", "\u7c7b\u578b", "\u4e66\u7c4d\u62bc\u91d1", "\u4e66\u7c4d\u6570\u91cf", "\u5728\u9986\u6570\u91cf", "\u5df2\u501f\u51fa\u6570\u91cf", "\u603b\u501f\u51fa\u6570\u91cf"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Float.class, Integer.class, Integer.class, Integer.class, Integer.class
                };
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false, false, false, false, false, false, false, false
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
            bookInfo.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    bookInfoMouseClicked(e);
                }
            });
            scrollPane1.setViewportView(bookInfo);
        }

        //---- label2 ----
        label2.setText("\u4e66\u7c4dID\uff1a");
        label2.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
        label2.setIcon(new ImageIcon(getClass().getResource("/img/id.png")));

        //---- label3 ----
        label3.setText("\u4e66\u7c4d\u540d\u79f0\uff1a");
        label3.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
        label3.setIcon(new ImageIcon(getClass().getResource("/img/\u4e66.png")));

        //---- label4 ----
        label4.setText("\u4e66\u7c4d\u4f5c\u8005\uff1a");
        label4.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
        label4.setIcon(new ImageIcon(getClass().getResource("/img/\u4f5c\u8005.png")));

        //---- label5 ----
        label5.setText("\u51fa\u7248\u793e\uff1a");
        label5.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
        label5.setIcon(new ImageIcon(getClass().getResource("/img/\u51fa\u7248\u793e.png")));

        //---- label6 ----
        label6.setText("\u51fa\u7248\u65e5\u671f\uff1a");
        label6.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
        label6.setIcon(new ImageIcon(getClass().getResource("/img/\u65e5\u671f.png")));

        //---- label7 ----
        label7.setText("\u4e66\u7c4d\u62bc\u91d1\uff1a");
        label7.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
        label7.setIcon(new ImageIcon(getClass().getResource("/img/\u62bc\u91d1.png")));

        //---- label8 ----
        label8.setText("\u7c7b\u578b\uff1a");
        label8.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
        label8.setIcon(new ImageIcon(getClass().getResource("/img/\u7c7b\u578b.png")));

        //---- label9 ----
        label9.setText("\u5728\u9986\u6570\u91cf\uff1a");
        label9.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
        label9.setIcon(new ImageIcon(getClass().getResource("/img/\u8ba1\u6570.png")));

        //---- idTextField ----
        idTextField.setEditable(false);

        //---- enterButton ----
        enterButton.setText("\u786e\u8ba4\u4fee\u6539");
        enterButton.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
        enterButton.setIcon(new ImageIcon(getClass().getResource("/img/\u786e\u8ba4.png")));
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterButtonActionPerformed(e);
            }
        });

        //---- deleteButton ----
        deleteButton.setText("\u5220\u9664");
        deleteButton.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
        deleteButton.setIcon(new ImageIcon(getClass().getResource("/img/\u5220 \u9664.png")));
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteButtonActionPerformed(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(strTextField, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
                            .addGap(47, 47, 47)
                            .addComponent(inquireButton))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 883, GroupLayout.PREFERRED_SIZE)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(99, 99, 99)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                        .addComponent(label3, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                        .addComponent(label4, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                        .addComponent(label5, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                        .addComponent(label6, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                        .addComponent(label7, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                        .addComponent(label8, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                        .addComponent(label9, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                                    .addComponent(enterButton)))))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(55, 55, 55)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(idTextField, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                .addComponent(bookNameTextField, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                .addComponent(pressTextField, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                .addComponent(authorTextField, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                .addComponent(bookDepositTextField, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                .addComponent(typeTextField, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                .addComponent(countTextField, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                .addComponent(publicationDatePicker, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(185, 185, 185)
                            .addComponent(deleteButton)))
                    .addGap(191, 191, 191))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addComponent(strTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(inquireButton))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2)
                                .addComponent(idTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(42, 42, 42)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3)
                                .addComponent(bookNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(45, 45, 45)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4)
                                .addComponent(authorTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(41, 41, 41)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label5)
                                .addComponent(pressTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(53, 53, 53)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label6)
                                .addComponent(publicationDatePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(50, 50, 50)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label7)
                                .addComponent(bookDepositTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(55, 55, 55)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label8)
                                .addComponent(typeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(55, 55, 55)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label9)
                                .addComponent(countTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(34, 34, 34)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(enterButton)
                                .addComponent(deleteButton)))
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 695, GroupLayout.PREFERRED_SIZE))
                    .addGap(31, 31, 31))
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
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JTextField idTextField;
    private JTextField bookNameTextField;
    private JTextField authorTextField;
    private JTextField pressTextField;
    private JTextField bookDepositTextField;
    private JTextField countTextField;
    private JTextField typeTextField;
    private JXDatePicker publicationDatePicker;
    private JButton enterButton;
    private JButton deleteButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
