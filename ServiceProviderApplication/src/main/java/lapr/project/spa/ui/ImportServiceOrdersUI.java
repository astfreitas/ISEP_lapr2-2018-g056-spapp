/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.spa.ui;

import lapr.project.spa.controller.ImportServiceOrdersController;

/**
 *
 * @author astfr
 */
public class ImportServiceOrdersUI {
    
    private MainApp mainApp;
    private ImportServiceOrdersController controller;

    public ImportServiceOrdersUI(MainApp mainApp) {
        this.mainApp = mainApp;
        this.controller = new ImportServiceOrdersController();
    }
    
    public MainApp getMainApp(){
        return this.mainApp;
    }
    
    public ImportServiceOrdersController getController(){
        return this.controller;
    }
    
    public void toApplicationScene1(){
        try {
            ImportServiceOrdersUI1 importServiceOrdersUI1 = (ImportServiceOrdersUI1) this.mainApp.replaceSceneContent("/fxml/ImportServiceOrders.fxml");
            
        } catch (Exception e) {
        }
    }
    
}
