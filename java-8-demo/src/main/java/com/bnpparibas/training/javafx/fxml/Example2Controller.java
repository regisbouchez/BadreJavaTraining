package com.bnpparibas.training.javafx.fxml;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Example2Controller implements Initializable {

	@FXML
	private TextField userNameField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Label statusLabel;

	@FXML
	private void handleReset(ActionEvent event) {
		userNameField.setText("");
		passwordField.setText("");
		statusLabel.setText("");
	}

	@FXML
	private void handleLogin(ActionEvent event) {

		String userName = userNameField.getText();
		String password = passwordField.getText();
		if ("john".equals(userName) && "secret".equals(password)) {
			statusLabel.setText("Login successul");
		} else {
			statusLabel.setText("Login failed");
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}
}