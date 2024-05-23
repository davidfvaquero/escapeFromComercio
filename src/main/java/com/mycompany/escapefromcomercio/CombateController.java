package com.mycompany.escapefromcomercio;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class CombateController {

    Random rnd = new Random();

    @FXML
    private Button BtnGoslingLook;

    @FXML
    private Button BtnHuir;

    @FXML
    private Button BtnPet;

    @FXML
    private Button BtnStick;

    @FXML
    private Label Linfo;

    @FXML
    private Label Lwin;

    @FXML
    private ProgressBar PBdog;

    @FXML
    private ProgressBar PBme;

    @FXML
    void GoslingLook(ActionEvent event) {
        PBdog.setProgress(PBdog.getProgress() - 0.4);
        if (PBdog.getProgress() <= 0) {
            try {
                Cgano();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    void Pet(ActionEvent event) {
        PBdog.setProgress(PBdog.getProgress() - 0.2);
        if (PBdog.getProgress() <= 0) {
            try {
                Cgano();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    void Throw(ActionEvent event) {
        PBdog.setProgress(PBdog.getProgress() - 0.3);
        if (PBdog.getProgress() <= 0) {
            try {
                Cgano();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Crashea muy fuerte no se que es
    @FXML
    void TryFlee(ActionEvent event) throws IOException {
        // Se queda comentado de momento

        int n = rnd.nextInt(10);
        if (n > 10) {
            Linfo.setText("Consigues huir!" + "\n\n" + "Buena suerte y veamos si llegas a clase a tiempo");
            App.setRoot("parque");
        } else {
            Linfo.setText("El perro es más " + "\n" + "rápido y no te permite escapar");
        }
    }

    void Cgano() throws IOException {
        Lwin.setVisible(true);
        App.setRoot("parque");
    }
}
