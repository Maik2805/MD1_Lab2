/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import supermarket.enums.PaymentMethod;
import supermarket.model.DailySummary;
import supermarket.model.Product;
import supermarket.model.Sale;

/**
 *
 * @author miccarurb
 */
public class SaleController {

    private final Set<Sale> salesHistory;

    SaleController() {
        salesHistory = new HashSet();
    }

    public Sale createSale(Sale sale) throws Exception {
        sale.calculateSale();
        return sale;
    }
    
    public void saveSale(Sale sale) throws Exception {
        if (!sale.isCalculated()) {
            createSale(sale);
        }
        salesHistory.add(sale);
    }
    
    public DailySummary generateDailySummary(){
        return generateDailySummary(0);
    }
    
    public DailySummary generateDailySummary(float initialCashAmount){
        DailySummary summary = new DailySummary();
        float totalAmount = 0;
        Map<String, Float> totalByPaymentMethod = new HashMap<>();
        Map<String, Float> totalByIvaType = new HashMap<>();
        Sale bestSale = null;
        float finalCashAmount = initialCashAmount;
        for (Sale sale : salesHistory) {
            //calc Total Amount
            totalAmount += sale.getTotalAmount();
            //Calc Total Amount By Payment Method
            addUpOrInsertToMap(totalByPaymentMethod, sale.getPaymentMethod(), sale.getPayableAmount());
            //Get best Sale;
            if(bestSale == null){
                bestSale = sale;
            } else {
                if(bestSale.getPayableAmount() < sale.getPayableAmount()){
                    bestSale = sale;
                }
            }
            //get final Cash Amount
            if (sale.getPaymentMethod().equals(PaymentMethod.CASH.getName())) {
                finalCashAmount += sale.getPayableAmount();
            }
            for (Product product : sale.getListProducts()) {
                //Calc Total By Iva Type
                float productValuePaid = product.getBasePrice() - (product.getBasePrice()* PaymentMethod.getByName(sale.getPaymentMethod()).getDiscount());
                addUpOrInsertToMap(totalByIvaType, product.getOriginType(), productValuePaid);
            }
        }
        summary.setBestSale(bestSale);
        summary.setTotalAmount(totalAmount);
        summary.setTotalByIvaType(totalByIvaType);
        summary.setTotalByPaymentMethod(totalByPaymentMethod);
        summary.setCashRequired(finalCashAmount);
        return summary;
    }
    
    private void addUpOrInsertToMap(Map<String, Float> storage, String key, float value){
        if(storage.containsKey(key)){
            storage.put(key, storage.get(key) + value);
        } else {
            storage.put(key, value);
        }
    }

}
