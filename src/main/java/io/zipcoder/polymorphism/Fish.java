package io.zipcoder.polymorphism;

public class Fish extends Pet {

    public Fish(String name){
        super(name);
    }
    public String speak() {
        return "Ph'nglui mglw'nafh Cthulhu R'lyeh wgah'nagl fthatgn";
    }

    public String getType() {
        return "fish";
    }
}
