package io.hiker.common.util;

import jakarta.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class HttpUtils {
    public static String getJson(HttpServletRequest request) {
        try {
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder json = new StringBuilder();
            String jsonLine;
            while ((jsonLine = streamReader.readLine()) != null)
                json.append(jsonLine);
            return json.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
