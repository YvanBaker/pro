/*
 * Created by JFormDesigner on Fri Aug 14 12:22:58 GMT+08:00 2020
 */

package com.yvan.view;

import com.yvan.biz.impl.BookBizImpl;
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

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String bookName = bookNameTextField.getText();
        String author = authorTextField.getText();
        String press = pressTextField.getText();
        int total = Integer.parseInt(totalTextField.getText());
        Date publicationDate = publicationDatePicker.getDate();
        String type = typeTextField.getText();
        boolean flag = new BookBizImpl().add(bookName,author,press,total,publicationDate,type);
        if (!flag){
            JOptionPane.showMessageDialog(this, "书籍以及存在！！");
            return;
        }
        JOptionPane.showMessageDialog(this, "添加成功！！");
    }

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
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setVisible(true);
        setClosable(true);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setMaximizable(true);
        setTitle("\u6dfb\u52a0\u56fe\u4e66");
        setMinimumSize(null);
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

        //---- button1 ----
        button1.setText("\u786e\u8ba4\u6dfb\u52a0");
        button1.setIcon(new ImageIcon(getClass().getResource("/img/\u786e\u8ba4.png")));
        button1.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1ActionPerformed(e);
            }
        });

        //---- button2 ----
        button2.setText("\u91cd\u7f6e");
        button2.setIcon(new ImageIcon(getClass().getResource("/img/\u91cd\u7f6e.png")));
        button2.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(bookNameTextField, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                                .addComponent(pressTextField, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(button1)
                                .addComponent(publicationDatePicker, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))))
                    .addGap(81, 81, 81)
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
                                .addComponent(button2)
                                .addComponent(label6, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(typeTextField, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(110, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(95, 95, 95)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addComponent(authorTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(53, 53, 53)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addComponent(pressTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addComponent(totalTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(46, 46, 46)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addComponent(publicationDatePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addComponent(typeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(114, 114, 114)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addContainerGap(130, Short.MAX_VALUE))
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
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
