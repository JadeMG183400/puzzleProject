package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class customController {
	private ObservableList<String> shapes = FXCollections.observableArrayList();
	private ObservableList<String> sizeSquare = FXCollections.observableArrayList();
	private ObservableList<String> sizeRectangle = FXCollections.observableArrayList();
	private ObservableList<String> quantity = FXCollections.observableArrayList();
	@FXML
	private Button btn_start;
	@FXML
	private ComboBox<String> cmb_size, cmb_shape, cmb_quantity;
	
	public void initialize() {
		shapes.addAll("Square", "Rectangle");
		
		quantity.addAll("5x4", "5x5", "6x6", "4x9", "8x8", "10x10");
		
		sizeSquare.addAll("20x20", "25x25", "30x30", "40x40", "50x50");
		
		sizeRectangle.addAll("60x50", "30x15", "40x20");
		
		cmb_quantity.setItems(quantity);
		cmb_shape.setItems(shapes);
	}
	
	public void btnStart(ActionEvent event) throws IOException{
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/gameView.fxml"));
			AnchorPane menu = (AnchorPane) loader.load();
			Scene sceneMenu = new Scene(menu);
			
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
			window.setScene(sceneMenu);
	        window.alwaysOnTopProperty();
	        window.setTitle("Customize it!");
			window.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setSizes(ActionEvent event) {
		if(cmb_shape.getSelectionModel().getSelectedItem() == shapes.get(1)) {
			cmb_size.setItems(sizeRectangle);
		}else {
			cmb_size.setItems(sizeSquare);
		}
	}
	
	public int[] getSizePieces() {
		String[] size = cmb_size.getSelectionModel().getSelectedItem().split("x");
		for(int i=0; i<size.length; i++) {
			System.out.println(size[i]);
		}
		int width = Integer.parseInt(size[0]);
		int height = Integer.parseInt(size[1]);
		
		int[] sizeNum = {width, height};
		return sizeNum;
	}
	
	public int[] getQuantityPieces() {
		String[] quantity = cmb_quantity.getSelectionModel().getSelectedItem().split("x");
		int x = Integer.parseInt(quantity[0]);
		int y = Integer.parseInt(quantity[1]);
		
		int[] quantityPieces = {x,y};
		return quantityPieces;
	}
}
