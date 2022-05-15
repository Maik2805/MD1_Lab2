/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.model;

/**
 *
 * @author miccarurb
 */
public class Client extends BusinessActor{
    String name;
    String lastName;
    char gender;

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
