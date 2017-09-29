 
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class Node implements Drawable{

private Boolean displayed = false;
private Boolean displayedlinks = false;
private int x_position = Integer.MIN_VALUE;
private int y_position = Integer.MIN_VALUE;
private Boolean infected = false;

private String name;
private ArrayList<Node> Neighbors;

    public int getX_position() {
        return x_position;
    }
    
    public void setX_position(int x_position) {
        this.x_position = x_position;
    }

    public int getY_position() {
        return y_position;
    }

    public void setY_position(int y_position) {
        this.y_position = y_position;
    }
    
    public ArrayList<Node> Getneighbors()
    {
        return this.Neighbors;
    }

    public String getName() {
        return name;
    }

    public Boolean isInfected() {
        return infected;
    }

    public void setInfected(Boolean infected) {
        this.infected = infected;
    }
    
    public Node(String name)
    {
        this.name = name;
        this.Neighbors = new ArrayList();
    }
    
    public void AddNeighbor(Node target)
    {
        this.Neighbors.add(target);
    }

    @Override
    public String toString() {
        return "name="+name;
    }
    
    public void DisplayNeighbors()
    {
        for(int i =0;i<this.Getneighbors().size();i++)
        {
            System.out.print(this.Getneighbors().get(i).name+",");
        }
    }

    @Override
    public void Draw(Graphics g) {
        
            if(this.x_position==Integer.MIN_VALUE && this.y_position==Integer.MIN_VALUE)
            {
             this.x_position= (int)(Math.random()*500);
             this.y_position= (int)(Math.random()*500);
            }
            
            if(this.infected)
            {
                g.setColor(Color.red);
            }
            else
            {
                g.setColor(Color.BLACK);
            }
            g.fillOval(x_position,y_position,30,30);  
            g.setColor(Color.BLACK);
            g.drawString(this.getName(),x_position,y_position);
            this.displayed =true;           
    }
    
    public void DrawLinksToNeighors(Graphics g) 
    {
        
            for(int i =0;i<this.Getneighbors().size();i++)
            {
                Node target = this.Getneighbors().get(i);
                g.drawLine(this.x_position+15,this.y_position+15,target.x_position+15,target.y_position+15); 
            }
    }
}