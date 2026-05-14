
/**
 * Anish Shah
 * 5/14/2026
 * AP Computer Science
 * Poster ProjectMethods
 * Creates a collage of images that all are edited in different ways (methods)
 */
public class PosterProjectMethods
{
    public static Picture rotateRight(Picture source)
    {
        Picture target = new Picture(source.getHeight(), source.getWidth());

        for (int x = 0; x < source.getWidth(); x++)
        {
            for (int y = 0; y < source.getHeight(); y++)
            {
                Pixel sourcePix = source.getPixel(x, y);
                Pixel targetPix = target.getPixel(source.getHeight() - 1 - y, x);
                targetPix.setColor(sourcePix.getColor());
            }
        }

        return target;
    }

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

    public static void posterize(Picture apic, int levels)
    {
        Pixel pixel = null;
        int step = 256 / levels;

        for (int x = 0; x < apic.getWidth(); x++)
        {
            for (int y = 0; y < apic.getHeight(); y++)
            {
                pixel = apic.getPixel(x, y);
                pixel.setRed(posterizeValue(pixel.getRed(), step));
                pixel.setGreen(posterizeValue(pixel.getGreen(), step));
                pixel.setBlue(posterizeValue(pixel.getBlue(), step));
            }
        }
    }

    public static int posterizeValue(int value, int step)
    {
        int newValue = (value / step) * step + step / 2;

        if (newValue > 255)
        {
            newValue = 255;
        }

        return newValue;
    }

    public static void sepiaTint(Picture apic)
    {
        Pixel pixel = null;

        for (int x = 0; x < apic.getWidth(); x++)
        {
            for (int y = 0; y < apic.getHeight(); y++)
            {
                pixel = apic.getPixel(x, y);
                int average = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
                int red = average;
                int green = average;
                int blue = average;

                if (average < 60)
                {
                    red = (int)(average * 0.9);
                    green = (int)(average * 0.8);
                    blue = (int)(average * 0.7);
                }
                else if (average < 190)
                {
                    red = (int)(average * 1.15);
                    green = average;
                    blue = (int)(average * 0.75);
                }
                else
                {
                    red = (int)(average * 1.08);
                    green = (int)(average * 1.05);
                    blue = (int)(average * 0.85);
                }

                pixel.setRed(limit(red));
                pixel.setGreen(limit(green));
                pixel.setBlue(limit(blue));
            }
        }
    }

    public static void edgeDetection(Picture apic, double amount)
    {
        Pixel topPixel = null;
        Pixel bottomPixel = null;

        for (int x = 0; x < apic.getWidth(); x++)
        {
            for (int y = 0; y < apic.getHeight() - 1; y++)
            {
                topPixel = apic.getPixel(x, y);
                bottomPixel = apic.getPixel(x, y + 1);

                if (Math.abs(colorAverage(topPixel) - colorAverage(bottomPixel)) < amount)
                {
                    topPixel.setRed(255);
                    topPixel.setGreen(255);
                    topPixel.setBlue(255);
                }
                else
                {
                    topPixel.setRed(0);
                    topPixel.setGreen(0);
                    topPixel.setBlue(0);
                }
            }
        }
    }

    public static void colorReplacement(Picture apic, int startX, int endX,
                                        int startY, int endY,
                                        java.awt.Color color1,
                                        java.awt.Color color2,
                                        double distance)
    {
        Pixel pixel = null;

        for (int x = startX; x < endX && x < apic.getWidth(); x++)
        {
            for (int y = startY; y < endY && y < apic.getHeight(); y++)
            {
                pixel = apic.getPixel(x, y);

                if (colorDistance(pixel, color1) < distance)
                {
                    pixel.setColor(color2);
                }
            }
        }
    }

    public static double colorDistance(Pixel pixel, java.awt.Color color)
    {
        int redDifference = pixel.getRed() - color.getRed();
        int greenDifference = pixel.getGreen() - color.getGreen();
        int blueDifference = pixel.getBlue() - color.getBlue();

        return Math.sqrt(redDifference * redDifference +
                         greenDifference * greenDifference +
                         blueDifference * blueDifference);
    }

    public static int colorAverage(Pixel pixel)
    {
        return (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
    }

    public static int limit(int value)
    {
        if (value < 0)
        {
            return 0;
        }
        if (value > 255)
        {
            return 255;
        }
        return value;
    }

    public static void recursiveScale(Picture source, Picture target,
                                      int startX, int startY,
                                      int newWidth, int newHeight, boolean useWarmTint)
    {
        if (newWidth < 40 || newHeight < 40)
        {
            return;
        }

        copyScaledToCanvas(source, target, startX, startY, newWidth, newHeight, useWarmTint);
        recursiveScale(source, target,
                       startX + newWidth / 4,
                       startY + newHeight / 4,
                       newWidth / 2,
                       newHeight / 2, !useWarmTint);
    }
    
    public static void negate(Picture apic) {
        Pixel pixel = null;
    
        for (int x = 0; x < apic.getWidth(); x++)
        {
            for (int y = 0; y < apic.getHeight(); y++)
            {
                pixel = apic.getPixel(x, y);
                
                pixel.setRed(255 - pixel.getRed());
                pixel.setGreen(255 - pixel.getGreen());
                pixel.setBlue(255 - pixel.getBlue());
            }
        }
    }

    public static void copyScaledToCanvas(Picture source, Picture target,
                                          int startX, int startY,
                                          int newWidth, int newHeight, boolean useWarmTint)
    {
        Pixel sourcePix = null;
        Pixel targetPix = null;

        for (int targetX = 0; targetX < newWidth && startX + targetX < target.getWidth(); targetX++)
        {
            for (int targetY = 0; targetY < newHeight && startY + targetY < target.getHeight(); targetY++)
            {
                int sourceX = targetX * source.getWidth() / newWidth;
                int sourceY = targetY * source.getHeight() / newHeight;
                sourcePix = source.getPixel(sourceX, sourceY);
                targetPix = target.getPixel(startX + targetX, startY + targetY);
                if (useWarmTint) {
                    targetPix.setRed(limit((int)(sourcePix.getRed() * 0.85) + 35));
                    targetPix.setGreen(limit((int)(sourcePix.getGreen() * 0.75) + 20));
                    targetPix.setBlue(limit((int)(sourcePix.getBlue() * 0.65)));
                } 
                else {
                    targetPix.setColor(sourcePix.getColor());
                }
            }
        }
    }

}
