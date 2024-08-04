package com.example.sqlite_sugarormexample;

import com.orm.SugarRecord;

public class Person extends SugarRecord {
    public Person(){

    }
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
