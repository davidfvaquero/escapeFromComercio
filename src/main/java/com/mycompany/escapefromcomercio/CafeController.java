package com.mycompany.escapefromcomercio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CafeController {

    int cash;

    @FXML
    private Button BtnBack;

    @FXML
    private Button BtnCafe;

    @FXML
    private Button BtnExit;

    @FXML
    private ImageView ImgBar;

    @FXML
    private Label Lcash;

    @FXML
    public void initialize() {
        try {
            FileReader fr = new FileReader("cuentas.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            if (linea != null) {
                this.cash = Integer.parseInt(linea);
            } else {
                this.cash = 0;
            }
            br.close();

            refresh();

        } catch (IOException e) {
            System.out.println("No se puede leer el archivos");
        }
    }

    @FXML
    void Cafe(ActionEvent event
    ) {
        cash--;
        if (cash <= -1) {
            return;
        }
        Lcash.setText("Dinero: " + cash);
        escribirFichero("cuentas.txt");
        refresh();
    }

    @FXML
    void Exit(ActionEvent event
    ) {
        System.exit(0);

    }

    @FXML
    void SwitchToInicio(ActionEvent event) throws IOException {
        App.setRoot("inicio");
    }

    /**
     * Metodo para comprobar qué imagen hay que mostrar y la disponibilidad del
     * botón "BtnCafe". Si se tiene dinero (cash > 0) el botón está activado,
     * sino se desactiva
     */
    private void refresh() {
        Image imgBroke = new Image("com/mycompany/escapefromcomercio/cartera.jpg");
        Image imgCash = new Image("com/mycompany/escapefromcomercio/manhattan.jpg");

        Lcash.setText("Dinero: " + cash);
        if (cash == 0) {
            BtnCafe.setDisable(true);
            ImgBar.setImage(imgBroke);
        } else {
            BtnCafe.setDisable(false);
            ImgBar.setImage(imgCash);
        }
    }

    /**
     * Metodo que lee un numero de un fichero
     *
     * @param name String con el nombre del fichero
     * @return int con la cifra que hay en el fichero
     */
    int leerFichero(String name
    ) {
        try {
            FileReader fr = new FileReader(name);
            BufferedReader br = new BufferedReader(fr);
            cash = Integer.parseInt(br.readLine());
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return cash;
    }

    /**
     * Metodo que escribe en un fichero
     *
     * @param name String con el nombre del fichero
     */
    void escribirFichero(String name
    ) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(name, false));
            bw.write(String.valueOf(cash));
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
