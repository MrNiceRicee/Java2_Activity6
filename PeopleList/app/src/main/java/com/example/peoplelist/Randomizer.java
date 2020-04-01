package com.example.peoplelist;

import java.util.Random;

public class Randomizer {

    String[] MaleFirstNames = {"James","John","Robert","Michael", "William","David","Richard","Joseph","Thomas","Charles"};

    String[] FemaleFirstNames = {"Mary","Patricia","Jennifer","Linda","Elizabeth","Barbara","Susan","Jessica","Sarah","Karen"};

    String[] LastNames = {"Smith","Johnson","Williams","Brown","Jones","Miller","Davis","Garcia","Rodriguez","Wilson"};

    Random random = new Random();


    public String MaleName(){
        return (MaleFirstNames[random.nextInt(MaleFirstNames.length)] +" "+ LastNames[random.nextInt(LastNames.length)]).toString();
    }

    public String FemaleName(){
        return(FemaleFirstNames[random.nextInt(FemaleFirstNames.length)] +" "+ LastNames[random.nextInt(LastNames.length)]).toString();
    }
}
