package entities;
// Generated Oct 25, 2016 9:57:21 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Manufacturer generated by hbm2java
 */
public class Manufacturer  implements java.io.Serializable {


     private Integer idManufacturer;
     private String name;
     private Set products = new HashSet(0);

    public Manufacturer() {
    }

	
    public Manufacturer(String name) {
        this.name = name;
    }
    public Manufacturer(String name, Set products) {
       this.name = name;
       this.products = products;
    }
   
    public Integer getIdManufacturer() {
        return this.idManufacturer;
    }
    
    public void setIdManufacturer(Integer idManufacturer) {
        this.idManufacturer = idManufacturer;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Set getProducts() {
        return this.products;
    }
    
    public void setProducts(Set products) {
        this.products = products;
    }




}


