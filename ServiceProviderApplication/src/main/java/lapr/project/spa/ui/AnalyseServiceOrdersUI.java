package lapr.project.spa.ui;

import lapr.project.spa.controller.AnalyseServiceOrdersController;

/**
 *
 * @author astfr
 */
public class AnalyseServiceOrdersUI {
    
    private MainApp mainApp;
    private AnalyseServiceOrdersController controller;

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
            analyzeServiceOrdersUI1.setupAnalyseServiceOrderTable();
            
        } catch (Exception e) {
        }
    }
    
    
    
}
