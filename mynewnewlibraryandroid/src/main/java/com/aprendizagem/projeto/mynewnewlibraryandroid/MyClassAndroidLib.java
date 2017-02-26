package com.aprendizagem.projeto.mynewnewlibraryandroid;

import com.example.MyClassJava;

import java.util.Random;

/**
 * Created by emanu on 24/02/2017.
 */

public class MyClassAndroidLib {
    MyClassJava myClassJavaLib = new MyClassJava();

    public int c = myClassJavaLib.jokeArray.length;


    Random gerador = new Random();

    int numero = gerador.nextInt(c);

    public String joke = myClassJavaLib.jokeArray[numero];

}
