package supermarket.model;

/**
 * Laboratorio: #2 - Profesor: LUIS YOVANY ROMO PORTILLA
 * Esta clase contiene toda la informacion y comportamientos necesarios para poder definir como estaran
 * estructurados nuestros empleaddos y cuales seran sus funciones dentro del negocio
 * @author Michael Stevens Cardenas Urbano | Cod.202123935
 * @author Steven Cardona Betancur | Cod.202126463
 */

public class Employee extends BusinessActor{
    private String name;
    private String lastName;

    public Employee( String identification, String name) {
        super(identification);
        this.name = name;
    }

    public Employee(String identification, String name, String lastName) {
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
