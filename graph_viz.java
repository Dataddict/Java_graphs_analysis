
import java.awt.Graphics;
import javax.swing.JPanel;

public class MygraphVisualisation extends JPanel{
 
private Graph randomgraph = new Graph(10);
 
    public MygraphVisualisation()
    {
        randomgraph.SetupRandomLinks(0.3f);
        randomgraph.DisplayAdjacencyList();
        this.repaint();
    }
    
    
    public void ResetGraph()
    {
        randomgraph = new Graph(10);
        randomgraph.SetupRandomLinks(0.3f);
        randomgraph.DisplayAdjacencyList();
        this.repaint();
    }
    
    public void ResetGraph(int number, float probability)
    {
        randomgraph = new Graph(number);
        randomgraph.SetupRandomLinks(probability);
        randomgraph.DisplayAdjacencyList();
        this.repaint();
    }
    
    public void DiffuseInfection(float probability)
    {
       randomgraph.Diffuseinfection(probability);
       this.removeAll();
       this.invalidate();
       this.repaint();
    }
    
    public void ResetInfection()
    {
       randomgraph.ResetInfection();
       this.removeAll();
       this.invalidate();
       this.repaint();
    }
    
    public void StartRandomInfection()
    {
        randomgraph.InfectRandomly();
        this.removeAll();
        this.invalidate();
        this.repaint();
    }
    
    public float GetInfectedRatio()
    {
        return randomgraph.getRatioofInfectedNodes();
    }
    
    @Override
    public void paint(Graphics g){
       randomgraph.Draw(g);
    }  
    
    @Override
    public void paintComponent(Graphics g){
       randomgraph.Draw(g);
    } 
}