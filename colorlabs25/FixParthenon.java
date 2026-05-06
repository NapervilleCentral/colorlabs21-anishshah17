
/**
 * Fixes the right side of the temple roof by mirroring the left side.
 *
 * @author Anish Shah
 * @version 5/6/2026
 */
public class FixParthenon
{
    /**
     * Method to mirror part of the temple picture around a
     * vertical line at the mirror point.
     */
    public static void mirrorTemple(Picture apic)
    {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;

        for (int y = 27; y < 97; y++)
        {
            for (int x = 13; x < mirrorPoint; x++)
            {
                leftPixel = apic.getPixel(x, y);
                rightPixel = apic.getPixel(mirrorPoint + (mirrorPoint - x), y);
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /**
     * Main method to test the fixed temple picture.
     */
    public static void main(String[] args)
    {
        Picture temple = new Picture("images/temple.jpg");
        mirrorTemple(temple);
        temple.write("images/templefixed.jpg");
        temple.explore();
    }
}
