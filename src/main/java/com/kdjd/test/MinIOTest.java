package com.kdjd.test;

import io.minio.MinioClient;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidArgumentException;
import io.minio.errors.InvalidBucketNameException;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.NoResponseException;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class MinIOTest {

    public static void main(String[] args) throws InvalidPortException, InvalidEndpointException, IOException,
            XmlPullParserException, NoSuchAlgorithmException, InvalidKeyException, InvalidArgumentException,
            InternalException, NoResponseException, InvalidBucketNameException, InsufficientDataException,
            ErrorResponseException {
        MinioClient client = new MinioClient("http://127.0.0.1:9090", "minio", "minio@123");
        String bucketName = "test";
        String source = "/a/b/c/d/1.txt";
        String target = "/a/b/c/d/3.txt";

        try {
            client.copyObject(bucketName, source, bucketName, target);
            client.removeObject(bucketName, source);
        } catch (InvalidResponseException e) {
            throw new RuntimeException(e);
        }
    }
}
