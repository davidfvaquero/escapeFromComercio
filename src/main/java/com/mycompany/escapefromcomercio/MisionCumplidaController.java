/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
/**
 * FXML Controller class
 *
 * @author Diurno
 */
package com.mycompany.escapefromcomercio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MisionCumplidaController {

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
