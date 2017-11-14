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
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextField;

class node
{
    int currentsize;
    int maxsize;
    String type;
    String color;
    int player;
    public node(int maxsize , String type , String color , int player )
    {
        this.currentsize = 0;
        this.maxsize = maxsize;
        this.type = type;
        this.color = color;
        this.player = player;
    }
}
  
public class Game_page2 extends Application {
    
    node ar[][];
    int count;
    int player_numbers;
    String color[];
    int row , col;
    int i_index , j_index;
    //static Game_page2 g;
    public Game_page2(int row , int col , int p)
    {
        System.out.println(1);
        this.row = row;
        this.col = col;
        this.player_numbers = p;
        this.color = new String[]{"red","blue" , "green" , "black" ,"pink" , "violet" ,"orange","yellow"};
        this.count=0;
        this.setup(this.row , this.col);
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
        int k=0;
        int t=0;
        TranslateTransition translateTransition[] = new TranslateTransition[500];
        root.setBlendMode(BlendMode.MULTIPLY);
        for (int i=0;i<this.row ;i++ ) {
            for (int j=0; j<this.col;j++ ) {
               /* translateTransition[t]=new TranslateTransition();
                translateTransition[t].setDuration(Duration.millis(400));
                translateTransition[t+1]=new TranslateTransition();
                translateTransition[t+1].setDuration(Duration.millis(400)); 
                */box[i][j] = new Rectangle(i,j,40,40); 
                box[i][j].setStroke(Color.BLACK);
                box[i][j].setStrokeWidth(2);
                box[i][j].setFill(Color.TRANSPARENT);
              root.add(box[i][j],j,i);   
         /*    GridPane root1 = new GridPane(); 
        root1.setPadding(new Insets(10, 10, 10, 10));
        root1.setVgap(0); 
        root1.setHgap(0);
        sphere[k]=new Sphere(8);
        sphere[k+1]=new Sphere(7);
        //sphere[k+2]=new Sphere(6);
       translateTransition[t].setNode(sphere[k]);
        translateTransition[t].setByX(-2);
        translateTransition[t].setByY(2); 
        translateTransition[t].setCycleCount(Timeline.INDEFINITE);
      translateTransition[t].setAutoReverse(true); 
       translateTransition[t].play();
       translateTransition[t+1].setNode(sphere[k+1]);
        translateTransition[t+1].setByX(2);
        translateTransition[t+1].setByY(-2); 
        translateTransition[t+1].setCycleCount(Timeline.INDEFINITE);
      translateTransition[t+1].setAutoReverse(true); 
       translateTransition[t+1].play();
       
        root1.add(sphere[k],0,0);
        root1.add(sphere[k+1],1,0);
        //root1.add(sphere[k+2],0,1);
        root.add(root1,j+1,i+1);
        k=k+2;
        t=t+2;
*/    }
        }
        System.out.println(ar[0][0].player);
         for (int i=0;i<this.row ;i++ ) {
            for (int j=0; j<this.col;j++ ) {
                System.out.println(-1);
                System.out.println(this.player_numbers);
                box[i][j].addEventFilter(MouseEvent.MOUSE_CLICKED, new HelloEvent(this));    
             }
        }
        
        Button mainpage=new Button("BACK");
        Button redo=new Button("UNDO");
        Button restart=new Button("RESTART");
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

 
    public static void main(String[] args) {
       /* g = new Game_page2();
        g.player_numbers = 2;
        g.setup(15,10);
        g.color = new String[]{"red","blue" , "green" , "black" ,"pink" , "violet" ,"orange","yellow"}; */
        System.out.println(-1);
        launch(args);
    }
} 
class HelloEvent implements EventHandler <MouseEvent> {  

    Game_page2 g;
    HelloEvent(Game_page2 g)
    {
        this.g = g;
        System.out.println(g.ar[0][0]);
    }
    public void insert(int i,int j)
    {
        int temp;
        if(g.count%g.player_numbers==0)
        {
            temp = g.player_numbers;
        }
        else
        {
            temp = g.count%g.player_numbers;
        }
        if(g.ar[i][j].player==0)
        {
            System.out.println(g.ar[i][j].player);
            g.count+=1;
            g.ar[i][j].player = temp;
            g.ar[i][j].color = g.color[temp-1];
            g.ar[i][j].currentsize+=1;
        }
        else if(g.ar[i][j].player==temp)
        {
            //System.out.println(-1);
            g.count+=1;
            g.ar[i][j].currentsize+=1;
            if(g.ar[i][j].currentsize >= g.ar[i][j].maxsize)
            {
                func(i,j,g.ar[i][j].color,temp);
            }
        }
        System.out.println(g.count);
        return;
    }

    public void func(int i,int j,String color , int player_no)
    {
        if(g.ar[i][j].currentsize < g.ar[i][j].maxsize)
        {
            return;
        }
        if(g.ar[i][j].currentsize >= g.ar[i][j].maxsize)
        {
            String s = g.ar[i][j].type;
            g.ar[i][j].currentsize=0;
            if(s.equals("c"))
            {
                if(i==0 && j==0)
                {
                    g.ar[i+1][j].currentsize+=1;
                    g.ar[i+1][j].color=color;
                    g.ar[i+1][j].player = player_no;
                    g.ar[i][j+1].currentsize+=1;
                    g.ar[i][j+1].color=color;
                    g.ar[i][j+1].player = player_no;
                    func(i+1,j,color,player_no);
                    func(i,j+1,color,player_no);
                }
                else if(i==0 && j==g.col-1)
                {
                    g.ar[i+1][j].currentsize+=1;
                    g.ar[i+1][j].color=color;
                    g.ar[i+1][j].player = player_no;
                    g.ar[i][j-1].currentsize+=1;
                    g.ar[i][j-1].color=color;
                    g.ar[i][j-1].player = player_no;
                    func(i+1,j,color,player_no);
                    func(i,j-1,color,player_no);
                }
                else if(i==g.row-1 && j==0)
                {
                    g.ar[i-1][j].currentsize+=1;
                    g.ar[i-1][j].color=color;
                    g.ar[i-1][j].player = player_no;
                    g.ar[i][j+1].currentsize+=1;
                    g.ar[i][j+1].color=color;
                    g.ar[i][j+1].player = player_no;
                    func(i-1,j,color,player_no);
                    func(i,j+1,color,player_no);

                }
                else if(i==g.row-1 && j==g.col-1)
                {
                    g.ar[i-1][j].currentsize+=1;
                    g.ar[i-1][j].color=color;
                    g.ar[i-1][j].player = player_no;
                    g.ar[i][j-1].currentsize+=1;
                    g.ar[i][j-1].color=color;
                    g.ar[i][j-1].player = player_no;
                    func(i-1,j,color,player_no);
                    func(i,j-1,color,player_no);
                }

            }
            else if(s.equals("f"))
            {
                if(i==0)
                {
                    g.ar[i+1][j].currentsize+=1;
                    g.ar[i+1][j].color=color;
                    g.ar[i+1][j].player = player_no;
                    g.ar[i][j-1].currentsize+=1;
                    g.ar[i][j-1].color=color;
                    g.ar[i][j-1].player = player_no;
                    g.ar[i][j+1].currentsize+=1;
                    g.ar[i][j+1].color=color;
                    g.ar[i][j+1].player = player_no;
                    func(i+1,j,color,player_no);
                    func(i,j-1,color,player_no);
                    func(i,j+1,color,player_no);    
                }
                else if(i==g.row-1)
                {
                    g.ar[i-1][j].currentsize+=1;
                    g.ar[i-1][j].color=color;
                    g.ar[i-1][j].player = player_no;
                    g.ar[i][j-1].currentsize+=1;
                    g.ar[i][j-1].color=color;
                    g.ar[i][j-1].player = player_no;
                    g.ar[i][j+1].currentsize+=1;
                    g.ar[i][j+1].color=color;
                    g.ar[i][j+1].player = player_no;
                    func(i-1,j,color,player_no);
                    func(i,j-1,color,player_no);
                    func(i,j+1,color,player_no);    
                }
                else if(j==0)
                {
                    g.ar[i+1][j].currentsize+=1;
                    g.ar[i+1][j].color=color;
                    g.ar[i+1][j].player = player_no;
                    g.ar[i-1][j].currentsize+=1;
                    g.ar[i-1][j].color=color;
                    g.ar[i-1][j].player = player_no;
                    g.ar[i][j+1].currentsize+=1;
                    g.ar[i][j+1].color=color;
                    g.ar[i][j+1].player = player_no;
                    func(i+1,j,color,player_no);
                    func(i-1,j,color,player_no);
                    func(i,j+1,color,player_no);
                }
                else
                {
                    g.ar[i+1][j].currentsize+=1;
                    g.ar[i+1][j].color=color;
                    g.ar[i+1][j].player = player_no;
                    g.ar[i-1][j].currentsize+=1;
                    g.ar[i-1][j].color=color;
                    g.ar[i-1][j].player = player_no;
                    g.ar[i][j-1].currentsize+=1;
                    g.ar[i][j-1].color=color;
                    g.ar[i][j-1].player = player_no;
                    func(i+1,j,color,player_no);
                    func(i-1,j,color,player_no);
                    func(i,j-1,color,player_no);

                }
            }
            else
            {
                g.ar[i+1][j].currentsize+=1;
                g.ar[i+1][j].color=color;
                g.ar[i+1][j].player = player_no;
                g.ar[i-1][j].currentsize+=1;
                g.ar[i-1][j].color=color;
                g.ar[i-1][j].player = player_no;
                g.ar[i][j-1].currentsize+=1;
                g.ar[i][j-1].color=color;
                g.ar[i][j-1].player = player_no;
                g.ar[i][j+1].currentsize+=1;
                g.ar[i][j+1].color=color;
                g.ar[i][j+1].player = player_no;
                func(i+1,j,color,player_no);
                func(i-1,j,color,player_no);
                func(i,j-1,color,player_no);
                func(i,j+1,color,player_no);

            }
        }
    }
    @Override 
    public void handle(MouseEvent event) { 
        Node source = (Node) event.getSource();
        int x = GridPane.getRowIndex(source);
        int y = GridPane.getColumnIndex(source);
        //System.out.println(GridPane.getColumnIndex(source) +""+GridPane.getRowIndex(source) );
        //System.out.println(g.i_index +""+g.j_index ); 
        //System.out.println(g.ar[14][9]);
        insert(x,y); 
        System.out.println(g.ar[x][y].player); 
        print();
        //System.out.println(g.count);      
    }
    public void print()
    {
        for(int i=0;i<g.row;i++)
        {
            for(int j=0;j<g.col;j++)
            {
                System.out.print(g.ar[i][j].currentsize+"T"+g.ar[i][j].player + " ");
            }
            System.out.println();
        }
    }      
}
