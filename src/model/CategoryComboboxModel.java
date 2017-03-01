/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Category;
import java.util.Vector;

/**
 *
 * @author Chi Nguyen T-rex
 */
public class CategoryComboboxModel {
    private CategoryDAO categoryDAO = new CategoryDAO();
    private Vector<String> list;
    public Vector<String> getModel() {
        list = new Vector<>();
        for(Category category : categoryDAO.getCategoryList()) {
            list.add(category.getName());
        }
        return list;
    }
}
