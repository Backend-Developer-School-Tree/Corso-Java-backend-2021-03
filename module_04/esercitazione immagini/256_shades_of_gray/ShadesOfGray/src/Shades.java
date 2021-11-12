import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Shades {


    public static void main(String[] args) throws IOException {

        BufferedImage outputImage = new BufferedImage(1024, 1024, BufferedImage.TYPE_3BYTE_BGR);

        for (int shade = 0; shade < outputImage.getHeight(); shade++)
        {
            Color pixel = new Color(shade,shade,shade);
            outputImage.setRGB(shade,shade, pixel.getRGB());
            for (int j = shade; j >= 0; j--)
            {
                outputImage.setRGB(j,shade, pixel.getRGB());
                outputImage.setRGB(shade,j, pixel.getRGB());
            }
        }
        ImageIO.write(outputImage, "jpg", new File("shades.jpg"));
    }
}
