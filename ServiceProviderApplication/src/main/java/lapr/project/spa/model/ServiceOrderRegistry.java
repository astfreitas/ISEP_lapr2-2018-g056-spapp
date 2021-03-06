package lapr.project.spa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ServiceOrderRegistry implements Serializable{

    private List<ServiceOrder> serviceOrders;

    public ServiceOrderRegistry() {
        this.serviceOrders = new ArrayList();
    }

    /**
     * Method Imports data from a file.
     * @param filePath
     * @param serviceOrderImporter 
     */
    public void importData(String filePath, ServiceOrderImporter serviceOrderImporter) {
        List<ServiceOrder> importedServiceOrders = serviceOrderImporter.importOrders(filePath);
        for (ServiceOrder serOrder : importedServiceOrders) {
            if (validate(serOrder)) {
                addServiceOrder(serOrder);
            }
        }
    }

    /**
     * Method will vefiry if the service order already exists in the Service
     * order list.
     * @param ServiceOrder
     * @return true if the service order was not added yet.
     */
    private boolean validate(ServiceOrder servOrder) {
        return !serviceOrders.contains(servOrder);
    }

    /**
     * Method that will add a service order to the container
     * @param serOrder 
     * @return true if the operation was a success.
     */
    private boolean addServiceOrder(ServiceOrder serOrder) {
        return this.serviceOrders.add(serOrder);
    }

    /**
     * Returns ServiceOrders List
     * @return ServiceOrder list
     */
    public List<ServiceOrder> getServiceOrders() {
        return this.serviceOrders;
    }
    
    /**
     * Returns ServiceOrder sorted by a given parameter
     * ToDo: Check design vs implementation - sort by List colletion?
     * @return ServiceOrder List
     */
    public List<ServiceOrder> getServiceOrdersByParameter(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    /**
     * Method obtains service orders of a given client by email
     * @param email
     * @return list of service orders
     */
    public List<ServiceOrder> getServiceOrdersByClientEmail(String email) {
        List<ServiceOrder> clientOders = new ArrayList();
        for(ServiceOrder serviceOrder : serviceOrders) {
            if(serviceOrder.hasEmail(email)) {
                clientOders.add(serviceOrder);
            }
        }
        return clientOders;
    }

    public List<String> getServiceOrdersClientEmails() {
        List<String> serviceOrdersCltEmails = new ArrayList();        
        for(ServiceOrder so : serviceOrders) {
            if(!serviceOrdersCltEmails.contains(so.getEmail())){
                serviceOrdersCltEmails.add(so.getEmail());
            }
        }
        return serviceOrdersCltEmails;
    }
    
    /**
     * Returns String description for the Service Order List
     * @return String description for the Service Order List
     */
    @Override
    public String toString() {
        return "ServiceOrderRegistry{" + "serviceOrders=" + serviceOrders + '}';
    }
    
    

}
