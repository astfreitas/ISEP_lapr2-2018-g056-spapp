package lapr.project.spa.model;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ImporterCSVAdapter implements ServiceOrderImporter {
    
    private static int NUMBER_OF_PARAMS = 6;
    
    /**
     * Method Imports Orders from CSV file inspired from : https://www.callicoder.com/java-read-write-csv-file-opencsv/
     * @param filePath
     * @return List of ServiceOrders
     */
    @Override
    public List<ServiceOrder> importOrders(String filePath) {
        List<ServiceOrder> importedServiceOrders = new ArrayList();
        try (
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            CSVReader csvReader = new CSVReaderBuilder(reader).build();
        ) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                
                if(nextRecord.length==NUMBER_OF_PARAMS) {
                    ServiceOrder iServOrd = new ServiceOrder(nextRecord[0], nextRecord[1], nextRecord[2], nextRecord[3], nextRecord[4], nextRecord[5]); 
                    System.out.println(iServOrd);
                    importedServiceOrders.add(iServOrd);
                }
            }
            return importedServiceOrders;
        } catch (IOException ex) {
            Logger.getLogger(ImporterCSVAdapter.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    /**
     * Verifies if the length of the Array String is valid
     * @param row
     * @return true if valid
     */
    public boolean valid(String[] row) {
        return row.length==NUMBER_OF_PARAMS;
    }
    
    @Override
    public String toString() {
        return "CSV Adapter";
    }

    
    
    
}
