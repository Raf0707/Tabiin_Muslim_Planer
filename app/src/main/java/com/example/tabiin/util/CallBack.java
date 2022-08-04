package com.example.tabiin.util;

public class CallBack {
    public static void addCallback(com.example.tabiin.util.CallbackInterface callback){
        com.example.tabiin.util.CallbackInterface.callbacks.add(callback);
    }
    public static void runAllCallbacks(){
        for(com.example.tabiin.util.CallbackInterface c : com.example.tabiin.util.CallbackInterface.callbacks){
            c.call();
        }
    }
}