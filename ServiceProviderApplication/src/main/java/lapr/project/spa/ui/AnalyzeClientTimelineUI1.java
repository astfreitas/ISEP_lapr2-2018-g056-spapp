package lapr.project.spa.ui;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lapr.project.spa.model.ServiceOrder;
import lapr.project.spa.utils.UIUtils;
public class AnalyzeClientTimelineUI1 implements Initializable {

    private AnalyzeClientTimelineUI analyzeClientTimelineUI;
    
    @FXML
    private Button backToMainBtn;
    @FXML
    private ComboBox<String> clientComboBox;
    @FXML
    private TableView<ServiceOrder> clientTimelineTable;
    @FXML
    private TableColumn<ServiceOrder, String> colDayTime;
    @FXML
    private TableColumn<ServiceOrder, String> colService;
    @FXML
    private TableColumn<ServiceOrder, String> colCategory;
    @FXML
    private Button viewClientTimelineBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void handleClientTimelineBtn(ActionEvent event) {
        if(!clientComboBox.getSelectionModel().isEmpty()) {
            String email = clientComboBox.getSelectionModel().getSelectedItem();
            List<ServiceOrder> serviceOrders = this.analyzeClientTimelineUI.getController().checkClientTimeline(email);
            clientTimelineTable.getItems().clear();
            clientTimelineTable.getItems().addAll(serviceOrders);
        } else {
            UIUtils.createAlert("Please specify a client Email.", "Email empty", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleBackToMainBtn(ActionEvent event) {
        this.analyzeClientTimelineUI.getMainApp().toMainScene();
    }

    public void setAnalyzeClientTimelineUI(AnalyzeClientTimelineUI analyzeClientTimelineUI) {
        this.analyzeClientTimelineUI = analyzeClientTimelineUI;
    }
    
    public void setupAnalyzeClientTimelineScene() {
        colDayTime.setCellValueFactory(new PropertyValueFactory<>("propertyDayTime"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("propertyCategory"));
        colService.setCellValueFactory(new PropertyValueFactory<>("propertyService"));
        List<String> emailList = this.analyzeClientTimelineUI.getController().getClientEmailList();
        clientComboBox.getItems().clear();
        clientComboBox.getItems().addAll(emailList);
    }
    
}
