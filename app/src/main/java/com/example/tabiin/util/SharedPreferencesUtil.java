package com.example.tabiin.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtil {

    // This code is written in together with AI Github Copilot

    // create function to save string in shared preferences
    public static void saveString(Context context, String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("tabiin", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    // create function to get string from shared preferences
    public static String getString(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("tabiin", Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, "");
    }

    // create function to save boolean value in shared preferences
    public static void saveBoolean(Context context, String key, boolean value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                "tabiin", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    // create function to load boolean value from shared preferences
    public static boolean loadBoolean(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                "tabiin", Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, false);
    }

    // create function to save int value in shared preferences
    public static void saveInt(Context context, String key, int value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                "tabiin", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    // create function to load int value from shared preferences
    public static int loadInt(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                "tabiin", Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, 0);
    }

    // create function to save float value in shared preferences
    public static void saveFloat(Context context, String key, float value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                "tabiin", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    // create function to load float value from shared preferences
    public static float loadFloat(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                "tabiin", Context.MODE_PRIVATE);
        return sharedPreferences.getFloat(key, 0);
    }
}
