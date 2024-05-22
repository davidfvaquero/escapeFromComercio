package com.mycompany.escapefromcomercio;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PuertaController {

    private int contador = 0;

    @FXML
    private Button BtnAVBike;

    @FXML
    private Button BtnBack;

    @FXML
    private Button BtnClase;

    @FXML
    private Button BtnExit;

    @FXML
    private ImageView ImgPuerta;

    @FXML
    private Label Ltexto;

    @FXML
    void AVBike(ActionEvent event) throws IOException {
        contador++;
        if (contador == 1) {
            Image img = new Image("com/mycompany/escapefromcomercio/assets/AVBike.jpg");
            ImgPuerta.setImage(img);
            Ltexto.setText("mmmmm... Robable");
            BtnAVBike.setText("Robar");
        } else {
            App.setRoot("misionCumplida");
        }
    }

    @FXML
    void Exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void SwitchToClase(ActionEvent event) throws IOException {
        App.setRoot("clase");
    }

    @FXML
    void SwitchToInicio(ActionEvent event) throws IOException {
        App.setRoot("inicio");
    }

}
