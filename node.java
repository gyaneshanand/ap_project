import java.io.*;

public class node implements Serializable
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