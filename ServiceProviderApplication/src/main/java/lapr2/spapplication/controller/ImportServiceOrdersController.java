package lapr2.spapplication.controller;

import lapr2.spapplication.model.Company;
import lapr2.spapplication.model.ImportType;
import lapr2.spapplication.model.ImportTypeRegistry;
import lapr2.spapplication.model.ServiceOrderImporter;
import lapr2.spapplication.model.ServiceOrderRegistry;


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
        
        ServiceOrderImporter serviceOrderImporter = importType.create();
        
        ServiceOrderRegistry serviceOrderRegistry = company.getServiceOrderRegistry();
        
        serviceOrderRegistry.importData(filePath, serviceOrderImporter);
        
        
    }
    
    
    
    
    
}
