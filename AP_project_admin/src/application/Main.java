/*@author Praveen Kumar Jhanwar
 * roll no - 2014078 
 * @author Siddharth Singh
 * roll no - 2014105*/

package application;
	
import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		URL url = getClass().getResource("frontend_admin.fxml");
	    AnchorPane pane;
		try {
			pane = FXMLLoader.load(url);
		    Scene scene = new Scene(pane);
		    primaryStage.setScene(scene);
		    primaryStage.setTitle( "Admin Panel");
		    primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
