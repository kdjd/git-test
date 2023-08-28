package com.kdjd.test;

import javax.activation.MimetypesFileTypeMap;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

public class A {

    public static void main(String[] args) throws IOException {
        String file2 = "C:/Users/kdjdl/Desktop/a.png";
        InputStream is = new BufferedInputStream(new FileInputStream(file2));
        String mimeType = URLConnection.guessContentTypeFromStream(is);
        System.out.println(mimeType);

        File file = new File(file2);
        MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();

        mimeType = mimeTypesMap.getContentType(file);
        System.out.println(mimeType);


        file2 = "C:/Users/kdjdl/Desktop/b.png";
        is = new BufferedInputStream(new FileInputStream(file2));
        mimeType = URLConnection.guessContentTypeFromStream(is);
        System.out.println(mimeType);

        file2 = "C:/Users/kdjdl/Desktop/c.jpg";
        is = new BufferedInputStream(new FileInputStream(file2));
        mimeType = URLConnection.guessContentTypeFromStream(is);
        System.out.println(mimeType);

        file2 = "C:/Users/kdjdl/Desktop/d.jpg";
        is = new BufferedInputStream(new FileInputStream(file2));
        mimeType = URLConnection.guessContentTypeFromStream(is);
        System.out.println(mimeType);

    }
}
