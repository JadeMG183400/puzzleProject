package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;

public interface AlertMessages {
	
	public static void imageNoExists() {
		Alert alerta = new Alert(AlertType.WARNING);
    	alerta.setTitle("Error");
    	alerta.setContentText("The picture location is incorrect or file doesn't exists.");
    	alerta.initStyle(StageStyle.UTILITY);
    	java.awt.Toolkit.getDefaultToolkit().beep();
    	alerta.showAndWait();
	}
	
	public static void imageExists() {
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Image found");
		alerta.setHeaderText("The picture location is correct.");
		alerta.initStyle(StageStyle.UTILITY);
		java.awt.Toolkit.getDefaultToolkit().beep();
		alerta.showAndWait();
	}
}
