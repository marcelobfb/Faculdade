module com.example.ex3 { // This is your module name, based on your project structure
    requires javafx.controls; // Essential for Button, Label, TextField, VBox, Scene
    requires javafx.fxml;     // Include this if you were using FXML (even if not for this specific exercise, it's often present in default JavaFX projects)

    // If you were using FXML, you'd also need:
    // opens com.example.ex3 to javafx.fxml;

    // And your main application package needs to be opened to javafx.graphics
    // so that the Application class can be launched.
    opens com.example.ex3 to javafx.graphics; // Crucial for launching the application

    exports com.example.ex3; // Exports your package
}