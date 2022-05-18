/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.model;

/**
 * Laboratorio: #2 - Profesor: LUIS YOVANY ROMO PORTILLA
 * Esta clase contiene toda la informacion necesaria para poder definir como estaran compuestos nuestros productos
 * @author Michael Stevens Cardenas Urbano | Cod.202123935
 * @author Steven Cardona Betancur | Cod.202126463
 */

public class Product {
    private String serial;
    private String name;
    private int ivaTaxPercent;
    private float basePrice;
    private Provider provider;
    private String origin;

    public Product(String serial, String name) {
        this.serial = serial;
        this.name = name;
    }

    public Product(String serial, String name, int ivaTaxPercent, float basePrice, Provider provider) {
        this.serial = serial;
        this.name = name;
        this.ivaTaxPercent = ivaTaxPercent;
        this.basePrice = basePrice;
        this.provider = provider;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIvaTaxPercent() {
        return ivaTaxPercent;
    }

    public void setIvaTaxPercent(int ivaTaxPercent) {
        this.ivaTaxPercent = ivaTaxPercent;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
