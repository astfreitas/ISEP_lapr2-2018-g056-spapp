package lapr.project.spa.ui;

import java.beans.EventHandler;
import java.io.InputStream;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lapr.project.spa.controller.ApplicationSP;
import lapr.project.spa.utils.SaveSession;


public class MainApp extends Application {
    
    private final double MINIMUM_WINDOW_WIDTH = 600.0;
    private final double MINIMUM_WINDOW_HEIGHT = 400.0;
    private final double SCENE_WIDTH = 600;
    private final double SCENE_HEIGHT = 400;
    private Stage stage;
    
    
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        this.stage.setTitle("Service Provider App");
        this.stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
        this.stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
        toMainScene();
        ApplicationSP app= ApplicationSP.getInstance();
        
        this.stage.setOnCloseRequest(new javafx.event.EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

                    alert.setTitle("ApplicationGPSD");
                    alert.setHeaderText("Confirmation");
                    alert.setContentText("Are you sure you want to exit?");

                    if (alert.showAndWait().get() == ButtonType.CANCEL) {
                        event.consume();
                    } else {
                        SaveSession.saveServiceOrdersBinary(app.getCompany());
                    }
                }
            });
        this.stage.show();     
        SaveSession.importServiceOrdersBinary(app.getCompany());  
    }
    
    /**
     * Returns the stage for the fxml 
     * @return stage
     */
    public Stage getStage(){
        return this.stage;
    }
    
    /**
     * Replaces the scene content with the given fxml file path
     * @param fxml fxml file path
     * @return initalizable 
     * @throws Exception throws an exception
     */
    public Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = MainApp.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(MainApp.class.getResource(fxml));
        Pane page;
        try {
            page = (Pane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, SCENE_WIDTH, SCENE_HEIGHT);
        this.stage.setScene(scene);
        this.stage.sizeToScene();
        return (Initializable) loader.getController();
    }
    
    /**
     * Sets the scene back to the main Menu for SP
     */
    public void toMainScene(){
        try {
            MainMenuUI mainMenuUI = (MainMenuUI) replaceSceneContent("/fxml/MainMenuSP.fxml");
            mainMenuUI.setMainApp(this);
        } catch (Exception e) {
        }
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
