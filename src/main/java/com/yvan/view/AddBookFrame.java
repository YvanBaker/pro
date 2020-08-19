/*
 * Created by JFormDesigner on Fri Aug 14 12:22:58 GMT+08:00 2020
 */

package com.yvan.view;

import com.yvan.biz.impl.BookBizImpl;
import com.yvan.util.StringUtil;
import com.yvan.util.TimeUtil;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @author unknown
 */
public class AddBookFrame extends JInternalFrame {
    public AddBookFrame() {
        initComponents();
    }

    /**
     * 输入为空判断
     *
     * @return true 为空
     */
    private boolean isNull() {
        if (StringUtil.isNull(bookNameTextField.getText())) {
            JOptionPane.showMessageDialog(this, StringUtil.isNullString("书籍书名"));
            return true;
        }
        if (StringUtil.isNull(authorTextField.getText())) {
            JOptionPane.showMessageDialog(this, StringUtil.isNullString("书籍作者"));
            return true;
        }
        if (StringUtil.isNull(pressTextField.getText())) {
            JOptionPane.showMessageDialog(this, StringUtil.isNullString("书籍出版社"));
            return true;
        }
        if (StringUtil.isNull(totalTextField.getText())) {
            JOptionPane.showMessageDialog(this, StringUtil.isNullString("书籍总数"));
            return true;
        }
        if (publicationDatePicker.getDate() == null) {
            JOptionPane.showMessageDialog(this, StringUtil.isNullString("出版时间"));
            return true;
        }
        if (StringUtil.isNull(typeTextField.getText())) {
            JOptionPane.showMessageDialog(this, StringUtil.isNullString("书籍类型"));
            return true;
        }
        if (StringUtil.isNull(bookDepositTextField.getText())) {
            JOptionPane.showMessageDialog(this, StringUtil.isNullString("书籍押金"));
            return true;
        }
        return false;
    }

    /**
     * 不合法检测
     *
     * @return false 合法
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
        if (TimeUtil.timeMoreCurrent(publicationDatePicker.getDate())) {
            JOptionPane.showMessageDialog(this, "出版时间不可以是未来！！！");
            return true;
        }
        return false;
    }

    /**
     * 点击确认添加时的响应
     *
     * @param e 点击事件
     */
    private void addActionPerformed(ActionEvent e) {
        if (isNull()) {
            return;
        }
        if (isNotLegal()) {
            return;
        }
        String bookName = bookNameTextField.getText();
        String author = authorTextField.getText();
        String press = pressTextField.getText();
        int total;
        try {
            total = Integer.parseInt(totalTextField.getText());
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(this, "书籍数量输入不合法，请重新输入！！");
            return;
        }
        if (total < 1) {
            JOptionPane.showMessageDialog(this, "书籍数量不能少于一本！！");
            return;
        }
        Date publicationDate = publicationDatePicker.getDate();
        String type = typeTextField.getText();
        float bookDeposit;
        try {
            bookDeposit = Float.parseFloat(bookDepositTextField.getText());
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(this, "书籍价格输入不合法，请重新输入！！");
            return;
        }
        boolean flag = new BookBizImpl().add(bookName, author, press, total, publicationDate, type, bookDeposit);
        if (!flag) {
            JOptionPane.showMessageDialog(this, "书籍以及存在，请到查询书籍中进行修改！！");
            return;
        }
        JOptionPane.showMessageDialog(this, "添加成功！！");
        resetButtonActionPerformed(e);
    }

    /**
     * 点击重置是的响应
     *
     * @param e 点击事件
     */
    private void resetButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        bookNameTextField.setText("");
        authorTextField.setText("");
        pressTextField.setText("");
        totalTextField.setText("");
        publicationDatePicker.setDate(null);
        typeTextField.setText("");
        bookDepositTextField.setText("");
    }


    /**
     * 自动生成的窗体代码
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        bookNameTextField = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        pressTextField = new JTextField();
        authorTextField = new JTextField();
        publicationDatePicker = new JXDatePicker();
        label6 = new JLabel();
        totalTextField = new JTextField();
        typeTextField = new JTextField();
        add = new JButton();
        resetButton = new JButton();
        label7 = new JLabel();
        bookDepositTextField = new JTextField();

        //======== this ========
        setVisible(true);
        setClosable(true);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setTitle("\u6dfb\u52a0\u56fe\u4e66");
        setMinimumSize(null);
        setMaximizable(true);
        setMaximumSize(null);
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u4e66\u7c4d\u540d\u79f0\uff1a");
        label1.setFont(new Font("\u65b0\u5b8b\u4f53", Font.BOLD, 16));
        label1.setIcon(new ImageIcon(getClass().getResource("/img/\u4e66.png")));

        //---- label2 ----
        label2.setText("\u4e66\u7c4d\u4f5c\u8005\uff1a");
        label2.setFont(new Font("\u65b0\u5b8b\u4f53", Font.BOLD, 16));
        label2.setIcon(new ImageIcon(getClass().getResource("/img/\u4f5c\u8005.png")));

        //---- label3 ----
        label3.setText("\u4e66\u7c4d\u51fa\u7248\u793e\uff1a");
        label3.setFont(new Font("\u65b0\u5b8b\u4f53", Font.BOLD, 16));
        label3.setIcon(new ImageIcon(getClass().getResource("/img/\u51fa\u7248\u793e.png")));

        //---- label4 ----
        label4.setText("\u4e66\u7c4d\u603b\u6570\uff1a");
        label4.setFont(new Font("\u65b0\u5b8b\u4f53", Font.BOLD, 16));
        label4.setIcon(new ImageIcon(getClass().getResource("/img/\u8ba1\u6570.png")));

        //---- label5 ----
        label5.setText("\u4e66\u7c4d\u51fa\u7248\u65e5\u671f\uff1a");
        label5.setFont(new Font("\u65b0\u5b8b\u4f53", Font.BOLD, 16));
        label5.setIcon(new ImageIcon(getClass().getResource("/img/\u65e5\u671f.png")));

        //---- label6 ----
        label6.setText("\u4e66\u7c4d\u7c7b\u578b\uff1a");
        label6.setFont(new Font("\u65b0\u5b8b\u4f53", Font.BOLD, 16));
        label6.setIcon(new ImageIcon(getClass().getResource("/img/\u7c7b\u578b.png")));

        //---- add ----
        add.setText("\u786e\u8ba4\u6dfb\u52a0");
        add.setIcon(new ImageIcon(getClass().getResource("/img/\u786e\u8ba4.png")));
        add.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addActionPerformed(e);
            }
        });

        //---- resetButton ----
        resetButton.setText("\u91cd\u7f6e");
        resetButton.setIcon(new ImageIcon(getClass().getResource("/img/\u91cd\u7f6e.png")));
        resetButton.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetButtonActionPerformed(e);
            }
        });

        //---- label7 ----
        label7.setText("\u4e66\u7c4d\u62bc\u91d1\uff1a");
        label7.setFont(new Font("\u65b0\u5b8b\u4f53", Font.BOLD, 16));
        label7.setIcon(new ImageIcon(getClass().getResource("/img/\u62bc\u91d1.png")));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label7))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(add)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                    .addComponent(pressTextField, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bookNameTextField, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))
                                .addComponent(publicationDatePicker, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
                            .addGap(58, 58, 58)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(authorTextField, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(totalTextField, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(resetButton))
                                    .addGap(18, 18, 18)
                                    .addComponent(typeTextField, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))))
                        .addComponent(bookDepositTextField, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(120, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(95, 95, 95)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addComponent(authorTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(53, 53, 53)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addComponent(totalTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(pressTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(46, 46, 46)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addComponent(typeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addComponent(publicationDatePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(41, 41, 41)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookDepositTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(41, 41, 41)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(add)
                        .addComponent(resetButton))
                    .addContainerGap(128, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JTextField bookNameTextField;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField pressTextField;
    private JTextField authorTextField;
    private JXDatePicker publicationDatePicker;
    private JLabel label6;
    private JTextField totalTextField;
    private JTextField typeTextField;
    private JButton add;
    private JButton resetButton;
    private JLabel label7;
    private JTextField bookDepositTextField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
