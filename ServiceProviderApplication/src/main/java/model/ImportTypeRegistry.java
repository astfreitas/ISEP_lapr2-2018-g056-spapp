package model;

import java.util.ArrayList;
import java.util.List;


public class ImportTypeRegistry {
    
    private List<ImportType> importTypes;
    /**
     * Constructor initiates the container
     */
    public ImportTypeRegistry() {
        importTypes = new ArrayList();
    }

    /**
     * Method registers the Import type
     * @param importTypeAdaptorExtension extension of the file
     * @param importTypeAdaptorClass the full path to the class
     * @return true is the import type was registered with success.
     */
    public boolean registerImportType(String importTypeAdaptorExtension, String importTypeAdaptorClass) {
        ImportType importType = new ImportType(importTypeAdaptorExtension, importTypeAdaptorClass);
        if(validate(importType)) {
            return addImportType(importType);
        }
        return false;
    }
    
    /**
     * Method validates if the import type exists in the container
     * @param importType
     * @return true if the Import Type it was not added yet.
     */
    private boolean validate(ImportType importType) {
        return !importTypes.contains(importType);
    }
    
    /**
     * Method appends an import type to the container
     * @param importType
     * @return true if the operation was successful
     */
    private boolean addImportType(ImportType importType) {
        return importTypes.add(importType);
    }
    
}
