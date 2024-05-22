/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.escapefromcomercio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ParqueRiberaController {

    @FXML
    private Button BtnReplay;

    @FXML
    void SwitchToPrimary(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }

    @FXML
    public void initialize() {
        escribirFichero("cuentas.txt");
    }

    /**
     * Metodo que escribe un 0 en un fichero. Se usa para renovar el dinero que
     * se tiene al volver a la pantalla de titulo
     *
     * @param name String con el nombre del fichero
     */
    void escribirFichero(String name
    ) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(name, false));
            bw.write(String.valueOf(0));
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
