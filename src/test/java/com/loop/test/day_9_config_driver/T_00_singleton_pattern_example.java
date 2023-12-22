package com.loop.test.day_9_config_driver;

public class T_00_singleton_pattern_example {

    // private constructor to prevent external instantiation
    private T_00_singleton_pattern_example(){}

    private static String word;

    // public getter
    public static String getWord(){
        if(word==null){
            System.out.println("First time calling, Object is null and assigning now");
            word = "driver";
        } else {
            System.out.println("word is already assigned and has value");
        }
        return word;
    }
}
