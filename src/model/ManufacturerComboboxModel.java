/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Manufacturer;
import java.util.Vector;

/**
 *
 * @author Chi Nguyen T-rex
 */
public class ManufacturerComboboxModel {
    private ManufacturerDAO manufacturerDAO = new ManufacturerDAO();
    
    private Vector<String> list;
    
    public Vector<String> getModel() {
        list = new Vector<>();
        for(Manufacturer manufacturer : manufacturerDAO.getManufacturerList()) {
            list.add(manufacturer.getName());
        }
        return list;
    }
    
}
