/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.spa.ui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import lapr.project.spa.controller.ImportServiceOrdersController;

/**
 * FXML Controller class
 *
 * @author astfr
 */
public class ImportServiceOrdersUI1 implements Initializable {

    private ImportServiceOrdersUI importServiceOrdersUI;

    @FXML
    private Button mainMenuBtn;
    @FXML
    private TextField filePathText;
    @FXML
    private Button browseBtn;
    @FXML
    private Button importBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setImportServiceOrdersUI(ImportServiceOrdersUI importServiceOrdersUI) {
        this.importServiceOrdersUI = importServiceOrdersUI;
    }

    @FXML
    private void handleMainMenuBtn(ActionEvent event) {
        this.importServiceOrdersUI.getMainApp().toMainScene();
    }

    @FXML
    private void handleBrowseBtn(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Browse for service orders file to import");
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {

            filePathText.setText(selectedFile.getName());
        } else {
            filePathText.setText("No file was selected.");
        }

    }

    @FXML
    private void handleImportBtn(ActionEvent event) {
    }

}
