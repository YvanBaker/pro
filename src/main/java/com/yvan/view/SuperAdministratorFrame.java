/*
 * Created by JFormDesigner on Thu Aug 13 11:57:57 GMT+08:00 2020
 */

package com.yvan.view;

import javax.swing.*;
import java.awt.*;

/**
 * @author unknown
 */
public class SuperAdministratorFrame extends JFrame {
    public SuperAdministratorFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menu2 = new JMenu();
        menuItem3 = new JMenuItem();
        menuItem4 = new JMenuItem();
        menu3 = new JMenu();
        menuItem5 = new JMenuItem();
        desktopPane = new JDesktopPane();

        //======== this ========
        Container contentPane = getContentPane();

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u7528\u6237\u7ba1\u7406");
                menu1.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));

                //---- menuItem1 ----
                menuItem1.setText("ni");
                menu1.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText("ta");
                menu1.add(menuItem2);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("\u56fe\u4e66\u7ba1\u7406");
                menu2.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));

                //---- menuItem3 ----
                menuItem3.setText("text");
                menu2.add(menuItem3);

                //---- menuItem4 ----
                menuItem4.setText("text");
                menu2.add(menuItem4);
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("\u5173\u4e8e\u6211\u4eec");
                menu3.setFont(new Font("\u6977\u4f53", Font.BOLD, 16));

                //---- menuItem5 ----
                menuItem5.setText("\u5173\u4e8e\u6211\u4eec");
                menu3.add(menuItem5);
            }
            menuBar1.add(menu3);
        }
        setJMenuBar(menuBar1);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(desktopPane, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenu menu2;
    private JMenuItem menuItem3;
    private JMenuItem menuItem4;
    private JMenu menu3;
    private JMenuItem menuItem5;
    private JDesktopPane desktopPane;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
