/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.spa.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.spa.model.Company;
import lapr.project.spa.model.ServiceOrder;
import lapr.project.spa.model.ServiceOrderRegistry;

/**
 *
 * @author astfr
 */
public class AnalyseServiceOrdersController {
    
    private Company company;
    
    private List<ServiceOrder> servOrdersList = new ArrayList();
    
    public AnalyseServiceOrdersController(){
        //ToDo: Check authentication? vs check SP logged
        // this.company ToDo: need to check how to obtain company
    }
    
    public List<ServiceOrder> getServiceOrders(){
        ServiceOrderRegistry servOrdersReg = company.getServiceOrderRegistry();
        return servOrdersReg.getServiceOrders();
    }
    
}
