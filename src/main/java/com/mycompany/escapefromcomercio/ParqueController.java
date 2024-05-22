package com.mycompany.escapefromcomercio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ParqueController {

    private int dinero;

    @FXML
    private Button BtnBack;

    @FXML
    private Button BtnExit;

    @FXML
    private Button BtnPaseo;

    @FXML
    private Label Ldinero;

    @FXML
    private Label Lrf;

    @FXML
    private ImageView imageRF;

    @FXML
    private Button BtnSearch;

    @FXML
    void Exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void initialize() {
        leerFichero();

        Ldinero.setText("Dinero: " + String.valueOf(dinero));
    }

    @FXML
    void Search(ActionEvent event) {
        Random rnd = new Random();

        leerFichero();

        int numAleatorio = rnd.nextInt(100);

        if (numAleatorio < 70) {
            Lrf.setText("No encuentras nada");
        } else {
            Lrf.setText("Encuentras una moneda de euro");
            dinero++;
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("cuentas.txt", false));
            bw.write(String.valueOf(dinero));
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Ldinero.setText("Dinero: " + String.valueOf(dinero));
    }

    @FXML
    void SwitchToPR(ActionEvent event) throws IOException {
        App.setRoot("parqueRibera");
    }

    @FXML
    void SwitchToinicio(ActionEvent event) throws IOException {
        App.setRoot("inicio");
    }

    /**
     * Metodo que lee un numero de un fichero
     */
    private void leerFichero() {
        String linea;

        try {
            FileReader fr = new FileReader("cuentas.txt");
            BufferedReader br = new BufferedReader(fr);

            linea = br.readLine();

            if (linea != null) {
                this.dinero = Integer.parseInt(linea);
            } else {
                this.dinero = 0;
            }
        } catch (IOException e) {
            System.out.println("No se puede leer el archivos");
        }
    }
}
