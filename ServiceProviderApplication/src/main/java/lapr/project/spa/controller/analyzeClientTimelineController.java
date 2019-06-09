package lapr.project.spa.controller;

import java.util.List;
import lapr.project.spa.model.ServiceOrder;
import lapr.project.spa.model.ServiceOrderRegistry;


public class analyzeClientTimelineController {
    
    
    
    public List<ServiceOrder> checkClientTimeline(String email) {
        
        ServiceOrderRegistry serviceOrderRegistry = ApplicationSP.getInstance().getCompany().getServiceOrderRegistry();
        
        return serviceOrderRegistry.getServiceOrdersByClientEmail(email);

    }
    
}
