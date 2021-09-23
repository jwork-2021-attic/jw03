package example.encoder;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {

    public static void main(String[] args) {

        File imageProvied = new File("bubble.jpeg");
        File fileToEncode = new File("BubbleSorter.class");

        String fileToGenerate = "bubble-sort-gen.png";

        

        BufferedImage image;
        try {
            FileInputStream fin = new FileInputStream(imageProvied);
            System.out.println(fin.available());
            image = ImageIO.read(imageProvied);
            int bitsPerColor = (int) Math.pow(2, 2);
            SteganographyEncoder steganographyEncoder = new SteganographyEncoder(image, bitsPerColor);

            byte[] bytes = steganographyEncoder.decodeByteArray();
            BytesLoader loader = new BytesLoader(Main.class.getClassLoader(), bytes);

            Class classA;
            classA = loader.loadClass("example.BubbleSorter");



            BufferedImage encodedImage = steganographyEncoder.encodeFile(fileToEncode);
            ImageIO.write(encodedImage, "png", new File(fileToGenerate));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
