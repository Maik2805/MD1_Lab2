/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import supermarket.controller.ClientController;
import supermarket.controller.ProductController;
import supermarket.controller.ProviderController;
import supermarket.controller.SaleController;
import supermarket.enums.Origin;
import supermarket.enums.PaymentMethod;
import supermarket.model.Client;
import supermarket.model.Employee;
import supermarket.model.Product;
import supermarket.model.Provider;
import supermarket.model.Sale;
import supermarket.utils.DialogValidator;

/**
 * Laboratorio: #2 - Profesor: LUIS YOVANY ROMO PORTILLA Es nuestra clase
 * principal que se encarga de toda la ejecucion del programa
 *
 * @author Michael Stevens Cardenas Urbano | Cod.202123935
 * @author Steven Cardona Betancur | Cod.202126463
 */
public class RunTimeEnvironment {

    ClientController clientController;
    ProductController productController;
    ProviderController providerController;
    SaleController saleController;
    Employee employee;
    final float initialCashAmount;
    static int saleAcumulator = 1;

    public RunTimeEnvironment(Employee cashier, float initialAmount) {
        clientController = new ClientController();
        productController = new ProductController();
        providerController = new ProviderController();
        saleController = new SaleController();
        employee = cashier;
        initialCashAmount = initialAmount;
    }

    public void initializeSupermarketData() {
        clientController.addClient(new Client("1006207277", "Michael", "Cardenas"));
        clientController.addClient(new Client("1122334455", "Fulanito", "Detal"));

        Provider bimbo = new Provider("Bimbo", "Pan");
        Provider alpina = new Provider("Alpina", "Lacteos");
        Provider nestleUsa = new Provider("Alpina", "Lacteos");
        Product productoExterno = new Product("5522", "teExotico", 25, 12800, nestleUsa);
        productoExterno.setOrigin(Origin.IMPORTED.getName());
        providerController.addProvider(bimbo);
        providerController.addProvider(alpina);
        productController.addProduct(new Product("1234", "Leche Deslactosada", 19, 4000, alpina));
        productController.addProduct(new Product("9876", "Pan Tajado", 19, 6500, bimbo));
        productController.addProduct(productoExterno);
    }

    public void showInitialMenu() {
        String initialMenu = "-- SUPERMARKET UNIVALLE --"
                + "\n 1.Registrar Venta."
                + "\n 2.Gestionar Productos"
                + "\n 3.Gestionar Clientes"
                + "\n 4.Gestionar Provedores"
                + "\n 5.Genersr Reporte"
                + "\n 0.Salir";
        do {
            List<String> validInputs = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "0"));
            String result = DialogValidator.inputStr(initialMenu, validInputs);
            switch (result) {
                case "1":
                    showSaleMenu();
                    break;
                case "2":
//                    productController.showMenu();
                    break;
                case "3":
//                    clientController.showMenu();
                    break;
                case "4":
//                    providerController.showMenu();
                    break;
                case "5":
//                    saleController.showReport(initialCashAmount);
                    break;
                case "0":
                    return;
            }
        } while (true);
    }

    public void showSaleMenu() {
        String menu = "1. Seleccionar Cliente"
                + "\n2. Agregar Productos"
                + "\n3. Retirar Productos"
                + "\n4. Mostrar Productos"
                + "\n5. Seleccionar Metodo de Pago"
                + "\n6. Calcular Venta"
                + "\n7 Registrar Venta"
                + "\n0 Volver.";
        Sale sale = new Sale();
        sale.setSeller(employee);
        sale.setIdSale(String.valueOf(saleAcumulator++));
        Client client = null;
        Product product = null;
        PaymentMethod paymentMethod = null;
        do {
            List<String> validInputs = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "0"));
            String result = DialogValidator.inputStr(menu, validInputs);
            switch (result) {
                case "1":
                    client = clientController.selectClient();
                    if (client != null) {
                        sale.setClient(client);
                    }
                    break;
                case "2":
                    product = productController.selectProduct();
                    if (product != null) {
                        sale.addProduct(product);
                    }
                    break;
                case "3":
                    product = productController.selectProduct();
                    if (product != null) {
                        sale.removeProduct(product);
                    }
                    break;
                case "4":
                    productController.showProducts(sale.getListProducts());
                    break;
                case "5":
                    paymentMethod = SaleController.selectPaymentMethod();
                    if (paymentMethod != null){
                        sale.setPaymentMethod(paymentMethod.name());
                    }
                    break;
                case "6": {
                    try {
                        saleController.createSale(sale);
                    } catch (Exception ex) {
                        Logger.getLogger(RunTimeEnvironment.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case "0":
                    return;
            }

        } while (true);

    }
}
