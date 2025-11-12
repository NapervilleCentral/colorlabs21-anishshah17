
/**
 * Anish Shah
 * AP Computer Science
 * 11/11/2025
 * ShepardFairyLab
 * taking an image, change the colors following the different method instructions listed below, to change an image's color palette
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

public class SheparFaireyLab
{
    /**
     * main method, to test the picture
     *  
     */
    public static void main(String[] args)
    {
        //method 1 - balanced approach
        //divide up rgb ranges from 0-255
         //4 diff buckets
         //1st bucket - darkest (dark blue)
         //2nd bucket - not as dark (red)
         //3rd bucket - somewhat light (light blue)
         //4th bucket - off white( light)
         
         //method 2 - intense approach
         //take the smallest and biggest rgb value 
         //once you have those values, then divide that up into 4 equal buckets
         //then the smallest group, group 1 and group 2 and so on..
         //will follow the rule of
         //1st bucket - darkest (dark blue)
         //2nd bucket - not as dark (red)
         //3rd bucket - somewhat light (light blue)
         //4th bucket - off white( light)
         
         //method 3 - a different set of colors
         //choose your own color palette and refine the color palette until it looks like how you want it
         //continue to refine the color choices and get feedback from peers
         //save images as you go, and try to find the best color palette
         
         
         //opens selfie picture 
          /**/
         //String fileName = FileChooser.pickAFile();
         //Picture pictObj = new Picture(fileName);
         //pictObj.explore();
         
         //relative path
         Picture apic = new Picture("images\\beach.jpg");
         //change with selfie picture
         Picture me = new Picture("images/IMG_0890.jpg");
         Picture me1 = new Picture("images/beach.jpg");
         Picture me2 = new Picture("images/beach.jpg");
         
         /**
          * method 1 change
          * 
          */
        Pixel[] mePixels = me.getPixels();

        Color darkBlue = new Color(0, 0, 100);       
        Color red = new Color(200, 30, 30);          
        Color lightBlue = new Color(120, 180, 255);  
        Color offWhite = new Color(249, 249, 210);   
        me.explore();
        for (Pixel p : mePixels) {
            int avg = (p.getRed() + p.getGreen() + p.getBlue()) / 3;

            
            if (avg < 64) {
                p.setColor(darkBlue);
            } else if (avg < 128) {
                p.setColor(red);
            } else if (avg < 192) {
                p.setColor(lightBlue);
            } else {
                p.setColor(offWhite);
            }
        }

        me.explore();
        me.write("images/anishdjfairy.jpg");
         /**
          * method 2 change
          * 
          */
         
         /**
          * custom color palette
          */
        Color navyBlue = new Color(6, 21, 5);
        Color hotPink = new Color(246, 38, 136);
        Color tan = new Color(255, 235, 175);
        Color purple = new Color(127, 0, 255);
        
        
        
         
    }//main       
}//class
