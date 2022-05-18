/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.model;

/**
 * Laboratorio: #2 - Profesor: LUIS YOVANY ROMO PORTILLA
 * Esta clase contiene toda la informacion y comportamientos necesarios para poder definir como estaran
 * estructurados nuestros proveedores y sus funciones
 * @author Michael Stevens Cardenas Urbano | Cod.202123935
 * @author Steven Cardona Betancur | Cod.202126463
 */

public class Provider extends BusinessActor{
    private String businessName;
    private String category;

    public Provider(String identification) {
        super(identification);
    }

    public Provider(String identification,String category) {
        super(identification);
        this.category = category;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
