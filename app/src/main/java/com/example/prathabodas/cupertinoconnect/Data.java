package com.example.prathabodas.cupertinoconnect;

/**
 * Created by prathabodas on 4/9/17.
 */

public class Data {
    private String button = null;

    public boolean isReady() {
        return (button != null);
    }

    public String getButton() { return button; }


    @Override
    public String toString() {
        return "Data [Button=" + button + "]";
    }
}