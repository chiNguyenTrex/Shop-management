/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Chi Nguyen T-rex
 */
public class EmployeeTableModel extends AbstractTableModel {
    private List<Employee> list;
    private List<String> header;
    
    public EmployeeTableModel(List<Employee> list) {
        this.list = list;
        header = new ArrayList<>();
        header.add("STT");
        header.add("Họ và tên");
        header.add("Username");
        header.add("Giới tính");
        header.add("Role");
        header.add("Birthday");
        header.add("Số điện thoại");
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
            case 2: return list.get(rowIndex).getUsername();
            case 3: return list.get(rowIndex).getSex();
            case 4: return list.get(rowIndex).getRole();
            case 5: return list.get(rowIndex).getDateOfBirth();
            case 6: return list.get(rowIndex).getPhone();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return header.get(column);
    }
    
    
    
    public String getImage(int rowIndex) {
        return list.get(rowIndex).getImage();
    }
    
    public int getIdEmployee(int rowIndex) {
        return list.get(rowIndex).getIdEmployee();
    }
    
    public String getEmail(int rowIndex) {
        return list.get(rowIndex).getEmail();
    }
    
    public String getPassword(int rowIndex) {
        return list.get(rowIndex).getPassword();
    }
    
    public String getPhoneNumber(int rowIndex) {
        return list.get(rowIndex).getPhone();
    }
    
}
