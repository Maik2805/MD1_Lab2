/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.util.HashSet;
import java.util.Set;
import supermarket.controller.ClientController;
import supermarket.controller.ProductController;
import supermarket.controller.ProviderController;
import supermarket.enums.Origin;
import supermarket.model.Client;
import supermarket.model.Product;
import supermarket.model.Provider;

/**
 * Laboratorio: #2 - Profesor: LUIS YOVANY ROMO PORTILLA
 * Es nuestra clase principal que se encarga de toda la ejecucion del programa
 * @author Michael Stevens Cardenas Urbano | Cod.202123935
 * @author Steven Cardona Betancur | Cod.202126463
 */
public class RunTimeEnvironment {
    ClientController clientController;
    ProductController productController;
    ProviderController providerController;

    public RunTimeEnvironment() {
        clientController = new ClientController();
        productController = new ProductController();
        providerController = new ProviderController();
    }

    public void initializeSupermarketData(){
        clientController.addClient(new Client("1006207277", "Michael","Cardenas"));
        clientController.addClient(new Client("1122334455", "Fulanito","Detal"));

        Provider bimbo = new Provider("Bimbo","Pan");
        Provider alpina = new Provider("Alpina","Lacteos");
        Provider nestleUsa = new Provider("Alpina","Lacteos");
        Product productoExterno = new Product("5522", "teExotico", 25, 12800, nestleUsa);
        productoExterno.setOrigin(Origin.IMPORTED.getName());
        providerController.addProvider(bimbo);
        providerController.addProvider(alpina);
        productController.addProduct(new Product("1234", "Leche Deslactosada", 19, 4000, alpina));
        productController.addProduct(new Product("9876", "Pan Tajado", 19, 6500, bimbo));
        productController.addProduct(productoExterno);
    }

}
