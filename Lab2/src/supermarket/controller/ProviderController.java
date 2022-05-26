/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.controller;

import java.util.HashSet;
import java.util.Set;

import supermarket.model.Product;
import supermarket.model.Provider;

/**
 * Laboratorio: #2 - Profesor: LUIS YOVANY ROMO PORTILLA
 * Se encarga de manipular nuestra lista de proveedores [Agregar, Eliminar, Actualizar, Obtener]
 * @author Michael Stevens Cardenas Urbano | Cod.202123935
 * @author Steven Cardona Betancur | Cod.202126463
 */
public class ProviderController {
    private Set<Provider> providers;

    public ProviderController() {
        providers = new HashSet();
    }

    /**
     * Agrega un proveedor a nuestra lista
     * @param provider
     * @return provider
     */
    public Provider addProvider(Provider provider){
        providers.add(provider);
        return provider;
    }

    /**
     * Busca un proveedor por medio de su id y lo devuelve de encontrarlo
     * @param id
     * @return Provider
     */
    public Provider findProviderById(String id) {
        return (Provider) providers.stream().filter(product -> product.getIdentification().equals(id));
    }

    /**
     * Busca un proveedor especifico y lo devuelve de encontrarlo
     * @param provider
     * @return Provider
     */
    public Provider findProvider(Provider provider) {
        return (Provider) providers.stream().filter(product1 -> product1.equals(provider));
    }

    /**
     * Actualizamos un proveedor existente con nuevos datos
     * @param provider
     * @return Provider
     */
    public Provider updateProvider(Provider provider){
        return provider;
    }

    /**
     * Creamos un nuevo proveedor si no existe y se actualiza si ya esta en nuestra lista
     * @param provider
     * @return Provider
     */
    public Provider createProvider(Provider provider){
        Provider providerFound = findProviderById(provider.getIdentification());
        if (providerFound != null) {
            return updateProvider(providerFound);
        }
        return addProvider(provider);
    }

    /**
     * Eliminamos un proveedor especifico
     * @param provider
     * @return boolean
     */
    public boolean removeProduct(Provider provider){
        return providers.remove(provider);
    }

    /**
     * Eliminamos un proveedor por medio de su id
     * @param serial
     * @return boolean
     */
    public boolean removeProviderById(String serial){
        Provider providerFound = findProviderById(serial);
        return providers.removeIf(product -> product.equals(providerFound));
    }

}
