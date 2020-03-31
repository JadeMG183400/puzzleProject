package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class gameController {
	private customController custom;
	private menuController menu;
	private Image img;
	private int[] sizeImg = custom.getSizePieces();
	private int[] numPieces = custom.getQuantityPieces();
	@FXML
	private Button btn_restart, btn_autoSolution;
	@FXML
	private AnchorPane pane;
	
	public void initialize() {
		int positionImg = 0;
		int width = sizeImg[0];
		int height = sizeImg[1];
		int x = numPieces[0];
		int y = numPieces[1];
		
		ArrayList<Image> listOPieces = new ArrayList<>();
		img = menu.getImage();
		
		PixelReader reader = img.getPixelReader();
        listOPieces = getPieces(reader, x, y, width, height);
        
        VBox vCropImg = new VBox(1);
        vCropImg.setLayoutX(10.0);
        vCropImg.setLayoutY(20.0);
        vCropImg.setAlignment(Pos.CENTER);
        
        for(int i = 0; i<x; i++) {
        	HBox hCropImg = new HBox(1);
        	for(int j = 0; j<y; j++) {
        		ImageView newImg = new ImageView();
        		Button button = new Button();
        		button.setGraphic(newImg);
        		newImg.setImage(listOPieces.get(positionImg));
        		hCropImg.getChildren().add(button);
        		positionImg++;
        	}
        	vCropImg.getChildren().add(hCropImg);
        }
        pane.getChildren().add(vCropImg);
	}
	
	public void btnRestart(ActionEvent event) {
		
	}
	
	public void btnAutomatic(ActionEvent event) {
		
	}
	
	public ArrayList<Image> getPieces(PixelReader pixel, int x, int y, int width, int height) {
		ArrayList<Image> pieces = new ArrayList<>();
		int widthImg = width;
		int heightImg = height;
		int xAux = 0;
		int yAux = 0;
		int CoordinateX = x;
		int CoordinateY = y;
		
		for(int i=0; i<CoordinateX; i++) {
			for(int j=0; j<CoordinateY; j++) {
				WritableImage croppedImage = new WritableImage(pixel, x, y, width, height);
				pieces.add(croppedImage);
				xAux = xAux + widthImg;
			}
			yAux = yAux + heightImg;
			xAux = 0;
		}
		return pieces;
	}
}
