package com.example.tabiin.util;

public class Callback {
    public static void addCallback(com.example.alhamdulillah.CallbackInterface callback){
        com.example.alhamdulillah.CallbackInterface.callbacks.add(callback);
    }
    public static void runAllCallbacks(){
        for(com.example.alhamdulillah.CallbackInterface c : com.example.alhamdulillah.CallbackInterface.callbacks){
            c.call();
        }
    }
}
