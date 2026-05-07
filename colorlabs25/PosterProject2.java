public class PosterProject2 {
    public static Picture rotateRight(Picture source) {
        Picture target = new Picture(source.getHeight(), source.getWidth());
        
        for (int x = 0; x < source.getWidth(); x++) {
            for (int y = 0; y < source.getHeight(); y++) {
                Pixel sourcePix = source.getPixel(x, y);
                Pixel targetPix = target.getPixel(source.getHeight() - 1 - y, x);
                targetPix.setColor(sourcePix.getColor());
            }
        }
        return target;
    }

    public static void copyToCanvas(Picture source, Picture target, int startX, int startY) {
        for (int x = 0; x < source.getWidth() && (startX + x)
            < target.getWidth(); x++) {
            for (int y = 0; y < source.getHeight() && (startY + y)
            < target.getHeight(); y++) {
                target.getPixel(startX + x, startY + y).setColor(source.getPixel(x, y).getColor());
            }
        }
    }

    public static void mirrorVertical(Picture apic)
    {
        int width = apic.getWidth();
        int height = apic.getHeight();
        int mirrorPoint = height / 2;
        Pixel leftPixel = null;
        Pixel rightPixel = null;

        for (int y = 0; y < apic.getWidth(); y++)
        {
            for (int x = 0; x < mirrorPoint; x++)
            {
                leftPixel = apic.getPixel(y, x);
                rightPixel = apic.getPixel(y, width - 1 - x);
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
    
    
    
    public static void main(String[] args) {
        Picture lolla = new Picture("images/lolla.jpg");
        
        Picture rotatedLolla = rotateRight(lolla);
        int rotatedWidth = rotatedLolla.getWidth();
        Picture canvas = new Picture("images/lollacanvas.jpg");
        copyToCanvas(rotatedLolla, canvas, 0, 0);
        
        Picture mirroredLolla = new Picture(lolla);
        mirrorVertical(mirroredLolla);
        Picture rotatemirrorLolla = rotateRight(mirroredLolla);
        

        copyToCanvas(rotatemirrorLolla, canvas, rotatedWidth, 0);

        canvas.write("images/lollacollage.jpg");
        canvas.explore();
    }
}



/*
    public static void mirrorVertical(Picture apic)
    {
        int width = apic.getWidth();
        int height = apic.getHeight();
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
    */