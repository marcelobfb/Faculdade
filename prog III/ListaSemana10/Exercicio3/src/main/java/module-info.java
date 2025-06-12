module com.example.exercicio3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.example.exercicio3 to javafx.fxml, javafx.graphics;

    exports com.example.exercicio3;
}