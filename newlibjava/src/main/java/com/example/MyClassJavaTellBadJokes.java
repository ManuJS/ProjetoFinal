package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyClassJavaTellBadJokes {


    private List<String> jokeArray;
    public MyClassJavaTellBadJokes(){

        jokeArray = new ArrayList<>();
        jokeArray.add("Where do skunks go to pray?\n" +
                "    The pew!");
        jokeArray.add("How did Hitler tie his shoes?\n" +
                "    In little nazis");
        jokeArray.add("I miss my umbilical cord,\n" +
                "I grew attached to it.");
        jokeArray.add("What are a ninja's favourite type of shoes?\n" +
                "    Sneakers!");
    };

    public static int randInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public String tellRandomJoke() {
        int max = jokeArray.size() - 1;
        int index = randInt(0, max);
        return jokeArray.get(index);

    }

}
