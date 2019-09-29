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

public class ImageDemoWithComposition extends Application {
	public static Image transform(Image in, UnaryOperator<Color> f) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
				out.getPixelWriter().setColor(x, y, f.apply(in.getPixelReader().getColor(x, y)));
		return out;
	}

	public static <T> UnaryOperator<T> compose(UnaryOperator<T> op1, UnaryOperator<T> op2) {
		return t -> op2.apply(op1.apply(t));
	}

	public void start(Stage stage) {
		Image image = new Image("eiffel-tower.jpg");

		Image imageResult1 = transform(image, compose(Color::brighter, Color::grayscale));

		// Ou Image newImage = transform(image, (UnaryOperator<Color>)
		// ((UnaryOperator<Color>) Color::brighter).compose(Color::grayscale));

		Image imageResult2 = transform(image, compose(Color::invert, compose(Color::brighter, Color::grayscale)));

		stage.setScene(
				new Scene(new HBox(new ImageView(image), new ImageView(imageResult1), new ImageView(imageResult2))));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
