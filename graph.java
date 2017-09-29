import java.awt.Graphics;
import java.util.ArrayList;

public class Graph implements Drawable{

private ArrayList<Node> listofnodes = new ArrayList<>(); 

    public Graph(int size)
    {
        for(int i=0;i<size;i++)
        {
            Node n = new Node(String.valueOf(i));
            this.listofnodes.add(n);
        }  
    }
    
    /**
        Create links between the nodes of the graph  
        @param probability the probability to create a link
    */
    public void SetupRandomLinks(float probability)
    {
        for(int i=0;i<listofnodes.size()-1;i++)
        {
            Node source = this.listofnodes.get(i);
            
            for(int j=i+1;j<listofnodes.size();j++)
            {
                if(Math.random()<probability)
                {
                    Node target = this.listofnodes.get(j);
                    source.AddNeighbor(target);
                }
            }
        }
    }
    
    /**
        Infect one of the nodes randomly. 
        * This serves as an initialisation of an infection 
    */
    public void InfectRandomly()
    {
        /*
        Place code to infect a random node here
        */
    }
    
   
    /**
        Diffuse an infection in the   
        @param probability the probability to infect neighbors
    */
    public void Diffuseinfection(float probability)
    {
        /*
        Place code to diffuse infection in graph here
        
        When diffuse infection is called every infected node can infect any of its neighbor with probability
        given.
        */
    }
    
    /**
        Desinfect any of the graph node   
     */
    public void ResetInfection()
    {
    }
    /**
        Get percentage of infected nodes 
        @return ratio of infected nodes.
    */
    public float getRatioofInfectedNodes()
    {
        //Place code here
        return 0.0f;
    } 
    
    public void DisplayList()
    {
        for(int i=0;i<listofnodes.size();i++)
        {
           System.out.println(this.listofnodes.get(i).getName());
        }
    }
    
    public void DisplayAdjacencyList()
    {
        for(int i=0;i<listofnodes.size();i++)
        {
           System.out.print(this.listofnodes.get(i).getName()+" : ");
           this.listofnodes.get(i).DisplayNeighbors();
           System.out.println();
        }
    }

    @Override
    public void Draw(Graphics g) 
    {
       for(int i=0;i<this.listofnodes.size();i++)
       {
            this.listofnodes.get(i).Draw(g);
       }
       
       for(int i=0;i<this.listofnodes.size();i++)
       {
           this.listofnodes.get(i).DrawLinksToNeighors(g);
       }
    }
}