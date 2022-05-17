/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.controller;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import static java.util.function.Predicate.isEqual;
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

    public Client addClient(Client client) {
        clients.add(client);
        return client;
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Client> findClientById(String id) {
        return clients.stream().filter(c -> c.getIdentification().equals(id)).findAny();
    }
    
    public Optional<Client> findClient(Client client) {
        return clients.stream().filter(isEqual(client)).findAny();
    }
    
    public Client updateClient(Client client){
        // Java funciona por referencias al objecto real, por lo que el uso de un metodo setter en cualquier otra clase
        // va a modificar el objeto en todas las variables del contexto que lo referencien.
        return client;
    }

    public Client createOrUpdateClient(Client client) {
        Optional<Client> clientFound = findClientById(client.getIdentification());
        if (clientFound.isPresent()) {
            return updateClient(clientFound.get());
        }
        return addClient(client);
    }

    public boolean removeClient(Client client){
        if (clients.contains(client)) {
            clients.remove(client);
        }
        return true;
    }
    
    public boolean removeClientById(String id){
        Optional<Client> clientFound = findClientById(id);
        if (clientFound.isPresent()) {
            removeClient(clientFound.get());
        }
        return true;
    }
}
