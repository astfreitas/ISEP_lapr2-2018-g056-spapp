package lapr.project.spa.model;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvBindByPosition;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.spa.utils.Constants;


public class ImporterCSVAdapter implements ServiceOrderImporter {
    
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
            csvReader.readNext();
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                if(valid(nextRecord)) {
                    ServiceOrder iServOrd = new ServiceOrder(nextRecord[Constants.IMPORT_NAME], 
                            nextRecord[Constants.IMPORT_EMAIL], 
                            nextRecord[Constants.IMPORT_SCHEDULE_PREFERENCE_DAY], 
                            nextRecord[Constants.IMPORT_SCHEDULE_PREFERENCE_TIME], 
                            nextRecord[Constants.IMPORT_CATEGORY], 
                            nextRecord[Constants.IMPORT_SERVICE]); 
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
        return row.length==Constants.NR_IMPORT_ATTRIBUTES;
    }
    
    @Override
    public String toString() {
        return "CSV Adapter";
    }

    
}
