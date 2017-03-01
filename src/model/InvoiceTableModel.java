/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Item;
import entities.Product;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Chi Nguyen T-rex
 */
public class InvoiceTableModel extends AbstractTableModel {
    private List<Item> list;
    private List<String> header;
    
    public InvoiceTableModel(List<Item> list) {
        this.list = list;
        
        header = new ArrayList<>();
        header.add("STT");
        header.add("Sản phẩm");
        header.add("Số lượng");
        header.add("Đơn giá");
       
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
            case 1: return list.get(rowIndex).getProduct().getName();
            case 2: return list.get(rowIndex).getQuantity();
            case 3: return list.get(rowIndex).getProduct().getUnitPrice();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return header.get(column);
    }
    
    public int getIdProduct(int row) {
        return list.get(row).getProduct().getIdProduct();
    }
    
    public Product getProduct(int row) {
        return list.get(row).getProduct();
    }
    
    
    
}
