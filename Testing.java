package practice4JavaFXquiz;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Testing extends Application{
	CirclePane cPane = new CirclePane();
	
	public void start (Stage pStage) {
		
		//creating HBox
		HBox hbox = new HBox();
		hbox.setSpacing(10);  
		hbox.setAlignment(Pos.CENTER); 
		
		//creating Buttons
		Button btEnlarge = new Button("Enlarge");
		Button btShrink = new Button ("Shrink");
		
		//Buttons for color of Circle
		Button btRed = new Button ("Red Circle");
		Button btBlue = new Button ("Blue Circle");
		

		//create and register the Handler
		btEnlarge.setOnAction(new EventHandler <ActionEvent> (){
			public void handle (ActionEvent e) {
				cPane.Enlarge();
			}
		});
		
		btShrink.setOnAction(new EventHandler <ActionEvent> (){
			public void handle (ActionEvent e) {
				cPane.Shrink();
			}
		});
		
		//create and register the Handler for color
		btRed.setOnAction(new EventHandler<ActionEvent>(){
			public void handle (ActionEvent e) {
				cPane.Red();
			}
		});
		
		btBlue.setOnAction(new EventHandler<ActionEvent>(){
			public void handle (ActionEvent e) {
				cPane.Blue();
			}
		});
		
		//adding Buttons to HBox
		hbox.getChildren().add(btEnlarge);
		hbox.getChildren().add(btShrink);

		//adding color Buttons to HBox
		hbox.getChildren().add(btRed);
		hbox.getChildren().add(btBlue);
		
		//creating Border Pane 
		BorderPane bpane = new BorderPane();
		bpane.setCenter(cPane);
		bpane.setBottom(hbox);
		bpane.setAlignment(hbox, Pos.CENTER);
	
		//Create a scene and place it in the Stage
		Scene scene = new Scene (bpane, 300,250);
		pStage.setTitle("Practice for Quiz");
		pStage.setScene(scene);
		pStage.show();
	}



}

class CirclePane extends StackPane{
	//create a Circle Object size 50
	private Circle circle = new Circle (50); 

	//adding circle to Pane 
	public CirclePane () {
		getChildren().add(circle);
		circle.setStroke(Color.BLACK); //line color
		circle.setFill(Color.WHITE); //fill color
	}

	//button function to enlarge circle radius
	public void Enlarge() {
		circle.setRadius(circle.getRadius()+2);
	}
	
	public void Shrink() {
		circle.setRadius(circle.getRadius()> 2 ?
				circle.getRadius() -2 : circle.getRadius());
	}
	
	public void Red() {
		circle.setFill(Color.RED);
	}
	
	public void Blue() {
		circle.setFill(Color.BLUE);
	}

}
