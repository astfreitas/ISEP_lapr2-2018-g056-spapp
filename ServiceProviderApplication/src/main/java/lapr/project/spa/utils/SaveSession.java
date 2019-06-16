/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.spa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.scene.control.Alert;
import lapr.project.spa.model.Company;
import lapr.project.spa.model.ServiceOrderRegistry;

/**
 *
 * @author astfr
 */
public class SaveSession {

    /**
     * Saves all service orders in binary file to ensure the presence of data
     *
     *
     * @param company instance of the company to obtain all needed registy
     * classes and data
     */
    public static void saveServiceOrdersBinary(Company company) {
        try {
            File file = new File(Constants.PARAMS_FILE_STATE);
            file.delete();
            ServiceOrderRegistry servOrderReg = company.getServiceOrderRegistry();
            FileOutputStream ficheiroBinario = null;
            ficheiroBinario = new FileOutputStream(Constants.PARAMS_FILE_STATE);
            ObjectOutputStream out = new ObjectOutputStream(ficheiroBinario);
            out.writeObject(servOrderReg);
            ficheiroBinario.close();
            UIUtils.createAlert("Service Orders were saved successfully", "Session saved successfully", Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            e.getCause();
            System.out.println(e.getStackTrace());
            UIUtils.createAlert("An unexpected error occurred trying to save the present session, No service order were saved",
                    "Error saving session ", Alert.AlertType.ERROR);
        }
    }

    /**
     * Imports all service orders from abinary file if available.
     *
     * @param company instance of the company to set all needed registy classes
     * and data
     */
    public static void importServiceOrdersBinary(Company company) {
        try {
            FileInputStream binaryFile = null;
            binaryFile = new FileInputStream(Constants.PARAMS_FILE_STATE);
            ObjectInputStream in = new ObjectInputStream(binaryFile);
            ServiceOrderRegistry servOrderReg
                    = (ServiceOrderRegistry) in.readObject();
            company.setServiceOrderRegistry(servOrderReg);
            binaryFile.close();
        } catch (Exception e) {
            UIUtils.createAlert("No previous session to import or file missing", "Import previous session error", Alert.AlertType.WARNING);
        }
    }

}
