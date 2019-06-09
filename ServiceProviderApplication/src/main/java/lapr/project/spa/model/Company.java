package lapr.project.spa.model;

public class Company {
    
    private final String designation;
    private final String NIF;
    private final ImportTypeRegistry importTypeRegistry;
    private final ServiceOrderRegistry serviceOrderRegistry;
    
    /**
     * Constructor initializes company constructor and stores Company information
     * @param designation name of the company
     * @param NIF
     */
    public Company(String designation, String NIF) {
        this.designation = designation;
        this.NIF = NIF;
        this.importTypeRegistry = new ImportTypeRegistry();
        this.serviceOrderRegistry = new ServiceOrderRegistry();
    }

    @Override
    public String toString() {
        return "Company{" + "designation=" + designation + ", NIF=" + NIF + '}';
    }
    
    /**
     * Method retuns instance of ImportTypeRegistry, the location where the company handles import type file logic
     * @return instance of ImportTypeRegistry
     */
    public ImportTypeRegistry getImportTypeRegistry() {
        return importTypeRegistry;
    }
    
    
    /**
     * Method retuns instance of serviceOrderRegistry, the location where the company handles service order's logic
     * @return instance of ServiceOrderRegistry
     */
    public ServiceOrderRegistry getServiceOrderRegistry() {
        return serviceOrderRegistry;
    }

    
}
