package com.bnpparibas.training.javafx;
import java.time.LocalDate;
import java.time.Period;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class DatePickerDemo extends Application {
 
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        stage.setTitle("DatePicker Demo");
        VBox vbox = new VBox(20);
        vbox.setStyle("-fx-padding: 15;");
        Scene scene = new Scene(vbox, 550, 340);
        stage.setScene(scene);
        
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label label = new Label("Birthday:");
        gridPane.add(label, 0, 0);
        GridPane.setHalignment(label, HPos.LEFT);

        DatePicker birthdayPicker = new DatePicker();
        gridPane.add(birthdayPicker, 0, 1);
        
        Label error = new Label();
        gridPane.add(error, 1, 1);

        birthdayPicker.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                LocalDate selectedDate = birthdayPicker.getValue();
                System.out.println("Selected date: " + selectedDate);
                LocalDate today = LocalDate.now();
                if (Period.between(selectedDate, today).isNegative()) {
                    error.setText(
                            "Your birthday cannot be later than today");
                } else {
                    error.setText("");
                }
            }
        });

        vbox.getChildren().add(gridPane);
        stage.show();
    }
}