package com.example.peoplelist;

import androidx.annotation.NonNull;

public class Person implements  Comparable<Person>{

    private String name;
    private int age;
    private int picNumber;

    public Person(String name, int age, int picNumber) {
        this.name = name;
        this.age = age;
        this.picNumber = picNumber;
    }

    // compare to  for sorting
    @Override
    public int compareTo(@NonNull Person other) {
        return this.name.compareTo(other.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPicNumber() {
        return picNumber;
    }

    public void setPicNumber(int picNumber) {
        this.picNumber = picNumber;
    }


}
