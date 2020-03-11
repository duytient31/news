package com.example.news_project.utils;

public class StringUtils {
    public static String getImageUrl(String image_path) {
        return new StringBuilder().append(image_path).toString();
    }
}
