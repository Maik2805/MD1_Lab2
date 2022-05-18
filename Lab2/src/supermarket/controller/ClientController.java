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
 * Laboratorio: #2 - Profesor: LUIS YOVANY ROMO PORTILLA
 * Se encarga de manipular nuestra lista de clientes [Agregar, Eliminar, Actualizar, Obtener]
 * @author Michael Stevens Cardenas Urbano | Cod.202123935
 * @author Steven Cardona Betancur | Cod.202126463
 */
public class ClientController {

    private Set<Client> clients;

    public ClientController() {
        clients = new HashSet();
    }

    /**
     * Agrega un Cliente a nuestra lista
     * @param client
     * @return client
     */
    public Client addClient(Client client) {
        clients.add(client);
        return client;
    }

    /**
     * Busca un cliente por medio de su id y lo devuelve de encontrarlo
     * @param id
     * @return Optional<Client>
     */
    public Optional<Client> findClientById(String id) {
        return clients.stream().filter(c -> c.getIdentification().equals(id)).findAny();
    }

    /**
     * Busca un cliente especifico y lo devuelve de encontrarlo
     * @param client
     * @return Optional<Client>
     */
    public Optional<Client> findClient(Client client) {
        return clients.stream().filter(isEqual(client)).findAny();
    }

    /**
     * Actualizamos un cliente existente con nuevos datos
     * @param client
     * @return Client
     */
    public Client updateClient(Client client){
        // Java funciona por referencias al objecto real, por lo que el uso de un metodo setter en cualquier otra clase
        // va a modificar el objeto en todas las variables del contexto que lo referencien.
        return client;
    }

    /**
     * Creamos un nuevo cliente si no existe y se actualiza si ya esta en nuestra lista
     * @param client
     * @return Client
     */
    public Client createOrUpdateClient(Client client) {
        Optional<Client> clientFound = findClientById(client.getIdentification());
        if (clientFound.isPresent()) {
            return updateClient(clientFound.get());
        }
        return addClient(client);
    }

    /**
     * Eliminamos un cliente especifico
     * @param client
     * @return boolean
     */
    public boolean removeClient(Client client){
        if (clients.contains(client)) {
            clients.remove(client);
        }
        return true;
    }

    /**
     * Eliminamos un cliente por medio de su id
     * @param id
     * @return boolean
     */
    public boolean removeClientById(String id){
        Optional<Client> clientFound = findClientById(id);
        if (clientFound.isPresent()) {
            removeClient(clientFound.get());
        }
        return true;
    }
}
