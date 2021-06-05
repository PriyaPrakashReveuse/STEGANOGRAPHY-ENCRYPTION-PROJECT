package application;

import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class Controller {
	private Model model;
	
	public Controller(Model model) {
		this.model=model;
	}
	
	private ImageView originalView, modifiedView;
	private TextField fieldMessage;
	//key
	private TextField fieldKey;
	private TextField fieldKeyOut;
	
	public void injectUI(ImageView original, ImageView modified, TextField fieldMessage, TextField fieldKey , TextField fieldKeyOut) {
		this.originalView=original;
		this.modifiedView=modified;
		this.fieldMessage = fieldMessage;
		this.fieldKey = fieldKey;
		this.fieldKeyOut = fieldKeyOut;
	}
	
	public void onEncode() {
		
		System.out.println(fieldKey.getText());
		System.out.println(fieldMessage.getText());
		
		String EncryptedText = AESimplementation.encrypt(fieldMessage.getText(), fieldKey.getText());
		System.out.println(EncryptedText);
		//this where to add the encryption and send the encrypted text
		Image modified = model.encoder(originalView.getImage(), EncryptedText);
		modifiedView.setImage(modified);
	}
	
	public void onDecode() {
		String message = model.decode(modifiedView.getImage());
		String DecryptedText = AESimplementation.decrypt(message, fieldKeyOut.getText());
		System.out.println(DecryptedText);
	}

}
