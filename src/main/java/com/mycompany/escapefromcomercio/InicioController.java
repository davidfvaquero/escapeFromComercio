package com.mycompany.escapefromcomercio;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class InicioController {
    
    @FXML
    private Button BtnCafe;
    
    @FXML
    private Button BtnExit;
    
    @FXML
    private Button BtnParque;
    
    @FXML
    private Button BtnPuerta;
    
    @FXML
    void Exit(ActionEvent event) {
        System.exit(0);
    }
    
    @FXML
    void SwitchToCafe(ActionEvent event) throws IOException {
        App.setRoot("cafe");
    }
    
    @FXML
    void SwitchToParque(ActionEvent event) throws IOException {
        App.setRoot("parque");
    }
    
    @FXML
    void SwtichToPuerta(ActionEvent event) throws IOException {
        App.setRoot("puerta");
    }
    
}
