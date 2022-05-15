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
public class Provider extends BusinessActor{
    String businessName;
    String category;

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
