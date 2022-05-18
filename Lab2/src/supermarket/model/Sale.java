package supermarket.model;
import java.util.ArrayList;

/**
 * Laboratorio: #2 - Profesor: LUIS YOVANY ROMO PORTILLA
 * Esta clase contiene toda la informacion necesaria para poder identificar nuestras ventas y todos sus responsables
 * @author Michael Stevens Cardenas Urbano | Cod.202123935
 * @author Steven Cardona Betancur | Cod.202126463
 */

public class Sale {
    private Employee seller;
    private String idSale;
    private Client client;
    private ArrayList<Product> listProducts;
    private String paymentMethod;

    public Sale(Employee seller, String idSale, Client client, ArrayList<Product> listProducts, String paymentMethod) {
        this.seller = seller;
        this.idSale = idSale;
        this.client = client;
        this.listProducts = listProducts;
        this.paymentMethod = paymentMethod;
    }

    /**
     * va a simular una factura la cual se mostrara en pantalla para nuestro cliente
     * @return String
     */
    public String printInvoice() {
        return "";
    }

    /**
     * Se encarga de calcular cual va ser el monto total que el cliente debera pagar
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
}
