/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Manufacturer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Chi Nguyen T-rex
 */
public class ManufacturerTableModel extends AbstractTableModel {
    private ManufacturerDAO manufacturerDAO = new ManufacturerDAO();
    private List<Manufacturer> list;
    private List<String> header = new ArrayList<>();

    public ManufacturerTableModel() {
        list = manufacturerDAO.getManufacturerList();
        header.add("STT");
        header.add("Mã thương hiệu");
        header.add("Tên thương hiệu");
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
            case 1: return ((Manufacturer) list.get(rowIndex)).getIdManufacturer();
            case 2: return ((Manufacturer) list.get(rowIndex)).getName();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return header.get(column);
    }
    
}
