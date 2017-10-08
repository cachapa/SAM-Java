package net.cachapa.samjava.Util;


import android.text.Html;

import net.cachapa.samjava.Gif;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GifLoader {
    public static Gif getGif(String address) {
        try {
            String html = getHtml(address);

            /* Low-budget HTML parsing ahead - it works for now but breaks easily */

            // Get title
            int begin = html.indexOf("<h3>") + 4;
            int end = html.indexOf("</h3>");
            String title = Html.fromHtml(html.substring(begin, end)).toString();

            // Get gif url
            begin = html.indexOf("<img", end) + 10;
            end = html.indexOf("\"", begin);
            String gifUrl = html.substring(begin, end);

            return new Gif(title, gifUrl);
        } catch (Exception e) {
            return new Gif(e);
        }
    }

    private static String getHtml(String address) throws IOException {
        StringBuilder html = new StringBuilder();

        URL url = new URL(address);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                html.append(line);
            }
            br.close();
        } finally {
            urlConnection.disconnect();
        }

        return html.toString();
    }
}
