package lapr2.spapplication.model;

import java.util.ArrayList;
import java.util.List;

public class ServiceOrderRegistry {

    private List<ServiceOrder> serviceOrders;

    public ServiceOrderRegistry() {
        this.serviceOrders = new ArrayList();
    }

    /**
     * 
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
        return serviceOrders.add(serOrder);
    }

}
