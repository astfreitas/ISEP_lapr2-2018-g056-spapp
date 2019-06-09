package lapr.project.spa.model;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ImportType {

    private String importExtention;
    private String importClass;

    /**
     * Contructor initializes the importExtention and importClass values.
     *
     * @param importExtention extension of the file type.
     * @param importClass the class that will import that type of file.
     */
    public ImportType(String importExtention, String importClass) {
        this.importExtention = importExtention;
        this.importClass = importClass;
    }

    /**
     * Method returns an the extension associated with the import type.
     *
     * @return import extention.
     */
    public String getImportExtention() {
        return importExtention;
    }

    /**
     * Method creates an instance of ServiceOrderImporter using reflection.
     * @return instance type of  ServiceOrderImporter
     */
    public ServiceOrderImporter create() {
        try {
            Class<?> oClass = Class.forName(importClass);
            ServiceOrderImporter serv = null;
            try {
                serv = (ServiceOrderImporter) oClass.newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(ImportType.class.getName()).log(Level.SEVERE, null, ex);
            }
            return serv;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ImportType.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
