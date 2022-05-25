/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.controller;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import supermarket.model.Client;
import supermarket.model.Product;

/**
 * Laboratorio: #2 - Profesor: LUIS YOVANY ROMO PORTILLA
 * Se encarga de manipular nuestra lista de productos [Agregar, Eliminar, Actualizar, Obtener]
 * @author Michael Stevens Cardenas Urbano | Cod.202123935
 * @author Steven Cardona Betancur | Cod.202126463
 */
public class ProductController {
    private Set<Product> products;

    public ProductController() {
        products = new HashSet();
    }

    /**
     * Agrega un product a nuestra lista
     * @param product
     * @return Product
     */
    public Product addProduct(Product product){
        products.add(product);
        return product;
    }

    /**
     * Busca un producto por medio de su serial y lo devuelve de encontrarlo
     * @param serial
     * @return Optional<Product>
     */
    public Product findProductById(String serial) {
        return (Product) products.stream().filter(product -> product.getSerial().equals(serial));
    }

    /**
     * Busca un product especifico y lo devuelve de encontrarlo
     * @param product
     * @return Optional<Product>
     */
    public Product findProduct(Product product) {
        return (Product) products.stream().filter(product1 -> product1.equals(product));
    }

    /**
     * Actualizamos un producto existente con nuevos datos
     * @param product
     * @return Product
     */
    public Product updateClient(Product product){
        return product;
    }

    /**
     * Creamos un nuevo producto si no existe y se actualiza si ya esta en nuestra lista
     * @param product
     * @return Product
     */
    public Product createProduct(Product product){
        Product productFound = findProductById(product.getSerial());
        if (productFound != null) {
            return updateClient(productFound);
        }
        return addProduct(product);
    }

    /**
     * Eliminamos un producto especifico
     * @param product
     * @return boolean
     */
    public boolean removeProduct(Product product){
        return products.remove(product);
    }

    /**
     * Eliminamos un producto por medio de su serial
     * @param serial
     * @return boolean
     */
    public boolean removeProductById(String serial){
        Product productFound = findProductById(serial);
        return products.removeIf(product -> product.equals(productFound));
    }
    
    public void showMenu(){
        
    }
}
