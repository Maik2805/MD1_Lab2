/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.model;

/**
 * Laboratorio: #2 - Profesor: LUIS YOVANY ROMO PORTILLA
 * Esta clase contiene toda la informacion y comportamientos necesarios para poder definir como estaran
 * estructurados nuestros clientes
 * @author Michael Stevens Cardenas Urbano | Cod.202123935
 * @author Steven Cardona Betancur | Cod.202126463
 */

public class Client extends BusinessActor{
    private String name;
    private String lastName;
    private char gender;

    public Client(String identification) {
        super(identification);
    }

    public Client(String identification,String name, String lastName) {
        super(identification);
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
