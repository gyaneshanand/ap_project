/*
Main page: page where number of players, size of grid can be decided
 */

//suyash singh
//2016105
//Aman Roy
//2016011
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Application; 
import static javafx.application.Application.launch; 
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.scene.text.Font; 
import javafx.scene.text.FontPosture; 
import javafx.scene.text.FontWeight; 
import javafx.scene.Scene; 
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Button; 
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField; 
import javafx.scene.layout.GridPane; 
import javafx.scene.text.Text; 
import javafx.scene.control.TextField; 
import javafx.stage.Stage;
import javafx.scene.control.*; 


public class Main_page extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Chain Reaction");	
        Text playernum = new Text("Number of Players : ");
        ChoiceBox playerchoiceBox = new ChoiceBox();
        playerchoiceBox.getItems().addAll(2,3,4,5,6,7,8);
        playerchoiceBox.getSelectionModel().select(0);
        Text Gridsize = new Text("Size of the grid: ");
        ToggleGroup groupGrid = new ToggleGroup();
        RadioButton _9X6 = new RadioButton("9X6");
        _9X6.setToggleGroup(groupGrid);
        RadioButton _15X10 = new RadioButton("15X10");
        _15X10.setToggleGroup(groupGrid);
        _9X6.setSelected(true);
        Text chainrxn = new Text("CHAIN REACTION");
        chainrxn.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
        Button start=new Button("START");
        Button resume=new Button("RESUME");
        Button settings=new Button("SETTINGS");
        GridPane root = new GridPane(); 
        root.setPadding(new Insets(30, 30, 30, 30));
        root.setVgap(5); 
        root.setHgap(5);     
        root.add(playernum,1,0);
        root.add(playerchoiceBox,2,0);
        root.add(Gridsize,1,1);
        root.add(_9X6,2,1);
        root.add(_15X10,3,1);
        root.add(chainrxn,1,2);
        root.add(start,1,3);
        root.add(resume,2,3);
        root.add(settings,1,4);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root);
        
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

   
    public static void main(String[] args) {
        launch(args);
    }
    
}
