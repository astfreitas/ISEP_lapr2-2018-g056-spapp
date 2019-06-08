package lapr2.spapplication.model;

import java.util.List;

/**
 * Service Order Importer Interface
 */
public interface ServiceOrderImporter {
    public List<ServiceOrder> importOrders(String filePath);
}