/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Category;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Chi Nguyen T-rex
 */
public class CategoryTableModel extends AbstractTableModel {
    private CategoryDAO categoryDAO = new CategoryDAO();
    
    private List<Category> list;
    private List<String> header = new ArrayList<>();

    public CategoryTableModel() {
        this.list = categoryDAO.getCategoryList();
        this.header.add("STT");
        this.header.add("Mã danh mục");
        this.header.add("Tên danh mục");
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return header.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return rowIndex + 1;
            case 1: return ((Category) list.get(rowIndex)).getIdCategory();
            case 2: return  ((Category) list.get(rowIndex)).getName();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return header.get(column);
    }
    
}
