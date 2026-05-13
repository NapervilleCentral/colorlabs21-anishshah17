
/**
 * Main program for the poster project collage.
 *
 * @author Anish Shah
 * @version 5/13/2026
 */
public class PosterProjectMain
{
    /**
     * Builds and displays the final collage.
     */
    public static void main(String[] args)
    {
        Picture lolla = new Picture("images/lolla.jpg");
        Picture verticalLolla = PosterProjectMethods.rotateRight(lolla);
        int pictureWidth = verticalLolla.getWidth();
        int pictureHeight = verticalLolla.getHeight();
        Picture canvas = new Picture("images/lollacanvas.jpg");

        PosterProjectMethods.copyToCanvas(verticalLolla, canvas, 0, 0);

        Picture mirroredLolla = new Picture(verticalLolla);
        PosterProjectMethods.mirrorVertical(mirroredLolla);
        PosterProjectMethods.copyToCanvas(mirroredLolla, canvas, pictureWidth, 0);

        Picture posterizedLolla = new Picture(verticalLolla);
        PosterProjectMethods.posterize(posterizedLolla, 4);
        PosterProjectMethods.copyToCanvas(posterizedLolla, canvas, pictureWidth * 2, 0);

        Picture sepiaLolla = new Picture(verticalLolla);
        PosterProjectMethods.sepiaTint(sepiaLolla);
        PosterProjectMethods.copyToCanvas(sepiaLolla, canvas, 0, pictureHeight);

        /*
        Picture edgeLolla = new Picture(verticalLolla);
        PosterProjectMethods.edgeDetection(edgeLolla, 20);
        PosterProjectMethods.copyToCanvas(edgeLolla, canvas, pictureWidth, pictureHeight);
        */

        Picture recursiveLolla = new Picture(pictureWidth, pictureHeight);
        PosterProjectMethods.recursiveScale(verticalLolla, recursiveLolla,
                                            0, 0, pictureWidth, pictureHeight, false);
        PosterProjectMethods.copyToCanvas(recursiveLolla, canvas, pictureWidth, pictureHeight);
        
        Picture negativeLolla = new Picture(verticalLolla);
        PosterProjectMethods.negate(negativeLolla);
        PosterProjectMethods.copyToCanvas(negativeLolla, canvas, pictureWidth * 2, pictureHeight);

        Picture neonPurpleLolla = new Picture(verticalLolla);
        PosterProjectMethods.colorReplacement(neonPurpleLolla, 0, pictureWidth, 0, pictureHeight,
                                              new java.awt.Color(35, 35, 45),
                                              new java.awt.Color(53, 32, 132),
                                              80);
        PosterProjectMethods.colorReplacement(neonPurpleLolla, 0, pictureWidth, 0, pictureHeight,
                                              new java.awt.Color(115, 95, 125),
                                              new java.awt.Color(157, 74, 214),
                                              75);
        PosterProjectMethods.colorReplacement(neonPurpleLolla, 0, pictureWidth, 0, pictureHeight,
                                              new java.awt.Color(220, 215, 205),
                                              new java.awt.Color(237, 178, 255),
                                              80);
        PosterProjectMethods.copyToCanvas(neonPurpleLolla, canvas, 0, pictureHeight * 2);

        Picture electricBlueLolla = new Picture(verticalLolla);
        PosterProjectMethods.colorReplacement(electricBlueLolla, 0, pictureWidth, 0, pictureHeight,
                                              new java.awt.Color(30, 35, 40),
                                              new java.awt.Color(12, 31, 73),
                                              80);
        PosterProjectMethods.colorReplacement(electricBlueLolla, 0, pictureWidth, 0, pictureHeight,
                                              new java.awt.Color(85, 105, 120),
                                              new java.awt.Color(28, 67, 125),
                                              80);
        PosterProjectMethods.colorReplacement(electricBlueLolla, 0, pictureWidth, 0, pictureHeight,
                                              new java.awt.Color(225, 220, 210),
                                              new java.awt.Color(130, 158, 205),
                                              80);
        PosterProjectMethods.copyToCanvas(electricBlueLolla, canvas, pictureWidth, pictureHeight * 2);

        Picture sunsetPopLolla = new Picture(verticalLolla);
        PosterProjectMethods.colorReplacement(sunsetPopLolla, 0, pictureWidth, 0, pictureHeight,
                                              new java.awt.Color(40, 45, 50),
                                              new java.awt.Color(120, 18, 78),
                                              80);
        PosterProjectMethods.colorReplacement(sunsetPopLolla, 0, pictureWidth, 0, pictureHeight,
                                              new java.awt.Color(90, 110, 75),
                                              new java.awt.Color(255, 37, 168),
                                              80);
        PosterProjectMethods.colorReplacement(sunsetPopLolla, 0, pictureWidth, 0, pictureHeight,
                                              new java.awt.Color(205, 175, 130),
                                              new java.awt.Color(255, 158, 218),
                                              85);
        PosterProjectMethods.copyToCanvas(sunsetPopLolla, canvas, pictureWidth * 2, pictureHeight * 2);

        canvas.write("images/lollacollage.jpg");
        canvas.explore();
    }
}
