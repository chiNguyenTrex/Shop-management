/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Chi Nguyen T-rex
 */
public class Cart {
    private HashMap<Integer, Item> cartItem;
    
    public Cart() {
        cartItem = new HashMap<>();
    }
    
    public Cart(HashMap<Integer, Item> cart) {
        cartItem = cart;
    }
    
    public HashMap<Integer, Item> getCart() {
        return cartItem;
    }
    
    public void addToCart(Integer key, Item item) {
        cartItem.put(key, item);
    }
    
    public void removeFromCart(Integer key) {
        cartItem.remove(key);
    }
    
    public int numberOfItem() {
        return cartItem.size();
    }
    
    public double sumPrice() {
        double price = 0;
        for (Map.Entry<Integer, Item> entrySet : cartItem.entrySet()) {
            price += entrySet.getValue().getProduct().getUnitPrice();
        }
        return price;
    }
    
}
