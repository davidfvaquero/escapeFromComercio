module com.mycompany.escapefromcomercio {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.escapefromcomercio to javafx.fxml;
    exports com.mycompany.escapefromcomercio;
}
