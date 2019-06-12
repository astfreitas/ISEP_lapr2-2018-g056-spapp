/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.spa.ui;

import lapr.project.spa.controller.AnalyseServiceOrdersController;

/**
 *
 * @author astfr
 */
public class AnalyseServiceOrdersUI {
    
    private MainApp mainApp;
    private AnalyseServiceOrdersController controller;

    public AnalyseServiceOrdersUI() {
    }

    public AnalyseServiceOrdersUI(MainApp mainApp) {
        this.mainApp = mainApp;
        this.controller = new AnalyseServiceOrdersController();
    }
    
    public MainApp getMainApp(){
        return this.mainApp;
    }
    
    public AnalyseServiceOrdersController getController(){
        return this.controller;
    }
    
    public void toApplicationScene1(){
        try {
            AnalyzeServiceOrdersUI1 analyzeServiceOrdersUI1 = (AnalyzeServiceOrdersUI1) this.mainApp.replaceSceneContent("/fxml/AnalyzeServiceOrders.fxml");
            analyzeServiceOrdersUI1.setAnalyseServiceOrdersUI(this);
        } catch (Exception e) {
        }
    }
    
    
    
}
