package lapr.project.spa.controller;

import lapr.project.spa.utils.Constants;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import lapr.project.spa.model.Company;

public class ApplicationSP {

    private final Company company;

    public ApplicationSP() {
        Properties props = getProperties();
        company = new Company(props.getProperty(Constants.PARAMS_COMPANY_DESIGNATION), props.getProperty(Constants.PARAMS_COMPANY_NIF));
        bootstrap(props);
    }

    /**
     * Method that initiates the application
     *
     * @param props
     */
    private void bootstrap(Properties props) {
        int inportsTypeQuantity = Integer.parseInt(props.getProperty(Constants.PARAMS_NUMBER_OF_IMPORT_TYPES));
        
        for (int i = 0; i < inportsTypeQuantity; i++) {
            
            String importTypeAdaptorExtension = props.getProperty(Constants.PARAMS_COMPANY_IMPORT_TYPE + "." + i + "." + Constants.PARAMS_EXTENSION);
            String importTypeAdaptorClass = props.getProperty(Constants.PARAMS_COMPANY_IMPORT_TYPE + "." + i + "." + Constants.PARAMS_CLASS);
            if (company.getImportTypeRegistry().registerImportType(importTypeAdaptorExtension, importTypeAdaptorClass)) {
                System.out.println("import type : " + importTypeAdaptorClass + " created with success.");
            }
        }
        
    }

    /**
     * Method returns the instance of the company
     *
     * @return the instance of the company
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Method returns properties of the configuration file
     *
     * @return properties of the configuration file
     */
    private Properties getProperties() {
        Properties props = new Properties();

        // Adiciona propriedades e valores por omissão
        props.setProperty(Constants.PARAMS_COMPANY_DESIGNATION, "Default Lda.");
        props.setProperty(Constants.PARAMS_COMPANY_NIF, "Default NIF");

        // reads properties and values from the config file
//        try {
//            InputStream in = new FileInputStream(Constants.PARAMS_FILE);
//            props.load(in);
//            in.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
        // Read the file
        try {
            try (InputStream in = this.getClass().getClassLoader().getResourceAsStream(Constants.PARAMS_FILE)) {
                props.load(in);
            }
        } catch (IOException ex) {
        }
        
        return props;
    }

    private static ApplicationSP singleton = null;

    /**
     * Method returns an instance of Service Provider Application Singleton Pattern
     * @return instance of ApplicationSP
     */
    public static ApplicationSP getInstance() {
        if (singleton == null) {
            synchronized (ApplicationSP.class) {
                singleton = new ApplicationSP();
            }
        }
        return singleton;
    }

}
