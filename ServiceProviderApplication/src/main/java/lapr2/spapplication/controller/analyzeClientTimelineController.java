package lapr2.spapplication.controller;

import java.util.List;
import lapr2.spapplication.model.Client;
import lapr2.spapplication.model.ServiceOrder;
import lapr2.spapplication.model.ServiceOrderRegistry;


public class analyzeClientTimelineController {
    
    
    
    public List<ServiceOrder> checkClientTimeline(String email) {
        
        ServiceOrderRegistry serviceOrderRegistry = ApplicationSP.getInstance().getCompany().getServiceOrderRegistry();
        
        return serviceOrderRegistry.getServiceOrdersByClientEmail(email);

    }
    
}
