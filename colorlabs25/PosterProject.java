
/**
 * Anish Shah
 * 5/7/2026
 * AP Computer Science
 * Poster Project
 * Creates a collage of images that all are edited in different ways
 */
public class PosterProject
{
    public static void copyToCanvas(Picture source, Picture target, int startX, int startY)
    {
        Pixel sourcePix = null;
        Pixel targetPix = null;

        for (int sourceX = 0, targetX = startX;
             sourceX < source.getWidth() && targetX < target.getWidth();
             sourceX++, targetX++)
        {
            for (int sourceY = 0, targetY = startY;
                 sourceY < source.getHeight() && targetY < target.getHeight();
                 sourceY++, targetY++)
            {
                sourcePix = source.getPixel(sourceX, sourceY);
                targetPix = target.getPixel(targetX, targetY);
                targetPix.setColor(sourcePix.getColor());
            }
        }
    }

    public static void mirrorVertical(Picture apic)
    {
        int width = apic.getWidth();
        int mirrorPoint = width / 2;
        Pixel leftPixel = null;
        Pixel rightPixel = null;

        for (int y = 0; y < apic.getHeight(); y++)
        {
            for (int x = 0; x < mirrorPoint; x++)
            {
                leftPixel = apic.getPixel(x, y);
                rightPixel = apic.getPixel(width - 1 - x, y);
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
    public static void main(String[] args)
    {
        int clearance = 200;
        Picture lolla = new Picture("images/lolla.jpg");
        int pictureWidth = lolla.getWidth();
        int pictureHeight = lolla.getHeight();
        Picture canvas = new Picture("images/lollacanvas.jpg");

        copyToCanvas(lolla, canvas, 0, 0);

        Picture mirroredLolla = new Picture(lolla);
        mirrorVertical(mirroredLolla);
        //copyToCanvas(mirroredLolla, canvas, pictureWidth + clearance, 0);
        copyToCanvas(mirroredLolla, canvas, pictureWidth, 0);

        canvas.write("images/lollacollage.jpg");
        canvas.explore();
    }
}
