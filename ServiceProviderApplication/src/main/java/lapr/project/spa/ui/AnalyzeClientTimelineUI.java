package lapr.project.spa.ui;

import lapr.project.spa.controller.AnalyzeClientTimelineController;


public class AnalyzeClientTimelineUI {
    private MainApp mainApp;
    private AnalyzeClientTimelineController controller;

    public AnalyzeClientTimelineUI(MainApp mainApp) {
        this.mainApp = mainApp;
        this.controller = new AnalyzeClientTimelineController();
    }
    
    public MainApp getMainApp(){
        return this.mainApp;
    }
    
    public AnalyzeClientTimelineController getController(){
        return this.controller;
    }
    
    public void toApplicationScene1(){
        try {
            AnalyzeClientTimelineUI1 analyzeClientTimelineUI1 = (AnalyzeClientTimelineUI1) this.mainApp.replaceSceneContent("/fxml/AnalyzeClientTimeline1.fxml");
            analyzeClientTimelineUI1.setAnalyzeClientTimelineUI(this);
            analyzeClientTimelineUI1.setupAnalyzeClientTimelineScene();
        } catch (Exception e) {
        }
    }
}
