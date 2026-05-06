import java.awt.*;
import java.util.*;
import java.util.List; 
/**
 * Write a description of class posterSample5 here.
 * 1 Copyed orginal]
 * 2 Mirror
 * 
 * @author (Mr. Hayes) 
 * @version (Poster Project May 23)
 */
public class posterSample5
{
  public static void main(String[] args)
  {
      
     Picture apic = new Picture("images\\KatieFancy.jpg");
     Picture canvas = new Picture("images\\poster5.jpg");
      //makes an array of pixels--GIVEN YOU NEED THIS
     Pixel[] pixels;
     //gets pixels from picture and assigns to pixels array
     pixels = apic.getPixels();//GET ALL THE PIXELS
     
    for (Pixel spot : pixels)
    {
        //System.out.println( spot );
        spot.setRed((int)(spot.getRed() *.1));
     

     
    }
    apic.explore();//method - does something
    
    copyKatie(apic,canvas);
    canvas.explore();
   }
  
   /**
    * copy from source to target
    * position of int x, y for placement on the target
    */
   
   public static void copyKatie( Picture sourcePic, Picture targetPic)
   {
       Pixel sourcePix = null;
       Pixel targetPix = null;
       
       //width of the source must be <= to the canvas I am 
       //going to copy to
       
       for (int sourceX = 0, targetX = 100;
            sourceX<sourcePic.getWidth();
            sourceX++, targetX ++)
            {
            
            for (int sourceY = 0, targetY = 100;
            sourceY<sourcePic.getHeight();
            sourceY++, targetY ++)
            {
                //set the target pix color of the source pix
                sourcePix = sourcePic.getPixel(sourceX,sourceY);
                targetPix = targetPic.getPixel(targetX,targetY);
                targetPix.setColor(sourcePix.getColor());
            }//loop
        }//loop
       
       
       
    }//end of copyKatie
   
   
   
   
}
