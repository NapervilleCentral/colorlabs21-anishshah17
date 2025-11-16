
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
         //create array
         Pixel[] mePixels = me.getPixels();
         
         //shepard fairy color set
         Color darkBlue = new Color(0, 0, 100);       
         Color red = new Color(200, 30, 30);          
         Color lightBlue = new Color(120, 180, 255);  
         Color offWhite = new Color(249, 249, 210);  
         Color slateGrey = new Color(176,196,222);
        
         /**
          * method 1 change
          * 
          */

        me.explore();
        //loop that takes each pixel and sets it to a certain color
        for (Pixel p : mePixels) {
            int avg = (p.getRed() + p.getGreen() + p.getBlue()) / 3;
            //finds the average of the RGB values for sorting of darkest to lightest

            //takes the avg and based on the average of the RGB values it sets that pixel to a certain color from darkest to lightest
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
        me.write("images/anishdjfairymethod1.jpg");
        
        
       
         /**
          * method 2 change
          * 
          */
         int s = 255;
         int b = 0;
         //very similar to first method
         //in this method, it takes the average of the RGB value and finds the lowest and highest average in the photo

         for (Pixel m : mePixels) {
           int avg = ((m.getRed() + m.getGreen() + m.getBlue()) / 3);
           if (avg < s) {
              s = avg; 
           }
           if (avg > b) {
              b = avg; 
            }
           m.setRed(avg);
           m.setGreen(avg);
           m.setBlue(avg);
           
           //grayscales the image when displaying it
        }
        me.explore();
        
        System.out.println(s);
        System.out.println(b);
        
        double bucket = (b - s) / 5.0;
        //creates 5 buckets 

        
        for (Pixel i : mePixels) {
            int avg = (i.getRed() + i.getGreen() + i.getBlue()) / 3;
            
            //takes the average of the grayscale photo pixel and puts into a certain bucket assigningm it a certain color

            if (avg < (s + bucket)) {
                i.setColor(darkBlue);
            } 
            else if (avg < s + (2 * bucket)) {
                i.setColor(red);
            } 
            else if (avg < s + (3 * bucket)) {
                i.setColor(lightBlue);
            }
            else if (avg < s + (4 * bucket)) {
                i.setColor(slateGrey);
            }
            else {
                i.setColor(offWhite);
            }
            }   
    
        me.explore();
        me.write("images/anishdjfairymethod2.jpg");
        //writes and explores image using method 2 
        
        /**
          * custom color palette
          */
        Color navyBlue = new Color(6, 21, 5);
        Color hotPink = new Color(246, 38, 136);
        Color tan = new Color(255, 235, 175);
        Color purple = new Color(127, 0, 255);
        Color gWhite = new Color(245,255,250);
        //new color palette for customized image
        
        for (Pixel p : mePixels) {
        int r = p.getRed();
        int g = p.getGreen();
        int bl = p.getBlue();

        int bright = (r + g + bl) / 3; 
        
        
        //using same method as above, recieve RGB values from the pixel and average them
        //based on the brightness of the pixel, set it to a certain color

        if (bright < 51) {
            p.setColor(navyBlue);
        }
        else if (bright < 102) {
            p.setColor(purple);
        }
        else if (bright < 153) {
            p.setColor(hotPink);
        }
        else if (bright < 204) {
            p.setColor(tan);
        }
        else {
            p.setColor(gWhite);
        }
        
        
        
        
        
         
    }
    me.explore();
    me.write("images/anishdjSF1.jpg");
    
    //iteration 2
    //new colors
        //new colors, but using some of the ones from the last time
        Color navy = new Color(0, 0, 128);
        Color lime = new Color(0, 255, 0);        
        for (Pixel p : mePixels) {
        int r = p.getRed();
        int g = p.getGreen();
        int bl = p.getBlue();

        int bright = (r + g + bl) / 3; 

        if (bright < 51) {
            p.setColor(navy);
        }
        else if (bright < 102) {
            p.setColor(purple);
        }
        else if (bright < 153) {
            p.setColor(hotPink);
        }
        else if (bright < 204) {
            p.setColor(lime);
        }
        else {
            p.setColor(gWhite);
        }
        
        
        
        
        
         
    }
    me.explore();
    me.write("images/anishdjSF2.jpg");
    
    //iteration 3
    //new colors
    
    Color steel = new Color(25, 25, 30);
    Color brick = new Color(180, 60, 40);
    Color rustyBlue = new Color(110, 140, 170);
    Color gray = new Color(235, 240, 245);
    Color amber = new Color(235, 180, 60);
    
    
    for (Pixel d : mePixels) {
        int r = d.getRed();
        int g = d.getGreen();
        int bl = d.getBlue();

        int bright = (r + g + bl) / 3; 

        if (bright < 51) {
            d.setColor(steel);
        }
        else if (bright < 102) {
            d.setColor(brick);
        }
        else if (bright < 153) {
            d.setColor(rustyBlue);
        }
        else if (bright < 204) {
            d.setColor(amber);
        }
        else {
            d.setColor(gray);
        }
        
         
    }
    me.explore();
    me.write("images/anishdjfairySF3.jpg");
    
    //iteration 4
    //new Colors
    
    Color brightPurple = new Color(33, 6, 114);
    Color magenta = new Color(200, 40, 110);
    Color bOrange = new Color(255, 140, 60);
    Color solarYellow = new Color(255, 215, 90);
    Color cream = new Color(250, 235, 215);
    
    for (Pixel j : mePixels) {
        int r = j.getRed();
        int g = j.getGreen();
        int bl = j.getBlue();

        int bright = (r + g + bl) / 3; 

        if (bright < 51) {
            j.setColor(brightPurple);
        }
        else if (bright < 102) {
            j.setColor(magenta);
        }
        else if (bright < 153) {
            j.setColor(bOrange);
        }
        else if (bright < 204) {
            j.setColor(solarYellow);
        }
        else {
            j.setColor(cream);
        }
        
         
    }
    me.explore();
    me.write("images/anishdjfairySF4final.jpg");
    
  }
}//class
