/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpysquare;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;

/**
 *
 * @author Jake
 */
public class Intro extends Visuals {
    int angle = 0;
    boolean done = false;
    int length = 50;
    int width = 50;
    int roundCounter = 0;
    Rectangle spinnySquare = new Rectangle();
    int squareX = 0;
    int squareY = 0;
    JButton start = new JButton("Start");

    public Intro() {
        System.out.println("intro");
        timer();
    }

    public void timer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                loop();
            }

        }, 0, 30);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 

        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font("TimesRoman", Font.PLAIN, 50));

        
///https://stackoverflow.com/questions/18860700/rotating-the-rectangle-object-in-java
        g2d.translate(spinnySquare.x + spinnySquare.getWidth()/2, spinnySquare.y + spinnySquare.getHeight() / 2);
        g2d.rotate(angle * Math.PI / 360);
        g2d.translate(-spinnySquare.x - spinnySquare.getWidth()/2, -spinnySquare.y - spinnySquare.getHeight() / 2);
        // end of stack overflow code
        
        if(done){
         
            g2d.drawString("Jumpy Square!", 175, 150);
        }
        g2d.fill(spinnySquare);
        
    }
    
   
    public void loop() {
        //Changes the vertical Position of the square///////////////////////
        if (spinnySquare.y < 350) {
            spinnySquare.y += 5;
        }
        //Changes the horizontal position of the Square/////////////////////
        if (roundCounter == 0) {
            if (spinnySquare.x <= frame.getWidth()) {
                spinnySquare.x += 25;
            } else {
                roundCounter++;
            }
        } else if (roundCounter == 1) {
            if (spinnySquare.x >= 0) {
                spinnySquare.x -= 25;
            } else {
                roundCounter++;
            }
        } else if (roundCounter == 2) {
            
            if(spinnySquare.x < 135){
                spinnySquare.x += 10;
            }
            done = true;
          
        }
        //Changes the size of the square////////////////////////////////////
        if (spinnySquare.width < 400) {
            spinnySquare.width += 5;
            spinnySquare.height += 5;
        }
        //puts square on center of screen//////////////////////////////////
        if(done){
            angle+=10; 
        }
        else{
             angle+=5;
        }
       //Animation Complete////////////////////////////////////////////////
        repaint(); // repaints the canvas to apply changes
    }


}
