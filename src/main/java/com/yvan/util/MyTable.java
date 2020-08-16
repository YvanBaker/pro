package com.yvan.util;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

/**
 * @author Yvan
 * @Description TODO
 * @Classname MyTable
 * @Date 2020/8/16 14:26
 */
public class MyTable extends JTable {
    /**
     * 重写JTable类的构造方法
     *
     * @param tableModel table
     */
    public MyTable(DefaultTableModel tableModel) {// Vector rowData, Vector columnNames
        // 调用父类的构造方法
        super(tableModel);

    }

    public MyTable(final Object[][] rowData, final Object[] columnNames) {
        super(rowData, columnNames);
    }

    /**
     * 重写JTable类的getTableHeader()方法
     *
     * @return
     */
    @Override
    public JTableHeader getTableHeader() { // 定义表格头
        // 获得表格头对象
        JTableHeader tableHeader = super.getTableHeader();
        // 设置表格列不可重排
        tableHeader.setReorderingAllowed(false);
        // 获得表格头的单元格对象
        DefaultTableCellRenderer hr = (DefaultTableCellRenderer) tableHeader.getDefaultRenderer();
        // 设置列名居中显示
        hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        return tableHeader;
    }

    /**
     * 重写JTable类的getDefaultRenderer(Class<?> columnClass)方法
     * @param columnClass
     * @return
     */
    @Override
    public TableCellRenderer getDefaultRenderer(Class<?> columnClass) { // 定义单元格
        // 获得表格的单元格对象
        DefaultTableCellRenderer cr = (DefaultTableCellRenderer) super.getDefaultRenderer(columnClass);
        // 设置单元格内容居中显示
        cr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        return cr;
    }

    /**
     * 重写JTable类的isCellEditable(int row, int column)方法
     * @param row
     * @param column
     * @return
     */
    @Override
    public boolean isCellEditable(int row, int column) { // 表格不可编辑
        return false;
    }
}
