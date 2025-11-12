
/**
 * Anish Shah
 * AP Computer Science
 * 11/11/2025
 * Notes + ColorLabs
 * ColorLabs: take images and (adjust the RGB values by a factor, grayscale, negate the picture, lighten the picture (and darken), change RGB values by a number, blueify and colorify (to colors of your face))
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class TestPicture17
{

    /**
     * main method, to test the picture
     *
     */
  public static void main(String[] args)
  {
      //opens picture using a dialog box
      /*
     String fileName = FileChooser.pickAFile();
     Picture pictObj = new Picture(fileName);
     pictObj.explore(); */

     //opens a pictue using a path
     //Picture apic = new Picture("C:\\Users\\khayes\\Favorites\\Documents\APCS- Java\chap03\Curriclum 2013\Picture Color labs\images\\beach.jpg");
     
     //relative path
     //KNOW THIS - ON TEST
     //                          folder/file
     //lab 6 (colorify)
     Picture beach = new Picture("images/beach.jpg");
     
     Picture ferris1 = new Picture("images/2000 ferris wheel2.jpg");
     Picture moto = new Picture("images/redMotorcycle.jpg");
     Picture ferris3 = new Picture("images/2000 ferris wheel2.jpg");
     //lab 1
     Picture shrine = new Picture("images/femaleLionAndHall.jpg");
     //lab 6 (blueify)
     Picture swan = new Picture("images/swan.jpg");
     //lab 2 
     Picture temple = new Picture("images/temple.jpg");
     //lab 5
     Picture mark = new Picture("images/blue-mark.jpg");
     //lab 4 (lighten/darken)
     Picture gorge = new Picture("images/gorge.jpg");
     //lab 3
     Picture koala = new Picture("images/koala.jpg");
     

     //beach.explore();
     moto.explore();
     ferris1.explore();
     //displays the picture
     
     //makes an array of pixels
     //NOT ON TEST - arrays specfically
     Pixel[] pixels;
     //gets pixels from picture and assigns to pixels array
     pixels = ferris1.getPixels();
     //gets ALL pixles
     
     Pixel[] mpixels;
     mpixels = moto.getPixels();
     //lab 1
     Pixel [] spixels;
     spixels = shrine.getPixels();
     //lab 6 (blueify)
     Pixel [] swpixels;
     swpixels = swan.getPixels();
     //lab 2
     Pixel [] tpixels;
     tpixels = temple.getPixels();
     //lab 5
     Pixel [] markpixels;
     markpixels = mark.getPixels();
     //lab 4 (lighten + darken)
     Pixel [] gopixels;
     gopixels = gorge.getPixels();
     //lab 3
     Pixel [] kpixels;
     kpixels = koala.getPixels();
     //lab 6 (colorify)
     Pixel [] bpixels;
     bpixels = beach.getPixels();
    
     //how many pixels or how large array
    System.out.println("This is a large array"+pixels.length  );


    /**/
        //access each index
    System.out.println(pixels[17]);
    //access each pixel
    // you can use get pixel to get a pixel at a specific spot
    Pixel spot = ferris1.getPixel(100,100);
    Pixel spot2 = ferris1.getPixel(433,281);
    Pixel ferr17 = pixels[17];
    
    ferr17.setRed(240);
    ferr17.setGreen(160);
    ferr17.setBlue(200);
    
    Color newColor = new Color(70,130,180);
    
    spot2.setColor(Color.blue);
    spot.setColor(newColor);
    
    
    ferris1.explore();
    //you have to explore it to see changes
    
    //all 0 is black
    //all 255 is white
    System.out.println(pixels[17].getColor());
    System.out.println(spot);
    
    for(int i = 0; i<10000; i++) {
        Pixel yuck  = ferris1.getPixel((int)(Math.random()*500), (int)(Math.random()*500));
        yuck.setColor(newColor);
    }
    ferris1.explore();
    
 /*
    pixels[17].setColor(Color.blue);
    spot.setColor(new Color(252,252,252));
    pixels[500034].setColor(Color.blue);

    ferris1.explore();
/**/
   // loop to access indexes of array or collection

    //for each loop spot  is a ?
    
    
    
    
    
    
    //
    /*
    int red;
    int blue;
    int green;
    for (Pixel spot1: mpixels){
        //System.out.println( spot );
        red = spot1.getRed();
        
        red = (int)(red * .25);
        
        spot1.setRed(red);
        
    }
    
    
    for (Pixel spot3: mpixels){
        blue = spot3.getBlue();
        
        blue = (int)(blue * Math.random());
        
        spot3.setBlue(blue);
    }

    for (Pixel spot4: mpixels){
        green = spot4.getGreen();
        
        green = (int)(green * Math.random());
        
        spot4.setGreen(green);
    }
    moto.explore();
    /**/
    
    
    //Lab 1
    //adjusting Red, Green and Blue
    int reds;
    int blues;
    int greens;
    for (Pixel spot5: spixels){
        //System.out.println( spot );
        reds = spot5.getRed();
        blues = spot5.getBlue();
        greens = spot5.getGreen();
        
        reds = (int)(reds * .5);
        blues = (int)(blues * .25);
        greens = (int)(greens * 1.5);
        
        spot5.setRed(reds);
        spot5.setBlue(blues);
        spot5.setGreen(greens);
        
        
    }
    shrine.explore();
    //this writes a copy of the picture to the folder
    //have to rename picture!!
    shrine.write("images/shrinergb.jpg");
    
    //lab 2
    //"negate the picture", make the RGB values opposite
    for (Pixel t : tpixels) {
      t.setRed(255 - t.getRed());
      t.setGreen(255 - t.getGreen());
      t.setBlue(255 - t.getBlue());
    }
    temple.explore();
    
    //lab 3
    //grayscale
    for (Pixel k : kpixels) {
      int avg = ((k.getRed() + k.getGreen() + k.getBlue()) / 3);
      k.setRed(avg);
      k.setGreen(avg);
      k.setBlue(avg);
    }
    koala.explore();
    
    //lab 4 (lighten)
    for (Pixel g : gopixels) {
      int r = (int)(g.getRed() * 1.2);
      int gr = (int)(g.getGreen() * 1.2);
      int b = (int)(g.getBlue() * 1.2);
      //loops incase exceeds rgb values
      if (r > 255) {
        r = 255;
      }
      if (gr > 255) {
        gr = 255; 
      }
      if (b > 255){
        b = 255; 
      }

      g.setRed(r);
      g.setGreen(gr);
      g.setBlue(b);
    }
    gorge.explore();
    
    //lab 4 (darken)
    for (Pixel g : gopixels) {
      int r = (int)(g.getRed() * 0.6);
      int gr = (int)(g.getGreen() * 0.6);
      int b = (int)(g.getBlue() * 0.6);
      g.setRed(r);
      g.setGreen(gr);
      g.setBlue(b);
    }
    gorge.explore();
    
    //lab 5
    //change red green and blue by some amount (ex: -50, 100)
for (Pixel m : markpixels) {
    int redAmount = -50; 
    int greenAmount = 100; 
    int blueAmount = 60;  
    
    int r = m.getRed() + redAmount;
    int g = m.getGreen() + greenAmount;
    int b = m.getBlue() + blueAmount;

    //double check loops to make sure RGB values don't exceed 255 or go below 0
    if (r > 255) {
      r = 255;
    }
    if (g > 255) {
      g = 255;
    }
    if (b > 255) {
      b = 255;
    }
    if (r < 0) {
      r = 0;
    }
    if (g < 0) {
      g = 0; 
    }
    if (b < 0) {
      b = 0;
    }
    m.setRed(r);
    m.setGreen(g);
    m.setBlue(b);
}
mark.explore();
    //lab 6 (blueify)
    for (Pixel s : swan.getPixels()) {
      int r = (int)(s.getRed() * 0.5);
      int g = (int)(s.getGreen() * 0.5);
      int b = (int)(s.getBlue() * 1.8);
      
      //safe measure to make sure blue doesn't exceed 255
      if (b > 255) {
        b = 255;
      }

      s.setRed(r);
      s.setGreen(g);
      s.setBlue(b);
    }
    swan.explore();
    
    //lab 6 (colorify -  to colors similar to my face)
    for (Pixel b : beach.getPixels()) {
      int r = b.getRed();
      int g = b.getGreen();
      int be = b.getBlue();

      //change overall colors to purple if exceeding these values
      if (r < 150 && g < 180 && be > 150) {
        b.setRed(200);
        b.setGreen(50);
        b.setBlue(200);
      }
    }
    beach.explore();
 /**/

 /**
  * Method to clear red from picture
  * @param none
  * @return none
  */
 /*
    for (Pixel pixelObj : pixels)
        {
            //set the red value of the current pixel to the new value
           

        }
    ferris1.explore();
    
/**/
 /**
  * Method to reduce red from picture by a factor of n
  * @param none
  * @return none
  */

/*
int value;
final double  FACTOR = .5;
    for (Pixel pixelObj : pixels)
    {

        //get the redvalue
        value = pixelObj.getRed();
        //System.out.println(value);

        //decrease the red value by 50%
        
        //set the red value of the current pixel to the new value
        

    }
    // use new picture when changing or it will make changes to 
    // pic you already changed
    ferris1.explore();
    ferris2.explore();

  /**/ 
    //write/save a picture as a file
    ferris1.write("images/ferris11.jpg");

    /**/
  }//main
}//class
