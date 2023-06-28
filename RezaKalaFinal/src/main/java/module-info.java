module com.example.rezakalafinal {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.xml;
    requires java.sql;
    requires java.desktop;

    opens com.example.rezakalafinal to javafx.fxml;
    exports com.example.rezakalafinal;
}