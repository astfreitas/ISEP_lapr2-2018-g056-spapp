package lapr2.spapplication.controller;

import Utils.Constants;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import model.Company;


public class ApplicationSP {
    
    //instance of conpany
    private final Company company;
    
    public ApplicationSP() {
        Properties props = getProperties();
        company = new Company(props);
        bootstrap();
    }
    
    
    
    
    
    private void bootstrap(){
        
    }
    
    /**
     * Method returns the instance of the company
     * @return the instance of the company
     */
    public Company getCompany() {
        return company;
    }
    
    
    private Properties getProperties()
    {
        Properties props = new Properties();
        
        // Adiciona propriedades e valores por omissão
        props.setProperty(Constants.PARAMS_COMPANY_DESIGNATION, "Default Lda.");
        props.setProperty(Constants.PARAMS_COMPANY_NIF, "Default NIF");
        
        // Lê as propriedades e valores definidas 
        try
        {
            InputStream in = new FileInputStream(Constants.PARAMS_FILE);
            props.load(in);
            in.close();
        }
        catch(Exception ex)
        {
            
        }
        return props;
    }
    
    
    private static ApplicationSP singleton = null;
    /**
     * Method returns an instance of Service Provider Application
     * This instance is only intantiated once
     * Singleton Pattern
     * @return instance of ApplicationSP
     */
    public static ApplicationSP getInstance() 
    {
        if(singleton == null) 
        {
            synchronized(ApplicationSP.class) 
            { 
                singleton = new ApplicationSP();
            }
        }
        return singleton;
    }
    
}
