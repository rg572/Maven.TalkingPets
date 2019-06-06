package io.zipcoder.polymorphism;

public class Pet {

    private String name;
    private String type;

    public Pet(String type, String name){
        this.type = type;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }
}
