package lapr2.spapplication.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class ImportXLS {
    
    //Exporter
    /*
    public static void export(String filename, String[] line, int rowNumber) {
        File file = new File(filename);
        if (!file.exists()) {
            try {
                Workbook workbook = new HSSFWorkbook();
                Sheet sheet = workbook.createSheet("Sheet");
                FileOutputStream fileOut = new FileOutputStream(filename);
                workbook.write(fileOut);
                fileOut.close();
            } catch (Exception e) {
            }
        }
        try {
            FileInputStream fileIn = new FileInputStream(new File(filename));
            Workbook workbook = new HSSFWorkbook(fileIn);
            Sheet worksheet = workbook.getSheetAt(0);
            Row row = worksheet.createRow(rowNumber);
            Cell cell = null;
            for (int i = 0; i < line.length; i++) {
                cell = row.createCell(i);
                cell.setCellValue(line[i]);
            }
            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
        } catch (Exception ex) {
        }
    }
    */
    
}
