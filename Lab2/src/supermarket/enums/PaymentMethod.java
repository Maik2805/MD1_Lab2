/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.enums;

/**
 *
 * @author miccarurb
 */
public enum PaymentMethod {
    CASH("Efectivo", 20, 0.20f),
    CHECK("Cheque", 15, 0.15f),
    DEBITCARD("Tarjeta Débito", 17, 0.17f),
    CREDITCARD("Tarjeta Crédito", 10, 0.10f),
    CREDIT("Crédito", 0, 0.0f);

    private final String name;
    private final int discountPercent;
    private final float discount;

    PaymentMethod(final String name, int discountPercent, float discount) {
            this.name = name;
            this.discountPercent = discountPercent;
            this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public float getDiscount() {
        return discount;
    }

    /**
     * Por medio del nombre obtenemos cual es el tipo de pago
     * @param name
     * @return PaymentMethod
     */
    public static PaymentMethod getByName(String name) {
        try {
            return PaymentMethod.valueOf(name);
        } catch (Exception ex) {
            return null;
        }
    }
}
