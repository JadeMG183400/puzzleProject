package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class puzzleController {
	@FXML
	private Button btn_play,btn_exit;
	@FXML
	private Image img = new Image("/application/exit-icon.png", 40, 40, false, false);
	
	public void initialize() {
		btn_exit.setGraphic(new ImageView(img));
	}
	
	public void btnPlay(ActionEvent event) throws IOException{
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/menuView.fxml"));
			AnchorPane menu = (AnchorPane) loader.load();
			Scene sceneMenu = new Scene(menu);
			
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
			window.setScene(sceneMenu);
	        window.alwaysOnTopProperty();
	        window.setTitle("Menu");
			window.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void btnExit(ActionEvent event) {
		try {
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
			window.close();	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
