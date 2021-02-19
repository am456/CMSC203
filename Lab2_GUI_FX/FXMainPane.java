


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button buttonHello;
	Button buttonHowdy;
	Button buttonChinese;
	Button buttonClear;
	Button buttonExit;
	
	Label labelFeedback;
	
	TextField textFieldOne;
	
	//  declare two HBoxes
	HBox hboxOne;
	HBox hboxTwo;
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager dataManager;
	
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		
		//Instatiate buttons
		buttonHello = new Button("Hello");
		buttonHello.setOnAction(new ButtonHandler());
		
		buttonHowdy = new Button("Howdy");
		buttonHowdy.setOnAction(new ButtonHandler());
		
		buttonChinese = new Button("Chinese");
		buttonChinese.setOnAction(new ButtonHandler());
		
		buttonClear = new Button("Clear");
		buttonClear.setOnAction(new ButtonHandler());
		
		buttonExit = new Button("Exit");
		buttonExit.setOnAction(new ButtonHandler());
		
		
		//Instantiate Label
		labelFeedback = new Label("Feedback:");
		
		//Instantiate text field
		textFieldOne = new TextField();
		
		
		//  instantiate the HBoxes
		hboxOne = new HBox();
		hboxTwo = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager instance
		dataManager = new DataManager();
		//  set margins and set alignment of the components	
		HBox.setMargin(buttonHello, new Insets(10));
		HBox.setMargin(buttonHowdy, new Insets(10));
		HBox.setMargin(buttonChinese, new Insets(10));
		HBox.setMargin(buttonClear, new Insets(10));
		HBox.setMargin(buttonExit, new Insets(10));
		
		//Align each hbox to center
		hboxOne.setAlignment(Pos.CENTER);
		hboxTwo.setAlignment(Pos.CENTER);
		
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		hboxOne.getChildren().add(labelFeedback);
		
		//  add the buttons to the other HBox
		hboxTwo.getChildren().add(buttonHello);
		hboxTwo.getChildren().add(buttonHowdy);
		hboxTwo.getChildren().add(buttonChinese);
		hboxTwo.getChildren().add(buttonClear);
		hboxTwo.getChildren().add(buttonExit);
		
		//  add the HBoxes to this FXMainPanel (a VBox)
		this.getChildren().addAll(hboxOne, hboxTwo, textFieldOne);
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	class ButtonHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			Object source = event.getTarget();
			
			if(source == buttonHello)
			{
				String hello = dataManager.getHello();
				textFieldOne.setText(hello);
			}
			else if (source == buttonHowdy)
			{
				textFieldOne.setText(dataManager.getHowdy());;
			}
			else if (source == buttonChinese)
			{
				textFieldOne.setText(dataManager.getChinese());;
			}
			else if (source == buttonClear)
			{
				textFieldOne.setText("");
			}
			else if (source == buttonExit)
			{
				Platform.exit();
				System.exit(0);
			}
		}
		
	}
	
}
	
