package com.mycompany.escapefromcomercio;

import java.io.IOException;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    private ImageView ImgPerro;

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
        perro();
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
        perro();
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
        perro();
    }

    @FXML
    void TryFlee(ActionEvent event) throws IOException {

        int n = rnd.nextInt(100);
        if (n > 59) {
            Linfo.setText("Consigues huir!" + "\n\n" + "Buena suerte y veamos si llegas a clase a tiempo");
            Cgano();
        } else {
            Linfo.setText("El perro es más " + "\n" + "rápido y no te permite escapar");
        }
        perro();
    }

    void Cgano() throws IOException {
        Lwin.setVisible(true);
        App.setRoot("parque");
    }

    void perro() {
        int ataquePerro = rnd.nextInt(100);
        if (ataquePerro <= 40) {
            Linfo.setText("El perro " + "\n" + "te mira intimidante");
            PBme.setProgress(PBme.getProgress() - 0.1);
        } else if (ataquePerro > 40 && ataquePerro <= 70) {
            Linfo.setText("El perro te ladra");
            PBme.setProgress(PBme.getProgress() - 0.1875);
        } else {
            Linfo.setText("El perro" + "\n" + " te mea la zapatilla");
            PBme.setProgress(PBme.getProgress() - 0.25);
        }
        if (PBdog.getProgress() <= 0.25) {
            Image img = new Image("com/mycompany/escapefromcomercio/assets/bigPerro.jpg");
            ImgPerro.setImage(img);
            Linfo.setText("El perro" + "\n" + "muestra su" + "\n" + "verdadera forma");
        }
    }
}
