package com.bnpparibas.training.javafx.fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Example1 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// Example1.fxml must be located in the same directory
		// as Example1.class
		Parent root = FXMLLoader.load(getClass().getResource("/example1.fxml"));
		root.setStyle("-fx-background-color: #6680e6;");
		Scene scene = new Scene(root, 740, 530);
		stage.setTitle("JavaFX with FXML (Example 1)");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}