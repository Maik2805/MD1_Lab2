/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.controller;

import java.util.HashSet;
import java.util.Set;
import supermarket.model.Provider;

/**
 *
 * @author miccarurb
 */
public class ProviderController {
    Set<Provider> providers;

    public ProviderController() {
        providers = new HashSet();
    }
    
    public void addProvider(Provider provider){
        providers.add(provider);
    }
    
    
    
}
