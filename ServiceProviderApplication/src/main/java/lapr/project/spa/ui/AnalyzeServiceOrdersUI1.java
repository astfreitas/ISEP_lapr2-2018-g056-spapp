/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.spa.ui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lapr.project.spa.model.ServiceOrder;
import lapr.project.spa.utils.UIUtils;

/**
 * FXML Controller class
 *
 * @author astfr
 */
public class AnalyzeServiceOrdersUI1 implements Initializable {

    private AnalyseServiceOrdersUI analyseServiceOrdersUI;

    @FXML
    private TableColumn<ServiceOrder, String> nameCollumn;
    @FXML
    private TableColumn<ServiceOrder, String> emailCollumn;
    @FXML
    private TableColumn<ServiceOrder, String> catCollumn;
    @FXML
    private TableColumn<ServiceOrder, String> serviceCollumn;
    @FXML
    private Button mainMenuBtn;
    @FXML
    private TableColumn<ServiceOrder, String> dateTimeCollumn;
    @FXML
    private TableView<ServiceOrder> servOrderTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    /**
     * Method loads the TableView content with the ServiceOrders List from the
     * AnalyzeServiceOrders Controller
     *
     */
    public void loadTableView() {
        try {
            List<ServiceOrder> servOrderList;
            servOrderList = this.analyseServiceOrdersUI.getController().getServiceOrders();
            servOrderTable.getItems().clear();
            servOrderTable.getItems().addAll(servOrderList);
//            return true;
        } catch (Exception e) {
            UIUtils.createAlert("No service orders available to show", "Load Service Orders", Alert.AlertType.INFORMATION);
//            return false;
        }
    }

    /**
     * Sets the instance to the Main UI Controller to this FXML controller
     *
     * @param analyseServiceOrdersUI instance to AnalyseServiceOrdersUI
     */
    public void setAnalyseServiceOrdersUI(AnalyseServiceOrdersUI analyseServiceOrdersUI) {
        this.analyseServiceOrdersUI = analyseServiceOrdersUI;
    }

    /**
     * Sets the atributs of the fxml scene TableView with the correct property
     * from the Service Order class. After executes the method to load the table
     * content.
     */
    public void setupAnalyseServiceOrderTable() {
        dateTimeCollumn.setCellValueFactory(new PropertyValueFactory<>("propertyDayTime"));
        nameCollumn.setCellValueFactory(new PropertyValueFactory<>("propertyName"));
        emailCollumn.setCellValueFactory(new PropertyValueFactory<>("propertyEmail"));
        catCollumn.setCellValueFactory(new PropertyValueFactory<>("propertyCategory"));
        serviceCollumn.setCellValueFactory(new PropertyValueFactory<>("propertyService"));
        loadTableView();
    }

    @FXML
    private void handlemainMenuBtn(ActionEvent event) {
        this.analyseServiceOrdersUI.getMainApp().toMainScene();
    }

}
