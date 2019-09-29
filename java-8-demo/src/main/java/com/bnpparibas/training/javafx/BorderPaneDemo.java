package com.bnpparibas.training.javafx;
import javafx.application.Application; 
import javafx.geometry.Insets; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.control.ColorPicker; 
import javafx.scene.control.Label; 
import javafx.scene.image.ImageView; 
import javafx.scene.layout.BorderPane; 
import javafx.scene.layout.HBox; 
import javafx.scene.layout.VBox; 
import javafx.stage.Stage; 

public class BorderPaneDemo extends Application { 
    
    @Override 
    public void start(Stage stage) { 
        Button okButton = new Button("OK"); 
        okButton.setDefaultButton(true); 
        
        Button cancelButton = new Button("Cancel"); 
        HBox hBox = new HBox(); 
        hBox.setPadding(new Insets(15, 12, 15, 12)); 
        hBox.setSpacing(10); 
        hBox.setStyle("-fx-background-color: #886699;"); 
        hBox.getChildren().addAll(okButton, cancelButton); 
        BorderPane root = new BorderPane(); 
        root.setTop(hBox); 
        
        ImageView imageView = new ImageView("image/1.jpg"); 
        root.setCenter(imageView); 
        
        VBox vBox = new VBox(); 
        vBox.setStyle("-fx-background-color: " + 
        		"#ddeeff;-fx-padding:10px"); 
        vBox.getChildren().addAll( 
                new Label("Select Color:"), 
                new ColorPicker()); 
        root.setLeft(vBox); 
         
        root.setStyle("-fx-background-color: #6680e6;"); 
        Scene scene = new Scene(root, 740, 530); 
        
        stage.setTitle("HBox, VBox, BorderPane Demo"); 
        stage.setScene(scene); 
        stage.show(); 
    } 

    public static void main(String[] args) { 
        launch(args); 
    } 
}