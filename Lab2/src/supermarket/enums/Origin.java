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
public enum Origin {

    LOCAL("LOCAL", "Producto nacional"),
    IMPORTED("IMPORTED", "Producto Importado");

    private final String name;
    private final String description;

    Origin(final String name, final String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    /**
     * Por medio del nombre sabremos si el producto es importado o local
     * @param name
     * @return Origin
     */
    public static Origin getOriginByName(String name) {
        try {
            return Origin.valueOf(name);
        } catch (Exception ex) {
            return null;
        }
    }
}
