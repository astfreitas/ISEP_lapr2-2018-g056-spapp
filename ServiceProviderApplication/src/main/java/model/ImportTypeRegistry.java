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

    public ImportType getImportTypeByFilePath(String filePath) {
        String extension = getExtensionFromFilePath(filePath);
        return getImportTypeByExtension(extension);
    }
    
    /**
     * Method obtains file extension from file Path
     * @param filePath
     * @return null if the file has no extension.
     */
    private String getExtensionFromFilePath(String filePath) {
        String[] fPathSections = filePath.split(".");
        if(fPathSections.length>1) {
            return fPathSections[fPathSections.length-1];
        }
        return null;
    }
    
    /**
     * Method gets an ImportType from a file extension
     * @param extension
     * @return instance of Import type.
     */
    private ImportType getImportTypeByExtension(String extension) {
        for(ImportType it : importTypes) {
            if(it.getImportExtention().equalsIgnoreCase(extension)) {
                return it;
            }
        }
        return null;
    }
    
}
