package io.hiker.common.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class StringUtils extends org.apache.commons.lang3.StringUtils {

    public static byte[] compressString(String str) throws IOException {
        byte[] inputBytes = str.getBytes(StandardCharsets.UTF_8);
        Deflater deflater = new Deflater();
        deflater.setInput(inputBytes);
        deflater.finish();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DeflaterOutputStream dos = new DeflaterOutputStream(baos);
        try {
            dos.write(inputBytes);
        } catch (IOException e) {
            throw new RuntimeException("Error while compressing string", e);
        }
        dos.close();
        return baos.toByteArray();
    }

    public static String decompressString(byte[] bytes) {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        InflaterInputStream iis = new InflaterInputStream(bais);
        BufferedReader reader = new BufferedReader(new InputStreamReader(iis, StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while decompressing string", e);
        }
        return sb.toString();
    }
}

