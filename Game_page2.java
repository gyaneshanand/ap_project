/*
Game page: the page where game is going on, the grid is 15X10
 */

//suyash singh
//2016105
//Aman Roy
//2016011
import javafx.scene.Node;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition; 
import javafx.util.Duration; 
import javafx.application.Application;
import javafx.scene.effect.BlendMode;
import javafx.scene.paint.PhongMaterial;
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
import javafx.scene.paint.Material;
import javafx.scene.control.Button; 
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField; 
import javafx.scene.layout.*; 
import javafx.scene.text.Text; 
import javafx.scene.control.TextField; 
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextField;
import java.io.Serializable;
  
public class Game_page2 extends Application implements Serializable {
    
    node ar[][];
    int count;
    int player_numbers;
    String color[];
    int row , col;
    int i_index , j_index;
    Main_page m;
    //static Game_page2 g;
    public Game_page2(int row , int col , int p , Main_page m , String[] color)
    {
        System.out.println(1);
        this.row = row;
        this.col = col;
        this.player_numbers = p;
        this.color = color;
        this.count=0;
        this.setup(this.row , this.col);
        this.m = m;
    }
    public void setup(int size1 , int size2)
    {
        row = size1;
        col = size2;
        ar = new node [size1][size2];
        count=0;
        for(int i=0;i<size1;i++)
        {
            for(int j=0;j<size2;j++)
            {
                if(i==0 && j==0 || i==size1-1 && j==0 || i==0 && j==size2-1 || i==size1-1 && j==size2-1)
                {
                    helper(i,j, 2,"c");
                }
                else if(i==0 || i==size1-1 || j==0 || j==size2-1)
                {
                    helper(i,j,3,"f");
                }
                else
                {
                    helper(i,j,4,"m");
                }
            }
        }
        count=1;
    }
    public void helper(int i , int j,int max , String t)
    {
        count+=1;
        if(count%player_numbers==0)
        {   
            ar[i][j] = new node(max , t ,"" ,0 );
        }
        else
        {
            ar[i][j] = new node(max , t ,"" ,0 );
        }
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Game Page");	
        Rectangle[][] box=new Rectangle[50][50];
        Sphere[] sphere =new Sphere[500];
        GridPane root = new GridPane(); 
       
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setVgap(0); 
        root.setHgap(0);
        GridPane[][] stack=new GridPane[50][50];
        int k=0;
        int t=0;
        TranslateTransition translateTransition[] = new TranslateTransition[500];
       
        root.setBlendMode(BlendMode.MULTIPLY);
        for (int i=0;i<this.row ;i++ ) {
            for (int j=0; j<this.col;j++ ) {
              
                box[i][j] = new Rectangle(i,j,40,40);     
                box[i][j].setStroke(Color.BLACK);
                box[i][j].setStrokeWidth(2);
                box[i][j].setFill(Color.TRANSPARENT);
                stack[i][j]=new GridPane();
                stack[i][j].setPadding(new Insets(10, 10, 10, 10));
                root.add(box[i][j],j,i);      
 }
        }
        System.out.println(ar[0][0].player);
         for (int i=0;i<this.row ;i++ ) {
            for (int j=0; j<this.col;j++ ) {
                System.out.println(-1);
                System.out.println(this.player_numbers);
                stack[i][j].addEventFilter(MouseEvent.MOUSE_CLICKED, new HelloEvent(this,stack,root)); 
                root.add(stack[i][j],j,i); 
                root.setRowSpan(stack[i][j],2);
                root.setColumnSpan(stack[i][j],2);
          }
        }
        
        Button mainpage=new Button("BACK");
        mainpage.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent event)
            {
                m.start(primaryStage);
            }
        });
        Button redo=new Button("UNDO");
        Button restart=new Button("RESTART");
        restart.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent event)
            {
                Game_page2 g =  new Game_page2(row , col , player_numbers , m , m.s.color);
                g.start(primaryStage);
            }
        });

        root.add(mainpage,20,20);
        root.add(redo,21,20);
        root.add(restart,22,20);
        root.setAlignment(Pos.CENTER);
        
       // box[1][1].setFill();
        Scene scene = new Scene(root);
        PerspectiveCamera camera = new PerspectiveCamera(false); 
        camera.setTranslateX(3); 
        camera.setTranslateY(4); 
        camera.setTranslateZ(0); 
        scene.setCamera(camera);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

 
    /*public static void main(String[] args) {
       /* g = new Game_page2();
        g.player_numbers = 2;
        g.setup(15,10);
        g.color = new String[]{"red","blue" , "green" , "black" ,"pink" , "violet" ,"orange","yellow"}; 
        System.out.println(-1);
        launch(args);
    }*/
} 
