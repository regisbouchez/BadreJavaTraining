package com.bnpparibas.training.javafx;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button; 
import javafx.scene.control.CheckBox; 
import javafx.scene.control.ChoiceBox; 
import javafx.scene.control.ColorPicker; 
import javafx.scene.control.ComboBox; 
import javafx.scene.control.Hyperlink; 
import javafx.scene.control.Label; 
import javafx.scene.control.ListView; 
import javafx.scene.control.MenuButton; 
import javafx.scene.control.MenuItem; 
import javafx.scene.control.PasswordField; 
import javafx.scene.control.RadioButton; 
import javafx.scene.control.ScrollBar; 
import javafx.scene.control.Separator; 
import javafx.scene.control.Slider; 
import javafx.scene.control.TextArea; 
import javafx.scene.control.TextField; 
import javafx.scene.control.ToggleGroup; 
import javafx.scene.layout.ColumnConstraints; 
import javafx.scene.layout.GridPane; 
import javafx.scene.paint.Color; 
import javafx.stage.Stage; 

public class ControlsDemo extends Application { 
    
    @Override 
    public void start(Stage stage) { 
        GridPane grid = new GridPane(); 
        grid.setHgap(15); 
        grid.setVgap(25); 
        ColumnConstraints constraint = new ColumnConstraints(); 
        constraint.setPercentWidth(25); 
        grid.getColumnConstraints().addAll(constraint, 
                constraint, constraint, constraint); 
        grid.setPadding(new Insets(10)); 
        
        grid.add(new Label("Label"), 0, 0); 
        grid.add(new Button("Button"), 1, 0); 
        grid.add(new CheckBox("CheckBox"), 2, 0); 
        
        ChoiceBox<String> choiceBox = new ChoiceBox<String>(); 
        
        choiceBox.getItems().addAll("ChoiceBox 1", "ChoiceBox 2"); 
        choiceBox.setValue("ChoiceBox 1"); 
        grid.add(choiceBox, 3, 0); 

        grid.add(new ColorPicker(Color.GREEN), 0, 1); 
        
        ComboBox<String> comboBox = new ComboBox<String>(); 
        comboBox.getItems().addAll("Combo 1", "Combo 2"); 
        comboBox.setValue("Combo 1"); 
        grid.add(comboBox, 1, 1); 
        
        grid.add(new Hyperlink("Hyperlink"), 2, 1); 
        
        ListView<String> listView = new ListView<String>(); 
        listView.getItems().addAll("List Item 1", 
                "List Item 2", "List Item 3"); 
        grid.add(listView, 3, 1); 
        
        MenuButton menuButton = new MenuButton("Menu"); 
        menuButton.getItems().addAll(new MenuItem("Menu 1"), 
                new MenuItem("Menu 1")); 
        grid.add(menuButton, 0, 2); 
        
        grid.add(new TextField("TextField"), 1, 2); 
        
        PasswordField passwordField = new PasswordField(); 
        passwordField.setText("Password"); 
        grid.add(passwordField, 2, 2); 

        grid.add(new ScrollBar(), 3, 2); 

        ToggleGroup group = new ToggleGroup(); 
        RadioButton radioButton1 = new RadioButton("Radio 1"); 
        radioButton1.setToggleGroup(group); 
        radioButton1.setSelected(true); 
        RadioButton radioButton2 = new RadioButton("Radio 2"); 
        radioButton2.setToggleGroup(group); 
        grid.add(radioButton1, 0, 3); 
        grid.add(radioButton2, 1, 3); 
        
        TextArea textArea = new TextArea("TextArea"); 
        textArea.setMinHeight(60.00); 
        grid.add(textArea, 2, 3); 
        
        grid.add(new Separator(), 3, 3); 
        
        Slider slider2 = new Slider(0, 100, 30); 
        slider2.setShowTickMarks(true); 
        slider2.setShowTickLabels(true); 
        grid.add(slider2, 0, 4, 4, 1); 
        
        Scene scene = new Scene(grid, 600, 320); 
        scene.setFill(Color.BEIGE); 
        
        stage.setTitle("JavaFX Controls"); 
        stage.setScene(scene); 
        stage.show(); 
    } 

    public static void main(String[] args) { 
        launch(args); 
    } 
}