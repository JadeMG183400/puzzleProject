package application;

import java.io.IOException;
import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class menuController {
	private boolean imageLoaded = false;
	
	@FXML
	private Button btn_load, btn_next;
	@FXML
	private Image image;
	@FXML
	private ImageView img;
	
	public void btnLoad(ActionEvent event) {
		final FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(null);
		if(file != null) {
			openFile(file);
			imageLoaded = true;
		}
		if(imageIsLoaded(imageLoaded) == true) {
			btn_next.setDisable(false);
		}
	}
	
	public void btnNext(ActionEvent event) throws IOException{
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/customView.fxml"));
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
	
	public Image getImage() {
		return image;
	}
	
    private void openFile(File file) {
        try {
        	image = new Image(file.toURI().toString(),400,400,false,false);
            img.setImage(image);
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
    
    public boolean imageIsLoaded(boolean answer) {
    	boolean isLoaded = false;
    	if(answer == true) {
    		isLoaded = true;
    		return isLoaded;
    	}
    	return isLoaded;
    }
}
