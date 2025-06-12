package com.example.exercicio3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simulador de Mensagens");

        TextField campoTexto = new TextField();
        campoTexto.setPromptText("Digite seu texto aqui...");
        campoTexto.setMaxWidth(300);

        Label labelExibicao = new Label("O texto digitado aparecerá aqui.");

        Button botaoExibir = new Button("Exibir Mensagem");

        botaoExibir.setOnAction(e -> {
            String textoDigitado = campoTexto.getText();
            if (textoDigitado != null && !textoDigitado.trim().isEmpty()) {
                labelExibicao.setText("Mensagem: " + textoDigitado);
            } else {
                labelExibicao.setText("Por favor, digite algo.");
            }
        });

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(campoTexto, botaoExibir, labelExibicao);

        Scene scene = new Scene(root, 400, 250);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}