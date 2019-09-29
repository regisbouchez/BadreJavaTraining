package com.bnpparibas.training.javafx;

import javafx.application.Application; 
import javafx.collections.ObservableList; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.scene.Node; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.layout.VBox; 
import javafx.scene.paint.Color; 
import javafx.scene.shape.Rectangle; 
import javafx.stage.Stage; 

public class RotateDemo extends Application { 

    @Override 
    public void start(Stage stage) { 
        VBox root = new VBox(40); 
        ObservableList<Node> children = root.getChildren(); 
        final Rectangle rect = new Rectangle(80, 50); 
        rect.setFill(Color.AQUAMARINE); 
        children.add(rect); 

        Button button = new Button("Rotate");
        button.setOnAction((event) -> rect.setRotate(rect.getRotate()+10));
//        button.setOnAction(new EventHandler<ActionEvent>() { 
//            @Override 
//            public void handle(ActionEvent event) { 
//                rect.setRotate(rect.getRotate() + 10); 
//            } 
//        }); 
        children.add(button); 

        Scene scene = new Scene(root, 120, 130); 
        scene.setFill(Color.BEIGE); 
         
        stage.setTitle("Rotate Demo"); 
        stage.setScene(scene); 
        stage.show(); 
    } 

    public static void main(String[] args) { 
        launch(args); 
    } 
}