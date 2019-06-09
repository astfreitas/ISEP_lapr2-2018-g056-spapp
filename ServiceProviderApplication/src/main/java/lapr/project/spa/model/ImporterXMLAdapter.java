package lapr.project.spa.model;

import java.util.List;


public class ImporterXMLAdapter implements ServiceOrderImporter {

    @Override
    public List<ServiceOrder> importOrders(String filePath) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString() {
        return "XML Adapter";
    }
    
}
