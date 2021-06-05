package application;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class View extends Pane {
	
	public Controller controller;
	
	public View(Controller controller) {
		this.controller= controller;
		
		//setPrefsize(635 * 2, 500);
		
		Image image=new Image("https://image.shutterstock.com/image-photo/mountains-under-mist-morning-amazing-260nw-1725825019.jpg");
		ImageView originalview = new ImageView(image);
		
		ImageView modifiedview=new ImageView();
		modifiedview.setTranslateX(635);
		
		TextField field = new TextField("Enter Message");
		field.setTranslateY(454);
//		field.setOnAction(e->controller.onEncode());
		
		//input for they key ----
		TextField field2 = new TextField("Enter Key");
		field2.setTranslateY(400);
		field2.setOnAction(e->controller.onEncode());
		
		TextField field3 = new TextField("Enter Key");
		field3.setTranslateY(400);
		field3.setTranslateX(635);
		field3.setOnAction(e->controller.onEncode());
		
		Button btnDecode = new Button("DECODE");
		btnDecode.setTranslateX(635);
		btnDecode.setTranslateY(454);
		btnDecode.setOnAction(e->controller.onDecode());
		
		controller.injectUI(originalview, modifiedview,field, field2, field3 );
		
		getChildren().addAll(originalview, modifiedview, field, field2, field3,  btnDecode);
	}
}