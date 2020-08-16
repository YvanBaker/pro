/*
 * Created by JFormDesigner on Sun Aug 16 21:57:29 GMT+08:00 2020
 */

package com.yvan.view;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author unknown
 */
public class BorrowBookFrame extends JInternalFrame {
    public BorrowBookFrame() {
        initComponents();
    }

    private void inquireButtonActionPerformed(ActionEvent e) {
    }

    private void bookInfoAncestorAdded(AncestorEvent e) {
    }

    private void bookInfoMouseClicked(MouseEvent e) {
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

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(154, 154, 154)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(strTextField, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
                            .addGap(44, 44, 44)
                            .addComponent(inquireButton))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 753, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(86, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(12, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addComponent(strTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(inquireButton))
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 553, GroupLayout.PREFERRED_SIZE)
                    .addGap(69, 69, 69))
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
