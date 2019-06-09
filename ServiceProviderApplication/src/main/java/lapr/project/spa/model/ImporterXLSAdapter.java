package lapr.project.spa.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;



public class ImporterXLSAdapter implements ServiceOrderImporter {

    private static int NUMBER_OF_PARAMS = 6;
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
                    Row row = rowIterator.next();
                    //validar se a row é valida
                    if(valid(row)) {
                        ServiceOrder importedOrder = new ServiceOrder(
                                dataFormatter.formatCellValue(row.getCell(0)),
                                dataFormatter.formatCellValue(row.getCell(1)),
                                dataFormatter.formatCellValue(row.getCell(2)),
                                dataFormatter.formatCellValue(row.getCell(3)),
                                dataFormatter.formatCellValue(row.getCell(4)),
                                dataFormatter.formatCellValue(row.getCell(5)));
                        importedServiceOrders.add(importedOrder);
                    }
                }
                return importedServiceOrders;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        
    }
    /**
     * Verifies if the length of the Array String is valid
     * @param row
     * @return true if valid
     */
    public boolean valid(Row row) {
        return row.getLastCellNum()==NUMBER_OF_PARAMS;
    }
    
    
    @Override
    public String toString() {
        return "XLS Adapter";
    }

}
