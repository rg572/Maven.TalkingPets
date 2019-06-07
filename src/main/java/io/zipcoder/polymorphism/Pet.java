package io.zipcoder.polymorphism;

public abstract class Pet {

    private String name;

    public Pet(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    abstract public String speak();

    abstract public String getType();
}
