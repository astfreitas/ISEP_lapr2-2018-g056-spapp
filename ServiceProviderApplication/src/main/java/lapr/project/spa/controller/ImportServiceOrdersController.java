package lapr.project.spa.controller;

import lapr.project.spa.model.Company;
import lapr.project.spa.model.ImportType;
import lapr.project.spa.model.ImportTypeRegistry;
import lapr.project.spa.model.ServiceOrderImporter;
import lapr.project.spa.model.ServiceOrderRegistry;


public class ImportServiceOrdersController {
    
    /**
     * Method Imports service orders to the System.
     * @param filePath 
     */
    public void importOrders(String filePath) {
        
        ApplicationSP app = ApplicationSP.getInstance();
        
        Company company = ApplicationSP.getInstance().getCompany();
        
        ImportTypeRegistry importTypeRegistry = company.getImportTypeRegistry();
        
        ImportType importType = importTypeRegistry.getImportTypeByFilePath(filePath);
        
        if(importType!=null) {
            ServiceOrderImporter serviceOrderImporter = importType.create();
            ServiceOrderRegistry serviceOrderRegistry = company.getServiceOrderRegistry();
            serviceOrderRegistry.importData(filePath, serviceOrderImporter);
        } else {
             throw new IllegalArgumentException("Import type not Supported.");
        }
        
    }
    
    
    
    
    
}
