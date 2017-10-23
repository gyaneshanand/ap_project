/*
Game page: the page where game is going on, the grid is 9X6 
 */


//suyash singh
//2016105
//Aman Roy
//2016011

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.shape.CullFace; 
import javafx.stage.Stage; 
import javafx.scene.shape.Sphere;
import javafx.application.Application; 
import static javafx.application.Application.launch; 
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.PerspectiveCamera; 
import javafx.scene.Scene;  
import javafx.scene.paint.*;
import javafx.scene.shape.Box; 
import javafx.scene.shape.DrawMode; 
import javafx.stage.Stage; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField; 
import javafx.scene.layout.GridPane; 
import javafx.scene.text.Text; 
import javafx.scene.control.TextField; 
import javafx.stage.Stage;


public class Game_page extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Game Page");	
        Box[][] box=new Box[50][50];
        GridPane root = new GridPane(); 
        root.setPadding(new Insets(30, 30, 30, 30));
        root.setVgap(10); 
        root.setHgap(10);
        for (int j=0;j<6 ;j++ ) {
            for (int i=0; i<9;i++ ) {
                box[j][i] = new Box(); 
                box[j][i].setWidth(30.0); 
                box[j][i].setHeight(30.0);   
                box[j][i].setDepth(30.0);
                box[j][i].setTranslateX(20); 
                box[j][i].setTranslateY(20);            
                box[j][i].setDrawMode(DrawMode.LINE);
                root.add(box[j][i],j+1,i+1);   
             }
        }
        Button mainpage=new Button("BACK");
        Button redo=new Button("UNDO");
        Button restart=new Button("RESTART");
        root.add(mainpage,0,0);
        root.add(redo,1,0);
        root.add(restart,2,0);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root);
        PerspectiveCamera camera = new PerspectiveCamera(false); 
        camera.setTranslateX(3); 
        camera.setTranslateY(4); 
        camera.setTranslateZ(0); 
        scene.setCamera(camera);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

   
    public static void main(String[] args) {
        launch(args);
    }
    
}