/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introduccion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author roban
 */
public class TestBuffer extends JPanel{
    
    
    public void paint(Graphics g) {
      Image img = dibujarFigura();
      g.drawImage(img, 20,20,this);
   }
    
    private Image createImageWithText() {
      BufferedImage bufferedImage = new BufferedImage(200,200,BufferedImage.TYPE_INT_RGB);
      Graphics g = bufferedImage.getGraphics();

      g.drawString("A", 20,20);
      //g.drawString("www.tutorialspoint.com", 20,40);
      //g.drawString("www.tutorialspoint.com", 20,60);
      //g.drawString("www.tutorialspoint.com", 20,80);
      //g.drawString("www.tutorialspoint.com", 20,100);
      
      return bufferedImage;
   }
    
   private Image dibujarFigura(){
   
      BufferedImage bufferedImage = 
              new BufferedImage(200,200,
                      BufferedImage.TYPE_INT_RGB);
      //Graphics g = bufferedImage.getGraphics();
      // 255,0,228
      Color color = new Color(255,0,228);
      for(int x=25; x<50;x++){
          for(int y=15;y<50;y++){
              bufferedImage.setRGB(x, y, color.getRGB());
          }
      }
      return bufferedImage;
   }

    
    
     public static void main(String[] args) {
         JFrame frame = new JFrame();
      frame.getContentPane().add(new TestBuffer());

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(200, 200);
      frame.setVisible(true);
   }

}
