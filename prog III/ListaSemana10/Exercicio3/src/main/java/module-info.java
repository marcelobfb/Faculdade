module com.example.exercicio3 { // This is correct based on your folder/package name
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics; // Keep this one as it's needed for the Application class

    // COMBINED opens statement:
    opens com.example.exercicio3 to javafx.fxml, javafx.graphics; // <--- This is the crucial line

    exports com.example.exercicio3;
}