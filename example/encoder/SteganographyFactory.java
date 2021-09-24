package example.encoder;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import java.awt.image.BufferedImage;

public class SteganographyFactory {

    private static void compile(String classSource) {

        File sourceFile = new File(classSource);
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, sourceFile.getPath());
    }

    public static void getSteganography(String classSource, String originImage) throws IOException {
        String className = classSource.substring(0, classSource.indexOf(".")).replace("/", ".");
        SteganographyFactory.compile(classSource);
        BufferedImage image = ImageIO.read(new File(originImage));
        SteganographyEncoder steganographyEncoder = new SteganographyEncoder(image);

        BufferedImage encodedImage = steganographyEncoder.encodeFile(new File(classSource.replace("java", "class")));
        ImageIO.write(encodedImage, "png", new File(className+".png"));

    }

    public static void main(String[] args) throws IOException {

        SteganographyFactory.getSteganography("example/BubbleSorter.java","example/resources/bubble.jpeg");

        // File imageProvied = new File("bubble.jpeg");
        // File fileToEncode = new File("BubbleSorter.class");

        // String fileToGenerate = "bubble-sort-gen.png";

        // BufferedImage image;
        // try {
        // FileInputStream fin = new FileInputStream(imageProvied);
        // System.out.println(fin.available());
        // image = ImageIO.read(imageProvied);
        // int bitsPerColor = (int) Math.pow(2, 2);
        // SteganographyEncoder steganographyEncoder = new SteganographyEncoder(image,
        // bitsPerColor);

        // byte[] bytes = steganographyEncoder.decodeByteArray();
        // BytesLoader loader = new BytesLoader(Main.class.getClassLoader(), bytes);

        // Class classA;
        // classA = loader.loadClass("example.BubbleSorter");

        // BufferedImage encodedImage = steganographyEncoder.encodeFile(fileToEncode);
        // ImageIO.write(encodedImage, "png", new File(fileToGenerate));
        // } catch (IOException e) {
        // e.printStackTrace();
        // } catch (ClassNotFoundException e) {
        // e.printStackTrace();
        // }

    }

}
