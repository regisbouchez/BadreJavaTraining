package com.bnpparibas.training.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CSSDemo extends Application {

	@Override
	public void start(Stage stage) {
		BorderPane root = new BorderPane();

		root.setCenter(new Label("Welcome"));

		HBox hBox = new HBox();
		hBox.getStyleClass().add("hbox");

		Button backButton = new Button("Back");
		hBox.getChildren().add(backButton);
		Button nextButton = new Button("Next");
		nextButton.setId("nextBtn");
		hBox.getChildren().add(nextButton);
		root.setBottom(hBox);

		Scene scene = new Scene(root, 400, 300);
		scene.getStylesheets().add("style.css");

		stage.setTitle("CSS Demo");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}