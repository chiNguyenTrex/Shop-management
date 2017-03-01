/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Product;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Chi Nguyen T-rex
 */
public class MiniProductTableModel extends AbstractTableModel {
 
    private final List<Product> list;
    private final List<String> header;
    
    public MiniProductTableModel(List<Product> list) {
        this.list = list;
        header = new ArrayList<>();
        header.add("STT");  
        header.add("Tên sản phẩm");
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
            case 1: return list.get(rowIndex).getName();

            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return header.get(column);
    }
       
    public double getPrice(int row) {
        return list.get(row).getUnitPrice();
    }
    
    public int getIdProduct(int row) {
        return list.get(row).getIdProduct();
    }
    
    public Product getProduct(int row) {
        return list.get(row);
    }
    
}
