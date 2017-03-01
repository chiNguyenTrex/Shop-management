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
public class ProductTableModel extends AbstractTableModel {
 
    private final List<Product> list;
    private final List<String> header;
    
    public ProductTableModel(List<Product> list) {
        this.list = list;
        header = new ArrayList<>();
        header.add("STT");
        header.add("Danh mục");
        header.add("Thương hiệu");
        header.add("Mã sản phẩm");
        header.add("Tên sản phẩm");
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
            case 1: return list.get(rowIndex).getCategory().getName();
            case 2: return list.get(rowIndex).getManufacturer().getName();
            case 3: return list.get(rowIndex).getIdProduct();
            case 4: return list.get(rowIndex).getName();
            case 5: return list.get(rowIndex).getQuantity();
            case 6: return list.get(rowIndex).getUnitPrice();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return header.get(column);
    }
    
    public String getImageProduct(int row) {
        return list.get(row).getImage();
    }
    
    public String getUnit(int row) {
        return list.get(row).getUnit();
    }
    
}
