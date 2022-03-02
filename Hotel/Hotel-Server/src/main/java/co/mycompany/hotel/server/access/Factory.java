package co.mycompany.hotel.server.access;

import co.mycompany.hotel.commons.infra.Utilities;

/**
 * Fabrica que se encarga de instanciar un repositorio concreto
 *
 * @author Kevin Morales
 */
public class Factory {

    private static Factory instance;

    private Factory() {
    }

    /**
     * Clase singleton
     *
     * @return
     */
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia
    IHotelRepository
     *
     * @return una clase hija de la abstracción IRepositorioClientes
     */
    public IHotelRepository getRepository() {
        String type = Utilities.loadProperty("hotel.repository");
        if (type.isEmpty()) {
            //type = "default";
            type = "mysql";
        }
        IHotelRepository result = null;

        switch (type) {
            case "default":
               // result = new HotelRepositoryImplArrays();
                break;
            case "mysql":
                result = new HotelRepositoryImplMysql();
                break;
        }
        return result;

    }
}
