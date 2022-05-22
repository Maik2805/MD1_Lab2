/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.model;

import java.util.Map;

/**
 *
 * @author miccarurb
 */
public class DailySummary {
    private float totalAmount;
    private Map<String, Float> totalByPaymentMethod;
    private Map<String, Float> totalByIvaType;
    private Sale bestSale;
    private float cashRequired;

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Map<String, Float> getTotalByPaymentMethod() {
        return totalByPaymentMethod;
    }

    public void setTotalByPaymentMethod(Map<String, Float> totalByPaymentMethod) {
        this.totalByPaymentMethod = totalByPaymentMethod;
    }

    public Map<String, Float> getTotalByIvaType() {
        return totalByIvaType;
    }

    public void setTotalByIvaType(Map<String, Float> totalByIvaType) {
        this.totalByIvaType = totalByIvaType;
    }

    public Sale getBestSale() {
        return bestSale;
    }

    public void setBestSale(Sale bestSale) {
        this.bestSale = bestSale;
    }

    public float getCashRequired() {
        return cashRequired;
    }

    public void setCashRequired(float cashRequired) {
        this.cashRequired = cashRequired;
    }
    
    
    
}
