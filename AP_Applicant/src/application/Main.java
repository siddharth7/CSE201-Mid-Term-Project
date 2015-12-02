/*@author Praveen Kumar Jhanwar
 * roll no - 2014078 */

package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ApplicantUI.fxml"));
			Scene scene = new Scene(root, 715, 625);
			primaryStage.setScene(scene);
			primaryStage.setTitle("IIIT Delhi Admissions");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}