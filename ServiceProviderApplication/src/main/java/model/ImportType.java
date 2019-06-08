package model;


public class ImportType {

    private String importExtention;
    private String importClass;

    /**
     * Contructor initializes the importExtention and importClass values.
     * @param importExtention extension of the file type.
     * @param importClass the class that will import that type of file.
     */
    public ImportType(String importExtention, String importClass) {
        this.importExtention = importExtention;
        this.importClass = importClass;
    }
    
    /**
     * Method returns an the extension associated with the import type.
     * @return import extention.
     */
    public String getImportExtention() {
        return importExtention;
    }

    public ServiceOrderImporter create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
