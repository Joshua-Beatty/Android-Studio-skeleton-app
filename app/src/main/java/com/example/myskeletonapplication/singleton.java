package com.example.myskeletonapplication;

public class singleton {
    private static singleton instance = null;
    public static boolean darkMode = false;
    protected singleton() {
        // Exists only to defeat instantiation.
    }
    public static singleton getInstance() {
        if(instance == null) {
            instance = new singleton();
        }
        return instance;
    }
}