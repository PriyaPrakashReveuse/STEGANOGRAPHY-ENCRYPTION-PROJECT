//boiler plate code .. this is like creating a scene everytime javafax is being used
package application;	
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class StegApp extends Application {
	
	private Model makeModel() {
		return new Model(new BasicEncoder(), new BasicDecoder());
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		Scene scene=new Scene(new View(new Controller(makeModel())));
		primaryStage.setTitle("Steganograpy");
		primaryStage.setScene(scene);
		primaryStage.show();
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
