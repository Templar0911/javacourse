package com.templar.javatraining.niocourse01;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OkHttpPractise {

    private final static OkHttpClient client = new OkHttpClient();

    private static String getStringFrom(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();

        String result = "";
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                result = response.body().string();
            } else {
                System.out.println(response.code());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static void main(String[] args) {
        String url = "http://127.0.0.1:8801";
        String result = OkHttpPractise.getStringFrom(url);
        System.out.println("response：" + result);
    }

}
