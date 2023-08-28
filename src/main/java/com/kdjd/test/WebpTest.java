package com.kdjd.test;

import com.luciad.imageio.webp.WebPReadParam;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WebpTest {

    public static void main(String[] args) throws IOException {

        String file1 = "C:\\Users\\kdjdl\\Desktop\\a.png";
        String file2 = "C:/Users/kdjdl/Desktop/b.png";

        System.out.println(ImgeMimeTypeUtil.getMimeType(file1));
        System.out.println(ImgeMimeTypeUtil.getMimeType(file2));


        String outputJpgPath = "C:/Users/kdjdl/Desktop/test_.jpg";
        String outputJpegPath = "C:/Users/kdjdl/Desktop/test_.jpeg";
        String outputPngPath = "C:/Users/kdjdl/Desktop/test_.png";

        // Obtain a WebP ImageReader instance
        ImageReader reader = ImageIO.getImageReadersByMIMEType("image/webp").next();

        // Configure decoding parameters
        WebPReadParam readParam = new WebPReadParam();
        readParam.setBypassFiltering(true);

        // Configure the input on the ImageReader
        reader.setInput(new FileImageInputStream(new File(file2)));

        // Decode the image
        BufferedImage image = reader.read(0, readParam);

        ImageIO.write(image, "png", new File(outputPngPath));
        ImageIO.write(image, "jpg", new File(outputJpgPath));
        ImageIO.write(image, "jpeg", new File(outputJpegPath));


    }
}
