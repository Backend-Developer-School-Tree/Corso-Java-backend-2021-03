import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class GreenScreen {

    public static void main(String[] args) throws Exception {
        Color greenScreenColor = new Color(40,255,15);
        BufferedImage zeb89Image = ImageIO.read(new File("zeb89.jpg")); //caricamento immagine
        BufferedImage aotImage = ImageIO.read(new File("aot.jpg")); //caricamento immagine

        BufferedImage outputImage = new BufferedImage(zeb89Image.getWidth(), zeb89Image.getHeight(), BufferedImage.TYPE_3BYTE_BGR); // creazione immagine output



        for (int col = 0; col < zeb89Image.getWidth(); col++)
            for (int row = 0; row < zeb89Image.getHeight(); row++) //itero sui pixel dell'immagine
            {
                Color currentPixel = new Color(zeb89Image.getRGB(col, row));

                if (colorDistance(currentPixel, greenScreenColor) > 130)
                    outputImage.setRGB(col, row, zeb89Image.getRGB(col, row));
                else
                    outputImage.setRGB(col, row, aotImage.getRGB(col, row));

            }

        ImageIO.write(outputImage, "jpg", new File("outputImage.jpg"));

    }
        private static double  colorDistance(Color c1, Color c2){
            int redDifference = c1.getRed() - c2.getRed();
            int greenDifference = c1.getGreen() - c2.getGreen();
            int blueDifference = c1.getBlue() - c2.getBlue();
            return Math.sqrt(Math.pow(redDifference, 2) + Math.pow(greenDifference, 2) + Math.pow(blueDifference, 2));
        }
}
