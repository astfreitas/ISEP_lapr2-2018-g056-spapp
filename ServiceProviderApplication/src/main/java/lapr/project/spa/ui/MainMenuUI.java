/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.spa.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

/**
 *
 * @author astfr
 */
public class MainMenuUI {
    private MainApp mainApp;
    
    @FXML
    private MenuItem importServOrdersBtn;
    @FXML
    private MenuItem analyzeServiceOrdersBtn;
    @FXML
    private MenuItem analyzeCliTimeLineBtn;
    @FXML
    private MenuItem aboutBtn;

    @FXML
    private void handleImportServOrdersBtn(ActionEvent event) {
    }

    @FXML
    private void handleAnalyzeServiceOrders(ActionEvent event) {
        AnalyseServiceOrdersUI analyseServiceOrdersUI = new AnalyseServiceOrdersUI(this.mainApp);
        analyseServiceOrdersUI.toApplicationScene1();
    }

    @FXML
    private void handleAnalyzeCliTimeLineBtn(ActionEvent event) {
    }

    @FXML
    private void handleAboutBtn(ActionEvent event) {
    }
    
    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
    }
    
}
