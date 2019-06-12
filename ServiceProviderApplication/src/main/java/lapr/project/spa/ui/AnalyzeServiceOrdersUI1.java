/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.spa.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
 *
 * @author astfr
 */
public class AnalyzeServiceOrdersUI1 implements Initializable {

    private AnalyseServiceOrdersUI analyseServiceOrdersUI;
    
    @FXML
    private TableColumn<?, ?> nameCollumn;
    @FXML
    private TableColumn<?, ?> emailCollumn;
    @FXML
    private TableColumn<?, ?> catCollumn;
    @FXML
    private TableColumn<?, ?> serviceCollumn;
    @FXML
    private Button mainMenuBtn;
    @FXML
    private TableColumn<?, ?> dateTimeCollumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setAnalyseServiceOrdersUI(AnalyseServiceOrdersUI analyseServiceOrdersUI) {
        this.analyseServiceOrdersUI = analyseServiceOrdersUI;
    }

    @FXML
    private void handlemainMenuBtn(ActionEvent event) {
        this.analyseServiceOrdersUI.getMainApp().toMainScene();
    }
    
    
    
}
