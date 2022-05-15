/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.controller;

import java.util.HashSet;
import java.util.Set;
import supermarket.model.Client;

/**
 *
 * @author miccarurb
 */
public class ClientController {
    Set<Client> clients;

    public ClientController() {
        clients = new HashSet();
    }
    
    public void addClient(Client client){
        clients.add(client);
    }
    
    
}
