/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.controller;

import java.util.HashSet;
import java.util.Set;
import supermarket.model.Product;

/**
 *
 * @author miccarurb
 */
public class ProductController {
    Set<Product> products;

    public ProductController() {
        products = new HashSet();
    }
    
    public void addProduct(Product product){
        products.add(product);
    }
    
}
