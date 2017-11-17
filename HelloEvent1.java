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

public class HelloEvent implements EventHandler <MouseEvent> , Serializable {  
    GridPane[][] r;
    Game_page2 g;
   	GridPane root;
    HelloEvent(Game_page2 g,GridPane[][] st,GridPane root)
    {
        this.g = g;
        this.r=st;
        this.root=root;
        //System.out.println(g.ar[0][0]);
    }

   
    public void makecopy(Game_page2 g1 ,int k)
    {
    	//System.out.println(g);
    	if(g1!=null)
    	{
    		Game_page2 temp = new Game_page2(g1.row , g1.col , g1.player_numbers , g1.m , g1.color);
	    	temp.count = g1.count;
	    	temp.setup(temp.row , temp.col);
	    	for(int i=0;i<temp.row;i++)
	    	{
	    		for(int j=0;j<temp.col;j++)
	    		{
	    			temp.ar[i][j].currentsize = g1.ar[i][j].currentsize; 
	    			temp.ar[i][j].maxsize = g1.ar[i][j].maxsize;
	    			temp.ar[i][j].type = g1.ar[i][j].type;
	    			temp.ar[i][j].color = g1.ar[i][j].color;
	    			temp.ar[i][j].player = g1.ar[i][j].player;
	    		}
	    	}
	    	if(k==1)
	    	{
	    		g.prev = temp;
	    		g.prev.count = g1.count;
	    	}
	    	else
	    	{
	    		g.cur = temp;
	    		g.cur.count = g1.count;
	    	}
    	}
    	
    }
    public void insertball(int i,int j,String col){
    PhongMaterial material = new PhongMaterial();
    if (col.equals("RED")) {
        material.setDiffuseColor(Color.RED);    
    }
    else if (col.equals("BLUE")) {
        material.setDiffuseColor(Color.BLUE);    
    }
    else if (col.equals("GREEN")) {
        material.setDiffuseColor(Color.GREEN);    
    }
    else if (col.equals("BLACK")) {
        material.setDiffuseColor(Color.BLACK);    
    }
    else if (col.equals("PINK")) {
        material.setDiffuseColor(Color.PINK);    
    }
    else if (col.equals("VIOLET")) {
      material.setDiffuseColor(Color.VIOLET);    
    }
    else if (col.equals("ORANGE")) {
    material.setDiffuseColor(Color.ORANGE);    
    }
    else{
        material.setDiffuseColor(Color.YELLOW);    
    }
   

     if (i==0 && j==0 || i==0 && j==g.col-1||i==g.row-1 && j==0||i==g.row-1 && j==g.col-1) {  
     if (g.ar[i][j].currentsize==1) {
        r[i][j].getChildren().clear();
        Sphere s1=new Sphere(7);
        s1.setMaterial(material);
        TranslateTransition translateTransition1=new TranslateTransition();
        translateTransition1.setDuration(Duration.millis(100)); 
        translateTransition1.setNode(s1);
        translateTransition1.setByX(5);
        translateTransition1.setCycleCount(Timeline.INDEFINITE);
        translateTransition1.setAutoReverse(true); 
        translateTransition1.play();   
        r[i][j].add(s1,0,0);
       //root.add(r,j,i); 
        
     }
     else if (g.ar[i][j].currentsize==2) {
        r[i][j].getChildren().clear();
        
     }

}
else if (i==0 || i==g.row-1 || j==0 || j==g.col-1) {
    TranslateTransition translateTransition1=new TranslateTransition();
    TranslateTransition translateTransition2=new TranslateTransition();
    Sphere s1=null;
    Sphere s2=null;
    
    if (g.ar[i][j].currentsize==1) {
        r[i][j].getChildren().clear();
        s1=new Sphere(7);
        s1.setMaterial(material);
        translateTransition1.setDuration(Duration.millis(500)); 
        translateTransition1.setNode(s1);
        translateTransition1.setByX(5);
        translateTransition1.setCycleCount(Timeline.INDEFINITE);
        translateTransition1.setAutoReverse(true); 
        translateTransition1.play();   
        r[i][j].add(s1,0,0);
       //root.add(r,j,i);
        
     }
     else if (g.ar[i][j].currentsize==2) {
       //  System.out.println(3000);
        r[i][j].getChildren().clear();
        s2=new Sphere(7);
        s1=new Sphere(7);
        s1.setMaterial(material);
        s2.setMaterial(material);
        translateTransition1.setDuration(Duration.millis(200)); 
        translateTransition2.setDuration(Duration.millis(200)); 
        translateTransition2.setNode(s2);
        translateTransition2.setByX(5);
        translateTransition2.setCycleCount(Timeline.INDEFINITE);
        translateTransition2.setAutoReverse(true); 
        translateTransition2.play();   
        r[i][j].add(s1,0,0);
        r[i][j].add(s2,0,0);
       //root.add(r,j,i);
     }
     else{
         r[i][j].getChildren().clear();
     }
}
else{
     TranslateTransition translateTransition1=new TranslateTransition();
    TranslateTransition translateTransition2=new TranslateTransition();
    Sphere s1=null;
    Sphere s2=null;
    Sphere s3=null;
    if (g.ar[i][j].currentsize==1) {
        r[i][j].getChildren().clear();
        s1=new Sphere(7);
        s1.setMaterial(material);
        r[i][j].add(s1,0,0);
       //root.add(r,j,i);
     }
     else if (g.ar[i][j].currentsize==2) {
        r[i][j].getChildren().clear();
        s2=new Sphere(7);
        s1=new Sphere(7);
        s1.setMaterial(material);
        s2.setMaterial(material);
        translateTransition2.setDuration(Duration.millis(500)); 
        translateTransition2.setNode(s1);
        translateTransition2.setByX(10);
        translateTransition2.setCycleCount(Timeline.INDEFINITE);
        translateTransition2.setAutoReverse(true); 
        translateTransition2.play();   
        translateTransition1.setDuration(Duration.millis(500)); 
        translateTransition1.setNode(s2);
        translateTransition1.setByX(-10);
        translateTransition1.setCycleCount(Timeline.INDEFINITE);
        translateTransition1.setAutoReverse(true); 
        translateTransition1.play();   
        r[i][j].add(s1,0,0);
        r[i][j].add(s2,1,0);
        //root.add(r,j,i);
     } 
     else if (g.ar[i][j].currentsize==3) {
            r[i][j].getChildren().clear();
            s2=new Sphere(7);
            s1=new Sphere(7);
            s3=new Sphere(7);
            s1.setMaterial(material);
            s2.setMaterial(material);
            s3.setMaterial(material);
            translateTransition1.setNode(s2);
            translateTransition1.setByX(-10);
            translateTransition1.setByY(10); 
            translateTransition1.setCycleCount(Timeline.INDEFINITE);
            translateTransition1.setAutoReverse(true); 
            translateTransition1.play();
            translateTransition2.setNode(s3);
            translateTransition2.setByX(10);
            translateTransition2.setByY(-10); 
            translateTransition2.setCycleCount(Timeline.INDEFINITE);
            translateTransition2.setAutoReverse(true); 
            translateTransition2.play();
            r[i][j].add(s1,0,0);
            r[i][j].add(s2,1,0);
            r[i][j].add(s3,0,1);
           // root.add(r,j,i);
       }
       else{
         r[i][j].getChildren().clear();
       } 
}
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
            //System.out.println(g.ar[i][j].player);
            g.count+=1;
            g.ar[i][j].player = temp;
            g.ar[i][j].color = g.color[temp-1];
            g.ar[i][j].currentsize+=1;
            insertball(i,j,g.ar[i][j].color);
        }
        else if(g.ar[i][j].player==temp)
        {
            //System.out.println(-1);
            g.count+=1;
            g.ar[i][j].currentsize+=1;
            insertball(i,j,g.ar[i][j].color);
            if(g.ar[i][j].currentsize >= g.ar[i][j].maxsize)
            {
                System.out.println(1000);
                func(i,j,g.ar[i][j].color,temp);
            }
        }
        makecopy(g,2);
       // System.out.println(-1000);
       // System.out.println(g.count);
        return;
    }

    public void func(int i,int j,String color , int player_no)
    {
        if(g.ar[i][j].currentsize < g.ar[i][j].maxsize)
        {
           // insertball(i,j,g.ar[i][j].color);
            return;
        }
        if(g.ar[i][j].currentsize >= g.ar[i][j].maxsize)
        {
            String s = g.ar[i][j].type;
            g.ar[i][j].currentsize=0;
            g.ar[i][j].player=0;
            g.ar[i][j].color="";
            if(s.equals("c"))
            {
                if(i==0 && j==0)
                {
                   // System.out.println(2000);
                    g.ar[i+1][j].currentsize+=1;
                    g.ar[i+1][j].color=color;
                    g.ar[i+1][j].player = player_no;
                    //transitionXright(i+1,j,g.ar[i+1][j].color);
                    insertball(i+1,j,g.ar[i+1][j].color);
                    g.ar[i][j+1].currentsize+=1;
                    g.ar[i][j+1].color=color;
                    g.ar[i][j+1].player = player_no;
                    //transitionYdown(i,j+1,g.ar[i][j+1].color);
                    insertball(i,j+1,g.ar[i][j+1].color);
                    func(i+1,j,color,player_no);
                    func(i,j+1,color,player_no);
                }
                else if(i==0 && j==g.col-1)
                {
                    g.ar[i+1][j].currentsize+=1;
                    g.ar[i+1][j].color=color;
                    g.ar[i+1][j].player = player_no;
                    //transitionXright(i+1,j,g.ar[i+1][j].color);
                    insertball(i+1,j,g.ar[i+1][j].color);
                    g.ar[i][j-1].currentsize+=1;
                    g.ar[i][j-1].color=color;
                    g.ar[i][j-1].player = player_no;
                   // transitionYup(i,j-1,g.ar[i][j-1].color);
                    insertball(i,j-1,g.ar[i][j-1].color);
                    func(i+1,j,color,player_no);
                    func(i,j-1,color,player_no);
                }
                else if(i==g.row-1 && j==0)
                {
                    g.ar[i-1][j].currentsize+=1;
                    g.ar[i-1][j].color=color;
                    g.ar[i-1][j].player = player_no;
                    //transitionXleft(i-1,j,g.ar[i-1][j].color);
                    insertball(i-1,j,g.ar[i-1][j].color);
                    g.ar[i][j+1].currentsize+=1;
                    g.ar[i][j+1].color=color;
                    g.ar[i][j+1].player = player_no;
                   // transitionYdown(i,j+1,g.ar[i][j+1].color);
                    insertball(i,j+1,g.ar[i][j+1].color);
                    func(i-1,j,color,player_no);
                    func(i,j+1,color,player_no);

                }
                else if(i==g.row-1 && j==g.col-1)
                {
                    g.ar[i-1][j].currentsize+=1;
                    g.ar[i-1][j].color=color;
                    g.ar[i-1][j].player = player_no;
                    //transitionXleft(i-1,j,g.ar[i-1][j].color);
                    insertball(i-1,j,g.ar[i-1][j].color);
                    g.ar[i][j-1].currentsize+=1;
                    g.ar[i][j-1].color=color;
                    g.ar[i][j-1].player = player_no;
                  //  transitionYup(i,j-1,g.ar[i][j-1].color);
                    insertball(i,j-1,g.ar[i][j-1].color);
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
                   // transitionXright(i+1,j,g.ar[i+1][j].color);
                    insertball(i+1,j,g.ar[i+1][j].color);
                    g.ar[i][j-1].currentsize+=1;
                    g.ar[i][j-1].color=color;
                    g.ar[i][j-1].player = player_no;
                   // transitionYup(i,j-1,g.ar[i][j-1].color);
                    insertball(i,j-1,g.ar[i][j-1].color);
                    g.ar[i][j+1].currentsize+=1;
                    g.ar[i][j+1].color=color;
                    g.ar[i][j+1].player = player_no;
                   // transitionYdown(i,j+1,g.ar[i][j+1].color);
                    insertball(i,j+1,g.ar[i][j+1].color);
                    func(i+1,j,color,player_no);
                    func(i,j-1,color,player_no);
                    func(i,j+1,color,player_no);    
                }
                else if(i==g.row-1)
                {
                    g.ar[i-1][j].currentsize+=1;
                    g.ar[i-1][j].color=color;
                    g.ar[i-1][j].player = player_no;
                   // transitionXleft(i-1,j,g.ar[i-1][j].color);
                    insertball(i-1,j,g.ar[i-1][j].color);
                    g.ar[i][j-1].currentsize+=1;
                    g.ar[i][j-1].color=color;
                    g.ar[i][j-1].player = player_no;
                  //  transitionYup(i,j-1,g.ar[i][j-1].color);
                    insertball(i,j-1,g.ar[i][j-1].color);
                    g.ar[i][j+1].currentsize+=1;
                    g.ar[i][j+1].color=color;
                    g.ar[i][j+1].player = player_no;
                  //  transitionYdown(i,j+1,g.ar[i][j+1].color);
                    insertball(i,j+1,g.ar[i][j+1].color);
                    func(i-1,j,color,player_no);
                    func(i,j-1,color,player_no);
                    func(i,j+1,color,player_no);    
                }
                else if( j==0 )
                {
                    g.ar[i+1][j].currentsize+=1;
                    g.ar[i+1][j].color=color;
                    g.ar[i+1][j].player = player_no;
                 //   transitionXright(i+1,j,g.ar[i+1][j].color);
                    insertball(i+1,j,g.ar[i+1][j].color);
                    g.ar[i-1][j].currentsize+=1;
                    g.ar[i-1][j].color=color;
                    g.ar[i-1][j].player = player_no;
                  //  transitionXleft(i-1,j,g.ar[i-1][j].color);
                    insertball(i-1,j,g.ar[i-1][j].color);
                    g.ar[i][j+1].currentsize+=1;
                    g.ar[i][j+1].color=color;
                    g.ar[i][j+1].player = player_no;
                 //   transitionYdown(i,j+1,g.ar[i][j+1].color);
                    insertball(i,j+1,g.ar[i][j+1].color);
                    func(i+1,j,color,player_no);
                    func(i-1,j,color,player_no);
                    func(i,j+1,color,player_no);
                }
                else
                {
                    g.ar[i+1][j].currentsize+=1;
                    g.ar[i+1][j].color=color;
                    g.ar[i+1][j].player = player_no;
                 //   transitionXright(i+1,j,g.ar[i+1][j].color);
                    insertball(i+1,j,g.ar[i+1][j].color);
                    g.ar[i-1][j].currentsize+=1;
                    g.ar[i-1][j].color=color;
                    g.ar[i-1][j].player = player_no;
                 //   transitionXleft(i-1,j,g.ar[i-1][j].color);
                    insertball(i-1,j,g.ar[i-1][j].color);
                    g.ar[i][j-1].currentsize+=1;
                    g.ar[i][j-1].color=color;
                    g.ar[i][j-1].player = player_no;
                //    transitionYup(i,j-1,g.ar[i][j-1].color);
                    insertball(i,j-1,g.ar[i][j-1].color);
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
              //  transitionXright(i+1,j,g.ar[i+1][j].color);
                insertball(i+1,j,g.ar[i+1][j].color);
                g.ar[i-1][j].currentsize+=1;
                g.ar[i-1][j].color=color;
                g.ar[i-1][j].player = player_no;
              //  transitionXleft(i-1,j,g.ar[i-1][j].color);
                insertball(i-1,j,g.ar[i-1][j].color);
                g.ar[i][j-1].currentsize+=1;
                g.ar[i][j-1].color=color;
                g.ar[i][j-1].player = player_no;
              //  transitionYup(i,j-1,g.ar[i][j-1].color);
                insertball(i,j-1,g.ar[i][j-1].color);
                g.ar[i][j+1].currentsize+=1;
                g.ar[i][j+1].color=color;
                g.ar[i][j+1].player = player_no;
              //  transitionYdown(i,j+1,g.ar[i][j+1].color);
                insertball(i,j+1,g.ar[i][j+1].color);
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
        makecopy(g.cur,1);
        insert(x,y); 
        //System.out.println(g.ar[x][y].player); 
        print();
        //System.out.println(g.prev.count + " 11"); 
        System.out.println(g.count + " 21");
        System.out.println(g.cur.count + " 31");   
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
