package model;

import java.util.ArrayList;
import java.util.List;


public class ServiceOrderRegistry {
    
    private List<ServiceOrder> serviceOrders;

    public ServiceOrderRegistry() {
        this.serviceOrders = new ArrayList();
    }

    public void importData(String filePath, ServiceOrderImporter serviceOrderImporter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
            
}
