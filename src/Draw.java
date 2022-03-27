
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
public class Draw extends JFrame {
    public Draw(){
        setTitle("p5Younouss_T");
        setSize(700, 500);
        Container contentPane = getContentPane();    
        ButtonGroup buttonGroup = new ButtonGroup();
        red = new JRadioButton("RED",true); 
        blue = new JRadioButton("BLUE"); 
        green = new JRadioButton("GREEN"); 
        yellow = new JRadioButton("YELLOW");    
        buttonGroup.add(red);
        buttonGroup.add(blue);
        buttonGroup.add(green);
        buttonGroup.add(yellow); 
        clear = new JButton("CLEAR");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(clear);
        JPanel radioPanel = new JPanel();
        radioPanel.setBorder(BorderFactory.createTitledBorder("Pick a color"));
        radioPanel.add(red);
        radioPanel.add(blue);
        radioPanel.add(green);
        radioPanel.add(yellow);      
        contentPane.add(radioPanel,"North");
        contentPane.add(buttonPanel,"South");
        canvas =new DrawPanel();
        contentPane.add(canvas,"Center");
        canvas.addMouseListener(new MouseObserver());
        ActionListener buttonObserver = new ButtonObserver();      
        red.addActionListener(buttonObserver);
        blue.addActionListener(buttonObserver);     
        green.addActionListener(buttonObserver);    
        yellow.addActionListener(buttonObserver);     
        clear.addActionListener(buttonObserver);       
    }
    class ButtonObserver implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {    
           Object source = e.getSource();            
            if(source == red){
                stringColor = "red";
            }
            if(source == blue){      
                stringColor = "blue";
            }
            if(source == green){                
                stringColor = "green";
            }            
            if(source == yellow){               
                stringColor = "yellow";
            }  
            if(source == clear){
                redEllipse.clear();
                blueEllipse.clear();           
                greenEllipse.clear();  
                yellowEllipse.clear();           
                redLine1.clear();
                blueLine1.clear();
                greenLine1.clear();
                yellowLine1.clear();  
                redLine2.clear();
                blueLine2.clear();
                greenLine2.clear();
                yellowLine2.clear();         
                redLine3.clear();
                blueLine3.clear();
                greenLine3.clear();
                yellowLine3.clear();  
                canvas.repaint();
            }
        }
    }
    class MouseObserver implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {

        }

        @Override
        public void mousePressed(MouseEvent me) {
            count++;
            if(count == 1){
                if(stringColor == "red"){
                    redEllipse.add(new Ellipse2D.Double(me.getX(),me.getY(),3,3));
                    ellipseColor = "red";
                }
                if(stringColor == "blue"){
                    blueEllipse.add(new Ellipse2D.Double(me.getX(),me.getY(),3,3));
                    ellipseColor = "blue";
                }        
                if(stringColor == "green"){
                    greenEllipse.add(new Ellipse2D.Double(me.getX(),me.getY(),3,3));
                    ellipseColor = "green";
                } 
                if(stringColor == "yellow"){
                    yellowEllipse.add(new Ellipse2D.Double(me.getX(),me.getY(),3,3));
                    ellipseColor = "yellow";
                }                
            }
            if(count == 2){          
                point.add(new Point(me.getX(),me.getY()));
                if(ellipseColor == "red"){
                    redLine1.add(new Line2D.Double(redEllipse.get(redEllipse.size() - 1).getX(),redEllipse.get(redEllipse.size() - 1).getY(),point.get(point.size() - 1).getX(),point.get(point.size() - 1).getY()));            
                }
                if(ellipseColor == "blue"){
                    blueLine1.add(new Line2D.Double(blueEllipse.get(blueEllipse.size() - 1).getX(),blueEllipse.get(blueEllipse.size() - 1).getY(),point.get(point.size() - 1).getX(),point.get(point.size() - 1).getY()));            
                }         
                if(ellipseColor == "green"){
                    greenLine1.add(new Line2D.Double(greenEllipse.get(greenEllipse.size() - 1).getX(),greenEllipse.get(greenEllipse.size() - 1).getY(),point.get(point.size() - 1).getX(),point.get(point.size() - 1).getY()));            
                }
                if(ellipseColor == "yellow"){
                    yellowLine1.add(new Line2D.Double(yellowEllipse.get(yellowEllipse.size() - 1).getX(),yellowEllipse.get(yellowEllipse.size() - 1).getY(),point.get(point.size() - 1).getX(),point.get(point.size() - 1).getY()));            
                }                             
            }
            if(count == 3){
                if(ellipseColor == "red"){                
                    redLine2.add(new Line2D.Double(redEllipse.get(redEllipse.size() - 1).getX(),redEllipse.get(redEllipse.size() - 1).getY(),me.getX(),me.getY()));
                    redLine3.add(new Line2D.Double(point.get(point.size() - 1).getX(),point.get(point.size() - 1).getY(),me.getX(),me.getY()));                
                }
                if(ellipseColor == "blue"){                
                    blueLine2.add(new Line2D.Double(blueEllipse.get(blueEllipse.size() - 1).getX(),blueEllipse.get(blueEllipse.size() - 1).getY(),me.getX(),me.getY()));
                    blueLine3.add(new Line2D.Double(point.get(point.size() - 1).getX(),point.get(point.size() - 1).getY(),me.getX(),me.getY()));                 
                }  
                if(ellipseColor == "green"){                
                    greenLine2.add(new Line2D.Double(greenEllipse.get(greenEllipse.size() - 1).getX(),greenEllipse.get(greenEllipse.size() - 1).getY(),me.getX(),me.getY()));
                    greenLine3.add(new Line2D.Double(point.get(point.size() - 1).getX(),point.get(point.size() - 1).getY(),me.getX(),me.getY()));                
                }
                if(ellipseColor == "yellow"){                
                    yellowLine2.add(new Line2D.Double(yellowEllipse.get(yellowEllipse.size() - 1).getX(),yellowEllipse.get(yellowEllipse.size() - 1).getY(),me.getX(),me.getY()));
                    yellowLine3.add(new Line2D.Double(point.get(point.size() - 1).getX(),point.get(point.size() - 1).getY(),me.getX(),me.getY()));                 
                }   
                count = 0;
            }
            canvas.repaint();
        }

        @Override
        public void mouseReleased(MouseEvent me) {

        }

        @Override
        public void mouseEntered(MouseEvent me) {

        }

        @Override
        public void mouseExited(MouseEvent me) {
  
        }

    } 
    private class DrawPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;          
              if(count == 1){
                  if(stringColor == "red"){
                      g2.setColor(java.awt.Color.red);
                      g2.draw(redEllipse.get(redEllipse.size()-1));
                      g2.fill(redEllipse.get(redEllipse.size()-1));                    
                  }
                  if(stringColor == "blue"){
                      g2.setColor(java.awt.Color.blue);                    
                      g2.draw(blueEllipse.get(blueEllipse.size()-1));
                      g2.fill(blueEllipse.get(blueEllipse.size()-1));                    
                  }
                  if(stringColor == "green"){
                      g2.setColor(java.awt.Color.green);                       
                      g2.draw(greenEllipse.get(greenEllipse.size()-1));
                      g2.fill(greenEllipse.get(greenEllipse.size()-1));                    
                  }      
                  if(stringColor == "yellow"){
                      g2.setColor(java.awt.Color.yellow);                        
                      g2.draw(yellowEllipse.get(yellowEllipse.size()-1));
                      g2.fill(yellowEllipse.get(yellowEllipse.size()-1));                    
                  }                  
              }          
              for (Line2D l1 :  redLine1) {              
                  g2.setColor(java.awt.Color.red);               
                  g2.draw(l1);
              }  
              for (Line2D l1 :  blueLine1) {              
                  g2.setColor(java.awt.Color.blue);                
                  g2.draw(l1);
              } 
              for (Line2D l1 :  greenLine1) {              
                  g2.setColor(java.awt.Color.green);                    
                  g2.draw(l1);
              }                      
              for (Line2D l1 :  yellowLine1) {              
                  g2.setColor(java.awt.Color.yellow);                     
                  g2.draw(l1);
              }                        
              for (Line2D l2 :  redLine2) {                  
                  g2.setColor(java.awt.Color.red);                
                  g2.draw(l2);
              }  
              for (Line2D l2 :  blueLine2) {                  
                  g2.setColor(java.awt.Color.blue);                    
                  g2.draw(l2);
              }
              for (Line2D l2 :  greenLine2) {                  
                  g2.setColor(java.awt.Color.green);                     
                  g2.draw(l2);
              }   
              for (Line2D l2 :  yellowLine2) {                  
                  g2.setColor(java.awt.Color.yellow);                  
                  g2.draw(l2);
              }                      
              for (Line2D l3 :  redLine3) {                 
                  g2.setColor(java.awt.Color.red);               
                  g2.draw(l3);
              }
              for (Line2D l3 :  blueLine3) {                 
                  g2.setColor(java.awt.Color.blue);                   
                  g2.draw(l3);                
              } 
              for (Line2D l3 :  greenLine3) {                 
                  g2.setColor(java.awt.Color.green);                     
                  g2.draw(l3);       
              }
              for (Line2D l3 :  yellowLine3) {                 
                  g2.setColor(java.awt.Color.yellow);                  
                  g2.draw(l3);              
              }
        }
    }
    int count = 0;
    DrawPanel canvas;  
    JRadioButton red,blue,green,yellow;    
    JButton clear;    
    ArrayList<Ellipse2D.Double> redEllipse = new ArrayList();   
    ArrayList<Line2D.Double> redLine1 = new ArrayList();
    ArrayList<Line2D.Double> redLine2 = new ArrayList();
    ArrayList<Line2D.Double> redLine3 = new ArrayList();  
    ArrayList<Ellipse2D.Double> blueEllipse = new ArrayList();   
    ArrayList<Line2D.Double> blueLine1 = new ArrayList();
    ArrayList<Line2D.Double> blueLine2 = new ArrayList();
    ArrayList<Line2D.Double> blueLine3 = new ArrayList();    
     ArrayList<Ellipse2D.Double> greenEllipse = new ArrayList();   
    ArrayList<Line2D.Double> greenLine1 = new ArrayList();
    ArrayList<Line2D.Double> greenLine2 = new ArrayList();
    ArrayList<Line2D.Double> greenLine3 = new ArrayList();      
    ArrayList<Ellipse2D.Double> yellowEllipse = new ArrayList();   
    ArrayList<Line2D.Double> yellowLine1 = new ArrayList();
    ArrayList<Line2D.Double> yellowLine2 = new ArrayList();
    ArrayList<Line2D.Double> yellowLine3 = new ArrayList();        
    ArrayList<Point> point = new ArrayList();   
    Color color;
    String stringColor = "red",ellipseColor;
}
