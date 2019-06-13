package lapr.project.spa.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lapr.project.spa.utils.Constants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ImporterXLSAdapter implements ServiceOrderImporter {
    
    /**
     * Method Imports Orders from XLS file inspired from : https://www.callicoder.com/java-read-excel-file-apache-poi/
     * @param filePath
     * @return List of ServiceOrders
     */
    @Override
    public List<ServiceOrder> importOrders(String filePath) {
        try {
            FileInputStream fileIn = new FileInputStream(new File(filePath));
            try (Workbook workbook = new HSSFWorkbook(fileIn)) {
                List<ServiceOrder> importedServiceOrders = new ArrayList();
                Sheet sheet = (Sheet) workbook.getSheetAt(0);
                DataFormatter dataFormatter = new DataFormatter();
                Iterator<Row> rowIterator = sheet.rowIterator();
                while (rowIterator.hasNext()) {
                    rowIterator.next();
                    Row row = rowIterator.next();
                    if(valid(row)) {
                        ServiceOrder importedOrder = new ServiceOrder(
                                dataFormatter.formatCellValue(row.getCell(Constants.IMPORT_NAME)),
                                dataFormatter.formatCellValue(row.getCell(Constants.IMPORT_EMAIL)),
                                dataFormatter.formatCellValue(row.getCell(Constants.IMPORT_SCHEDULE_PREFERENCE_DAY)),
                                dataFormatter.formatCellValue(row.getCell(Constants.IMPORT_SCHEDULE_PREFERENCE_TIME)),
                                dataFormatter.formatCellValue(row.getCell(Constants.IMPORT_CATEGORY)),
                                dataFormatter.formatCellValue(row.getCell(Constants.IMPORT_SERVICE)));
                        importedServiceOrders.add(importedOrder);
                    }
                }
                return importedServiceOrders;
            }
        } catch (IOException ex) {
            return null;
        }
        
    }
    /**
     * Verifies if the length of the Array String is valid
     * @param row
     * @return true if valid
     */
    public boolean valid(Row row) {
        return row.getLastCellNum()==Constants.NR_IMPORT_ATTRIBUTES;
    }
    
    
    @Override
    public String toString() {
        return "XLS Adapter";
    }

}
