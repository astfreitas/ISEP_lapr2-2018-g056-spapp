package model;

import java.util.Properties;


public class Company {
    
    private String designation;
    private String NIF;
    private ImportTypeRegistry importTypeRegistry;
    
    /**
     * Constructor initializes company constructor and stores Company information
     * @param designation name of the company
     * @param nif
     */
    public Company(String designation, String NIF) {
        this.designation = designation;
        this.NIF = NIF;
        this.importTypeRegistry = new ImportTypeRegistry();
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
    
}
