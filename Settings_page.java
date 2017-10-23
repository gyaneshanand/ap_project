/*
Settings page: page that changes the color of orb of each player
it also has a back button which will return the user to the main page
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
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField; 
import javafx.scene.layout.GridPane; 
import javafx.scene.text.Text; 
import javafx.scene.control.TextField; 
import javafx.stage.Stage;


public class Settings_page extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Settings Page");	
        Text Player1 = new Text("Player 1");
        ChoiceBox colorchoiceBox1 = new ChoiceBox();
        ChoiceBox colorchoiceBox2 = new ChoiceBox();
        ChoiceBox colorchoiceBox3 = new ChoiceBox();
        ChoiceBox colorchoiceBox4 = new ChoiceBox();
        ChoiceBox colorchoiceBox5 = new ChoiceBox();
        ChoiceBox colorchoiceBox6 = new ChoiceBox();
        ChoiceBox colorchoiceBox7 = new ChoiceBox();
        ChoiceBox colorchoiceBox8 = new ChoiceBox();
        colorchoiceBox1.getItems().addAll("Red", "Blue", "Green", "Black", "pink","violet","orange","yellow");
        colorchoiceBox1.getSelectionModel().select(0);
        colorchoiceBox2.getItems().addAll("Red", "Blue", "Green", "Black", "pink","violet","orange","yellow");
        colorchoiceBox2.getSelectionModel().select(1);
        colorchoiceBox3.getItems().addAll("Red", "Blue", "Green", "Black", "pink","violet","orange","yellow");
        colorchoiceBox3.getSelectionModel().select(2);
        colorchoiceBox4.getItems().addAll("Red", "Blue", "Green", "Black", "pink","violet","orange","yellow");
        colorchoiceBox4.getSelectionModel().select(3);
        colorchoiceBox5.getItems().addAll("Red", "Blue", "Green", "Black", "pink","violet","orange","yellow");
        colorchoiceBox5.getSelectionModel().select(4);
        colorchoiceBox6.getItems().addAll("Red", "Blue", "Green", "Black", "pink","violet","orange","yellow");
        colorchoiceBox6.getSelectionModel().select(5);
        colorchoiceBox7.getItems().addAll("Red", "Blue", "Green", "Black", "pink","violet","orange","yellow");
        colorchoiceBox7.getSelectionModel().select(6);
        colorchoiceBox8.getItems().addAll("Red", "Blue", "Green", "Black", "pink","violet","orange","yellow");
        colorchoiceBox8.getSelectionModel().select(7);
        Text Player2 = new Text("Player 2");
        Text Player3 = new Text("Player 3");
        Text Player4 = new Text("Player 4");
        Text Player5 = new Text("Player 5");
        Text Player6 = new Text("Player 6");
        Text Player7 = new Text("Player 7");
        Text Player8 = new Text("Player 8");
        Button mainpage=new Button("BACK");
        Button save=new Button("SAVE");
        GridPane root = new GridPane(); 
        root.setPadding(new Insets(30, 30, 30, 30));
        root.setVgap(5); 
        root.setHgap(5);     
        root.add(Player1,0,0);
        root.add(colorchoiceBox1,1,0);
        root.add(Player2,0,1);
        root.add(colorchoiceBox2,1,1);
        root.add(Player3,0,2);
        root.add(colorchoiceBox3,1,2);
        root.add(Player4,0,3);
        root.add(colorchoiceBox4,1,3);
        root.add(Player5,0,4);
        root.add(colorchoiceBox5,1,4);
        root.add(Player6,0,5);
        root.add(colorchoiceBox6,1,5);
        root.add(Player7,0,6);
        root.add(colorchoiceBox7,1,6);
        root.add(Player8,0,7);
        root.add(colorchoiceBox8,1,7);
        root.add(mainpage,3,8);
        root.add(save,1,8);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root);
        System.out.println(colorchoiceBox8.getSelectionModel().getSelectedItem());
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

   
    public static void main(String[] args) {
        launch(args);
    }
    
}
