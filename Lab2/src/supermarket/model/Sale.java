package supermarket.model;

import java.util.ArrayList;
import supermarket.enums.PaymentMethod;

/**
 * Laboratorio: #2 - Profesor: LUIS YOVANY ROMO PORTILLA Esta clase contiene
 * toda la informacion necesaria para poder identificar nuestras ventas y todos
 * sus responsables
 *
 * @author Michael Stevens Cardenas Urbano | Cod.202123935
 * @author Steven Cardona Betancur | Cod.202126463
 */
public class Sale {

    private Employee seller;
    private String idSale;
    private Client client;
    private ArrayList<Product> listProducts;
    private String paymentMethod;
    private float totalAmount;
    private float totalIvaAmount;
    private float totalDiscount;
    private float payableAmount;
    private boolean calculated;

    public Sale() {
        listProducts = new ArrayList<>();
    }

    public void addProduct(Product product) {
        listProducts.add(product);
    }

    public boolean removeProduct(Product product) {
        return listProducts.remove(product);
    }

    public boolean removeProductById(String serial) {
        return listProducts.removeIf(product -> product.getSerial().equals(serial));
    }

    public Sale(String idSale, Employee seller, Client client, ArrayList<Product> listProducts, String paymentMethod) {
        this.seller = seller;
        this.idSale = idSale;
        this.client = client;
        this.listProducts = listProducts;
        this.paymentMethod = paymentMethod;
        this.calculated = false;
    }

    public boolean calculateSale() {
        if (paymentMethod == null || paymentMethod.isEmpty()) {
            return false;
        }
        float discountPercent = PaymentMethod.getByName(paymentMethod).getDiscount();
        totalAmount = 0;
        totalIvaAmount = 0;
        for (Product product : listProducts) {
            float productIva = (float) (product.getIvaTaxPercent()) / 100;
            totalIvaAmount += product.getBasePrice() * productIva;
            totalAmount += product.getBasePrice() + product.getBasePrice() * productIva;
        }
        totalDiscount = totalAmount * discountPercent;
        payableAmount = totalAmount - totalDiscount;
        calculated = true;
        return true;
    }

    /**
     * va a simular una factura la cual se mostrara en pantalla para nuestro
     * cliente
     *
     * @return String
     */
    public String printInvoice() {
        return "";
    }

    /**
     * Se encarga de calcular cual va ser el monto total que el cliente debera
     * pagar
     *
     * @return float
     */
    public float calcAmount() {
        return 10;
    }

    public Employee getSeller() {
        return seller;
    }

    public void setSeller(Employee seller) {
        this.seller = seller;
    }

    public String getIdSale() {
        return idSale;
    }

    public void setIdSale(String idSale) {
        this.idSale = idSale;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<Product> getListProducts() {
        return listProducts;
    }

    public void setListProducts(ArrayList<Product> listProducts) {
        this.listProducts = listProducts;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean isCalculated() {
        return calculated;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public float getTotalIvaAmount() {
        return totalIvaAmount;
    }

    public float getTotalDiscount() {
        return totalDiscount;
    }

    public float getPayableAmount() {
        return payableAmount;
    }

}
