package lapr2.spapplication.controller;

import model.Company;
import model.ImportType;
import model.ImportTypeRegistry;
import model.ServiceOrderImporter;
import model.ServiceOrderRegistry;


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
