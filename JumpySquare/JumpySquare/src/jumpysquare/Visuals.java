/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpysquare;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jake
 */
public class Visuals extends JPanel{
    Graphics g; //graphics for the squares
    JFrame frame; //legendary frame for the squares 
    /**
     * Constructor. Starts creating graphics 
     */
    public Visuals(){
        System.out.println("Wow I can see");
        frame = new JFrame();
        setFrame();
        
        
    }
    /**
     * paints all the graphics to the parent class(JPanel)
     * @param g the graphics. 
     */
    @Override 
    public void paintComponent(Graphics g) {
        this.g = g;
        super.paintComponent(g);
        
        
        
    }

    private void setFrame() {
        frame.setVisible(true);
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(this);
    }
}
