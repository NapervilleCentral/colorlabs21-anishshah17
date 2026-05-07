
/**
 * Anish Shah
 * 5/6/2026
 * AP Computer Science
 * MirrorTemple
 * Mirror the upper part of the Parthenon to fix the broken part, without changing the bottom part
 */
public class FixParthenon
{
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
    public static void main(String[] args)
    {
        Picture temple = new Picture("images/temple.jpg");
        mirrorTemple(temple);
        temple.write("images/templefixed.jpg");
        temple.explore();
    }
}
