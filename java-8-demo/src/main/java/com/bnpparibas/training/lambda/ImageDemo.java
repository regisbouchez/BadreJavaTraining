package com.bnpparibas.training.lambda;

import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ImageDemo extends Application {

	public static Image transform(Image in, UnaryOperator<Color> f) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
				out.getPixelWriter().setColor(x, y, f.apply(in.getPixelReader().getColor(x, y)));
		return out;
	}

	// UnaryOperator appartient � package java.util.function
	// => Utiliser les fonctions existantes si possible
	public static UnaryOperator<Color> brighten(double factor) {
		return c -> c.deriveColor(0, 1, factor, 1);
	}

	public void start(Stage stage) {
		Image image = new Image("eiffel-tower.jpg");
		Image brightenedImage1 = transform(image, Color::brighter);
		Image brightenedImage2 = transform(image, brighten(1.7));

		stage.setScene(new Scene(
				new HBox(new ImageView(image), new ImageView(brightenedImage1), new ImageView(brightenedImage2))));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
