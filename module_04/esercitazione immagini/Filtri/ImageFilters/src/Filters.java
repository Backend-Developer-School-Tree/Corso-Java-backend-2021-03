import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Filters {

    public static void main(String[] args) throws Exception{
        BufferedImage freakedImage = null;
        freakedImage = ImageIO.read(new File("freaked.jpg"));
        ImageIO.write(grayImage(freakedImage), "jpg", new File("gray.jpg"));
        ImageIO.write(mirrorImage(freakedImage), "jpg", new File("mirror.jpg"));
        ImageIO.write(posterizeImage(freakedImage, 3), "jpg", new File("posterized.jpg"));
        ImageIO.write(invertColorImage(freakedImage), "jpg", new File("invert.jpg"));
        ImageIO.write(GBRImage(freakedImage), "jpg", new File("GBR.jpg"));
    }

    public static BufferedImage grayImage(BufferedImage image) {
        BufferedImage outputImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);

        for (int col = 0; col < image.getWidth(); col++)
            for (int row = 0; row < image.getHeight(); row++)
            {
                Color pixel = new Color(image.getRGB(col, row));
                outputImage.setRGB(col, row, getGrayPixel(pixel).getRGB());
            }
        return outputImage;

    }

    public static BufferedImage mirrorImage(BufferedImage image) {
        BufferedImage outputImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_3BYTE_BGR);

        for (int col = 0; col < image.getWidth(); col++)
            for (int row = 0; row < image.getHeight(); row++)
            {
                outputImage.setRGB(image.getWidth() - 1 - col , row, image.getRGB(col, row));
            }
        return outputImage;

    }


    public static BufferedImage posterizeImage(BufferedImage image, int levels) {
        BufferedImage outputImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_3BYTE_BGR);

        int step = 255 / levels;

        for (int col = 0; col < image.getWidth(); col++)
            for (int row = 0; row < image.getHeight(); row++)
            {
                Color pixel = new Color(image.getRGB(col, row));
                outputImage.setRGB(col , row, getPosterizedPixel(pixel, step).getRGB());
            }
        return outputImage;

    }

    public static BufferedImage invertColorImage(BufferedImage image) {
        BufferedImage outputImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_3BYTE_BGR);

        for (int col = 0; col < image.getWidth(); col++)
            for (int row = 0; row < image.getHeight(); row++)
            {
                Color pixel = new Color(image.getRGB(col, row));
                outputImage.setRGB(col , row, invertColor(pixel).getRGB());
            }
        return outputImage;
    }

    public static BufferedImage GBRImage(BufferedImage image) {
        BufferedImage outputImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_3BYTE_BGR);

        for (int col = 0; col < image.getWidth(); col++)
            for (int row = 0; row < image.getHeight(); row++)
            {
                Color pixel = new Color(image.getRGB(col, row));
                outputImage.setRGB(col , row, GBRPixel(pixel).getRGB());
            }
        return outputImage;
    }

    private static Color GBRPixel(Color pixel)
    {
        return new Color(pixel.getGreen(), pixel.getBlue(), pixel.getRed());
    }

    private static Color invertColor(Color pixel)
    {
        int red = 255 - pixel.getRed();
        int green = 255 - pixel.getGreen();
        int blue = 255 - pixel.getBlue();

        return new Color(red, green, blue);
    }

    private static Color getPosterizedPixel(Color pixel, int step)
    {
        int red = pixel.getRed() / step;
        int green = pixel.getGreen() / step;
        int blue = pixel.getBlue() / step;
        return new Color(red * step, green * step, blue * step);
    }

    private static Color getGrayPixel(Color pixel)
    {
        int brightness = (int)(77 * (pixel.getRed() / 255.0) + 150 * (pixel.getGreen() / 255.0) +  28 * (pixel.getBlue() / 255.0));
        return new Color(brightness,brightness,brightness);
    }

}
